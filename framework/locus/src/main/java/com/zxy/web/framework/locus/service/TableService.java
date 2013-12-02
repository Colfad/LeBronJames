package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.Column;
import com.zxy.web.framework.locus.model.TableEntity;
import com.zxy.web.framework.locus.repository.jpa.TableEntityDao;
import com.zxy.web.framework.locus.repository.mybatis.TableEntityMyBatisDao;
import com.zxy.web.module.core.orm.util.DynamicSpecifications;
import com.zxy.web.module.core.orm.util.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Table 表的操作service
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class TableService {

    private TableEntityMyBatisDao tableEntityMyBatisDao;

    private TableEntityDao tableEntityDao;

    public TableEntityMyBatisDao getTableEntityMyBatisDao() {
        return tableEntityMyBatisDao;
    }

    @Autowired
    public void setTableEntityMyBatisDao(TableEntityMyBatisDao tableEntityMyBatisDao) {
        this.tableEntityMyBatisDao = tableEntityMyBatisDao;
    }

    public TableEntityDao getTableEntityDao() {
        return tableEntityDao;
    }

    @Autowired
    public void setTableEntityDao(TableEntityDao tableEntityDao) {
        this.tableEntityDao = tableEntityDao;
    }

    public Page<TableEntity> getTableEntityByPage(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                                  String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<TableEntity> spec = buildSpecification(searchParams);
        return tableEntityDao.findAll(spec, pageRequest);
    }

    private Specification<TableEntity> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<TableEntity> spec = DynamicSpecifications.bySearchFilter(filters.values(), TableEntity.class);
        return spec;
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "createDate");
        } else if ("menuName".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "menuName");
        }

        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    public List<TableEntity> findAllTableEntity() {
        return (List<TableEntity>) tableEntityDao.findAll();
    }


    /**
     * 获得一个TABLE下面的所有Column
     *
     * @param tableId table 的id
     * @return 所有Table下面的column
     */
    public List<Column> findAllTablesColumn(String tableId) {
        List<Column> list = tableEntityMyBatisDao.findTableColumns(tableId);
        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTableData(TableEntity tableEntity) {
        tableEntityDao.save(tableEntity);
        Map<String, String> map = new HashMap<String, String>();
        map.put("tableName", tableEntity.getTableName());
        tableEntityMyBatisDao.createTable(map);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveRealTable(String tableName) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("tableName", tableName);
        tableEntityMyBatisDao.createTable(map);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTable(TableEntity tableEntity) {
        tableEntityDao.save(tableEntity);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTableAndRealTable(TableEntity tableEntity, String oldName) {
        tableEntityDao.save(tableEntity);
        Map<String, String> map = new HashMap<String, String>();
        map.put("oldName", oldName);
        map.put("newName", tableEntity.getTableName());
        tableEntityMyBatisDao.renameTable(map);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(String id) {
        tableEntityDao.delete(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(String id, String tableName) {
        tableEntityDao.delete(id);

        Map<String, String> map = new HashMap<String, String>();
        map.put("tableName", tableName);
        tableEntityMyBatisDao.deleteTable(map);

    }

    public TableEntity getTableEntity(String id) {
        return tableEntityDao.findOne(id);
    }

}
