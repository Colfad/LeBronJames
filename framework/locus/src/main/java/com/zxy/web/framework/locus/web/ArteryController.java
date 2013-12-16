package com.zxy.web.framework.locus.web;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.zxy.web.framework.locus.model.*;
import com.zxy.web.framework.locus.service.*;
import com.zxy.web.module.core.info.OperateInfo;
import com.zxy.web.module.core.orm.FixEntityUtil;
import com.zxy.web.module.core.web.Servlets;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 颅内肿瘤
 *
 * @author James
 */
@Controller
@RequestMapping("/artery")
public class ArteryController {
    private static final String PAGE_SIZE = "5";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

    private ArteryService arteryService;
    private ArteryClinicService arteryClinicService;
    private ArteryDescribService arteryDescribService;
    private ArteryCoilService arteryCoilService;
    private ArteryTreatService arteryTreatService;
    private ArteryVisitService arteryVisitService;

    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("patientName", "患者姓名");
    }

    @RequestMapping("")
    public String toArteryPage(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                 @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                                 @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                                 Model model, ServletRequest request) throws UnsupportedEncodingException {

        Map<String, Object> searchParam = Servlets.getParametersStartingWith(request, "search_");
        Page<Artery> arteries = arteryService.getArteryByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("arteries", arteries);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        // 这里是为左侧的菜单激活的情况需要你自行进行修改的,菜单这里我们是不进行修改的操作
        model.addAttribute("arteryInfoActive", "active");

        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "artery/arteryList";
    }

    @RequestMapping("delete/{id}")
    public String deleteArtery(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        arteryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Great.. 删除患者信息成功!   此信息还有<strong id=\"timeLine\" style=\"color:red\">3</strong>秒关闭!!!");
        return "redirect:/artery";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("artery", new Artery());
        model.addAttribute("action", "create");
        model.addAttribute("arteryInfoActive", "active");
        return "artery/arteryForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid Artery artery, RedirectAttributes redirectAttributes, @RequestParam("id") String id) {
        FixEntityUtil.fixEntity(artery);
        arteryService.save(artery);
        redirectAttributes.addFlashAttribute("message", "Great.. 创建患者信息成功!   此信息还有<strong id=\"timeLine\" style=\"color:red\">3</strong>秒关闭!!!");
        return "redirect:/artery";
    }

    @RequestMapping(value = "deleteList", method = RequestMethod.POST)
    public @ResponseBody OperateInfo deleteByList(@RequestParam("ids") String ids) {
//        List<String> list = ImmutableList.copyOf(StringUtils.split(ids, ","));
        OperateInfo operateInfo = new OperateInfo();

        try {
            arteryService.deleteByIds(ids);
            operateInfo.setOperateMessage("删除信息成功!!!");
            operateInfo.setOperateSuccess(true);
            operateInfo.setOperateSuccessUrl("/artery");
        } catch (Exception e) {
            operateInfo.setOperateMessage("删除信息失败!!!");
            operateInfo.setOperateSuccess(false);
        }

        return operateInfo;

    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("artery", arteryService.getArtery(id));
        model.addAttribute("action", "update");
        model.addAttribute("arteryInfoActive", "active");
        return "artery/arteryForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("artery") Artery artery, RedirectAttributes redirectAttributes) {
        arteryService.save(artery);
        redirectAttributes.addFlashAttribute("message", "Great.. 保存患者信息成功!   此信息还有<strong id=\"timeLine\" style=\"color:red\">3</strong>秒关闭!!!");
        return "redirect:/artery";
    }

    @RequestMapping(value = "toDescribForm/{id}/describ/", method = RequestMethod.GET)
    public String toDescribForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
        model.addAttribute("describVar", new ArteryDescrib());
        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryDescribForm";
    }

    @RequestMapping(value = "toCoilForm/{id}/coil/", method = RequestMethod.GET)
    public String toCoilForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
        model.addAttribute("coilVar", new ArteryCoil());
        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryCoilForm";

    }

    @RequestMapping(value = "toTreatForm/{id}/treat", method = RequestMethod.GET)
    public String toTreatForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
        model.addAttribute("treatVar", new ArteryTreat());
        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryTreatForm";
    }

    @RequestMapping(value = "toTreatForm/{id}/treat/{treatId}", method = RequestMethod.GET)
    public String toTreatForm(@PathVariable("id") String id, @PathVariable("treatId") String treatId,
                              Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
        model.addAttribute("treatVar", arteryTreatService.getArteryTreat(treatId));
        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryTreatForm";
    }

    @RequestMapping(value = "saveOrUpdateTreatInfo", method = RequestMethod.POST)
    public String saveOrUpdateTreatForm(@Valid ArteryTreat arteryTreat, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(arteryTreat);
        arteryTreatService.save(arteryTreat);
        Artery artery = arteryService.getArtery(arteryTreat.getParent().getId());
        artery.setArteryTreat(arteryTreat);
        arteryService.save(artery);

        redirectAttributes.addFlashAttribute("message", "Great ... 添加颅内肿瘤病患治疗信息成功!!!   此信息还有<strong id=\"timeLine\" style=\"color:red\">3</strong>秒关闭!!!");

        return "redirect:/artery";
    }

    @RequestMapping(value = "toCoilForm/{id}/coil/{coilId}", method = RequestMethod.GET)
    public String toCoilForm(@PathVariable("id") String id, @PathVariable("coilId") String coilId,
                             Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
        model.addAttribute("coilVar", arteryCoilService.getArteryCoil(coilId));
        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryCoilForm";
    }

    @RequestMapping(value = "saveOrUpdateCoilInfo", method = RequestMethod.POST)
    public String saveOrUpdateCoil(@Valid ArteryCoil arteryCoil, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(arteryCoil);
        arteryCoilService.save(arteryCoil);
        Artery artery = arteryService.getArtery(arteryCoil.getParent().getId());
        artery.setArteryCoil(arteryCoil);
        arteryService.save(artery);

        redirectAttributes.addFlashAttribute("message", "Great ... 保存颅内肿瘤Coil信息成功!!!  此信息还有<strong id=\"timeLine\" style=\"color:red\">3</strong>秒关闭!!!");
        return "redirect:/artery";
    }

    @RequestMapping(value = "toDescribForm/{id}/describ/{describId}", method = RequestMethod.GET)
    public String toDescribForm(@PathVariable("id") String id, @PathVariable("describId") String describId,
                                Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
        model.addAttribute("describVar", arteryDescribService.getArteryDescrib(describId));
        model.addAttribute("arteryInfoActive", "active");
        return "artery/arteryDescribForm";
    }

    @RequestMapping(value = "saveOrUpdateDescribInfo", method = RequestMethod.POST)
    public String saveOrUpdateDescrib(@Valid ArteryDescrib arteryDescrib, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(arteryDescrib);
        arteryDescribService.save(arteryDescrib);
        Artery artery = arteryService.getArtery(arteryDescrib.getParent().getId());
        artery.setArteryDescrib(arteryDescrib);
        arteryService.save(artery);

        redirectAttributes.addFlashAttribute("message", "Great ... 添加颅内病患肿瘤描述信息成功!!!   此信息还有<strong id=\"timeLine\" style=\"color:red\">3</strong>秒关闭!!!");
        return "redirect:/artery";
    }

    /**
     * 添加或者更新治疗信息，这里就是判断clinicId是否为空或者为null就可以了
     *
     * @param id 颅内肿瘤患者信息的id
     * @param clinicId 治疗信息ID
     * @param model
     * @return
     */
    @RequestMapping(value = "toClinicForm/{id}/clinic/{clinicId}", method = RequestMethod.GET)
    public String toClinicForm(@PathVariable("id") String id, @PathVariable("clinicId") String clinicId, Model model) {

        // 直接将病患的信息返回到页面上去
        model.addAttribute("arteryVar", arteryService.getArtery(id));
//        model.addAttribute("arteryId", id);
        model.addAttribute("clinicVar", arteryClinicService.getArteryClinic(clinicId));

        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryClinicForm";
    }

    /**
     * 添加治疗信息时
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "toClinicForm/{id}/clinic/", method = RequestMethod.GET)
    public String toClinicCreateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
//        model.addAttribute("arteryId", id);
        model.addAttribute("clinicVar", new ArteryClinic());
        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryClinicForm";
    }

    @RequestMapping(value = "toVisitForm/{id}/visit/", method = RequestMethod.GET)
    public String toVisitForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
        model.addAttribute("visitVar", new ArteryVisit());
        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryVisitForm";
    }

    @RequestMapping(value = "toVisitForm/{id}/visit/{visitId}", method = RequestMethod.GET)
    public String toVisitForm(@PathVariable("id") String id, @PathVariable("visitId") String visitId,
                              Model model) {
        model.addAttribute("arteryVar", arteryService.getArtery(id));
        model.addAttribute("visitVar", arteryVisitService.getArteryVisit(visitId));
        model.addAttribute("arteryInfoActive", "active");

        return "artery/arteryVisitForm";
    }

    @RequestMapping(value = "saveOrUpdateVisit", method = RequestMethod.POST)
    public String saveOrUpdateVisitInfo(@Valid ArteryVisit arteryVisit, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(arteryVisit);
        arteryVisitService.save(arteryVisit);
        Artery artery = arteryService.getArtery(arteryVisit.getParent().getId());
        artery.setArteryVisit(arteryVisit);
        arteryService.save(artery);

        redirectAttributes.addFlashAttribute("message", "Great ... 保存随访信息成功!!!  此信息还有<strong id=\"timeLine\" style=\"color:red\">3</strong>秒关闭!!!");
        return "redirect:/artery";
    }

    /**
     *
     * 添加或者更新颅内肿瘤病患的治疗信息
     *
     * @param arteryClinic
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "saveOrUpdateClinicInfo", method = RequestMethod.POST)
    public String saveOrUpdatClinicInfo(@Valid ArteryClinic arteryClinic, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(arteryClinic);
        arteryClinicService.save(arteryClinic);
        Artery artery = arteryService.getArtery(arteryClinic.getParent().getId());
        artery.setArteryClinic(arteryClinic);
        arteryService.save(artery);
        redirectAttributes.addFlashAttribute("message", "Great !!! 添加病患治疗信息成功!!!!!   此信息还有<strong id=\"timeLine\" style=\"color:red\">3</strong>秒关闭!!!");
        return "redirect:/artery";
    }

    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.reset();
        String exportDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String exportName = "颅内肿瘤病患信息" + exportDate + ".xls";
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String(exportName.getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(this.getExcelInputStream());
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;

            // 将数据向客户端去写数据
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }

    }

    private InputStream getExcelInputStream() {
        List<Artery> list = arteryService.findAll();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet hs = wb.createSheet();
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 30);
        cellStyle.setFont(font);

        HSSFCellStyle titleCellStyle = wb.createCellStyle();
        titleCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = wb.createFont();
        titleFont.setFontName("黑体");
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        titleFont.setFontHeightInPoints((short) 12);
        titleCellStyle.setFont(titleFont);

        HSSFCellStyle normCellStyle = wb.createCellStyle();
        normCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        normCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);


        // 创建总的标题
        HSSFRow title = hs.createRow(0);
        HSSFCell titleCell = title.createCell(0);
        titleCell.setCellStyle(cellStyle);
        titleCell.setCellValue("颅内肿瘤病患信息");
        hs.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));

        // 创建第一层标题
        HSSFRow titleRow = hs.createRow(1);
        HSSFCell cell = titleRow.createCell(0);
        cell.setCellValue("ID号");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(1);
        cell.setCellValue("住院号");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(2);
        cell.setCellValue("姓名");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(3);
        cell.setCellValue("性别");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(4);
        cell.setCellValue("年龄");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(5);
        cell.setCellValue("家庭地址");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(6);
        cell.setCellValue("联系方式");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(7);
        cell.setCellValue("高血压（Y/N)");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(8);
        cell.setCellValue("糖尿病（Y/N)");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(9);
        cell.setCellValue("高血脂（Y/N)");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(10);
        cell.setCellValue("心脏病（Y/N)");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(11);
        cell.setCellValue("抽烟（Y/N)");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(12);
        cell.setCellValue("酗酒（Y/N)");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(13);
        cell.setCellValue("家族史（Y/N)");
        cell.setCellStyle(titleCellStyle);

        HSSFRow normRow = null;

        int i = 2;
        for (Iterator<Artery> iterator = list.iterator(); iterator.hasNext();) {
            Artery artery = iterator.next();
            normRow = hs.createRow(i);
            cell = normRow.createCell(0);
            cell.setCellValue(artery.getId());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(1);
            cell.setCellValue(artery.getPatientName());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(2);
            cell.setCellValue(artery.getPatientName());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(3);
            cell.setCellValue(artery.isPatientSex() == true ? "男" : "女");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(4);
            cell.setCellValue(artery.getPatientAge());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(5);
            cell.setCellValue(artery.getPatientAddress());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(6);
            cell.setCellValue(artery.getPatientMobile());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(7);
            cell.setCellValue(artery.isHighBloodPressure() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(8);
            cell.setCellValue(artery.isGlycuresis() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(9);
            cell.setCellValue(artery.isBloodFat() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(10);
            cell.setCellValue(artery.isHeartDisease() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(11);
            cell.setCellValue(artery.isSmoking() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(12);
            cell.setCellValue(artery.isDrink() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(13);
            cell.setCellValue(artery.isFamilyHistory() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            i ++;

        }

        for (int j = 0; j <= 13; j++) {
            hs.autoSizeColumn(j);
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);

        return is;
    }

    @ModelAttribute()
    public void getArtery(@RequestParam(value = "id", required = false) String id, Model model) {
        if (id != null && !id.trim().equals("")) {
            model.addAttribute("artery", arteryService.getArtery(id));
        }
    }

    public ArteryService getArteryService() {
        return arteryService;
    }

    @Autowired
    public void setArteryService(ArteryService arteryService) {
        this.arteryService = arteryService;
    }

    public ArteryClinicService getArteryClinicService() {
        return arteryClinicService;
    }

    @Autowired
    public void setArteryClinicService(ArteryClinicService arteryClinicService) {
        this.arteryClinicService = arteryClinicService;
    }

    public ArteryDescribService getArteryDescribService() {
        return arteryDescribService;
    }

    @Autowired
    public void setArteryDescribService(ArteryDescribService arteryDescribService) {
        this.arteryDescribService = arteryDescribService;
    }

    public ArteryCoilService getArteryCoilService() {
        return arteryCoilService;
    }

    @Autowired
    public void setArteryCoilService(ArteryCoilService arteryCoilService) {
        this.arteryCoilService = arteryCoilService;
    }

    public ArteryTreatService getArteryTreatService() {
        return arteryTreatService;
    }

    @Autowired
    public void setArteryTreatService(ArteryTreatService arteryTreatService) {
        this.arteryTreatService = arteryTreatService;
    }

    public ArteryVisitService getArteryVisitService() {
        return arteryVisitService;
    }

    @Autowired
    public void setArteryVisitService(ArteryVisitService arteryVisitService) {
        this.arteryVisitService = arteryVisitService;
    }
}
