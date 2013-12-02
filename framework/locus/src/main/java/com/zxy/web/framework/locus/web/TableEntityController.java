package com.zxy.web.framework.locus.web;

import com.google.common.collect.Maps;
import com.zxy.web.framework.locus.model.Column;
import com.zxy.web.framework.locus.model.TableEntity;
import com.zxy.web.framework.locus.service.ColumnService;
import com.zxy.web.framework.locus.service.TableService;
import com.zxy.web.module.core.orm.FixEntityUtil;
import com.zxy.web.module.core.web.Servlets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Table Entity Controller类，有单独要进行实体表的创建
 *
 * @author James
 */
@Controller
@RequestMapping("/table")
public class TableEntityController {
    private static final String PAGE_SIZE = "10";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

    private TableService tableService;
    private ColumnService columnService;

    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("tableName", "表名");
    }

    @RequestMapping("")
    public String toTablePage(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                              @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                              @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                              Model model, ServletRequest request) throws UnsupportedEncodingException {
        Map<String, Object> searchParam = Servlets.getParametersStartingWith(request, "search_");
        Page<TableEntity> tables = tableService.getTableEntityByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("tables", tables);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        model.addAttribute("tableActive", "active");
        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "table/tableList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createTable(Model model) {
        model.addAttribute("tableVar", new TableEntity());
        model.addAttribute("action", "create");
        model.addAttribute("tableActive", "active");

        return "table/tableForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid TableEntity tableEntity, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(tableEntity);
        tableService.saveTableData(tableEntity);
        redirectAttributes.addFlashAttribute("message", "Great ... 创建表成功!!!");
        return "redirect:/table";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("tableVar", tableService.getTableEntity(id));
        model.addAttribute("action", "update");
        model.addAttribute("tableActive", "active");

        return "table/tableForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("tableVar") TableEntity tableEntity,
                         @RequestParam("oldName") String oldName, RedirectAttributes redirectAttributes) {
        tableService.updateTableAndRealTable(tableEntity, oldName);
        redirectAttributes.addFlashAttribute("message", "Great... 更新表成功!!!");

        return "redirect:/table";
    }

    @ModelAttribute
    public void getTableEntity(@RequestParam(value = "id", required = false) String id, Model model) {
        if (id != null && !id.trim().equals("")) {
            model.addAttribute("tableVar", tableService.getTableEntity(id));
        }
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {

        TableEntity entity = tableService.getTableEntity(id);

        // 如果使用 tableService.delete(id); 这个方法的话则不会将真实的表进行删除的操作
        // 使用下面的方法也会将真实的表进行删除操作。那么原来表里面的数据也会随之消失
        tableService.delete(id, entity.getTableName());

        redirectAttributes.addFlashAttribute("message", "Great ... 删除表成功!!!");
        return "redirect:/table";
    }

    @RequestMapping(value = "manageColumn/{tableId}", method = RequestMethod.GET)
    public String toAddColumnPage(@PathVariable("tableId") String tableId, Model model) {
        model.addAttribute("column", new Column());
        model.addAttribute("tableActive", "active");
        model.addAttribute("tableId", tableId);
        model.addAttribute("columnVars", columnService.findAllColumnByTable(tableId));

        return "table/columnManage";
    }

    @RequestMapping(value = "manageColumn", method = RequestMethod.POST)
    public String addColumn(@Valid Column column, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(column);
        String tableId = column.getTable().getId();
        String tableName = tableService.getTableEntity(tableId).getTableName();
        columnService.save(column, tableName);
        redirectAttributes.addFlashAttribute("message", "Great ... 新增表字段成功 !!!");
        return "redirect:/table/manageColumn/" + tableId;
    }


    public TableService getTableService() {
        return tableService;
    }

    @Autowired
    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }

    public ColumnService getColumnService() {
        return columnService;
    }

    @Autowired
    public void setColumnService(ColumnService columnService) {
        this.columnService = columnService;
    }
}
