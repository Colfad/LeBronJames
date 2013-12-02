package com.zxy.web.framework.locus.web;


import com.google.common.collect.Maps;
import com.zxy.web.framework.locus.model.*;
import com.zxy.web.framework.locus.service.*;
import com.zxy.web.module.core.orm.FixEntityUtil;
import com.zxy.web.module.core.web.Servlets;
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

@Controller
@RequestMapping(value = "/icterus")
public class IcterusController {

    private static final String PAGE_SIZE = "5";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

    private IcterusService icterusService;
    private IcterusOperateService icterusOperateService;
    private IcterusVisitService icterusVisitService;
    private IcterusBloodService icterusBloodService;
    private IcterusImmuneService icterusImmuneService;
    private IcterusTumorService icterusTumorService;
    private IcterusBiologicalService icterusBiologicalService;
    private IcterusPicService icterusPicService;

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
        Page<Icterus> icteruses = icterusService.getIcterusByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("icteruses", icteruses);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        model.addAttribute("icterusActive", "active");

        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "icterus/icterusList";
    }

    @RequestMapping("delete/{id}")
    public String deleteIctuers(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        icterusService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Great ... 删除患者信息成功!!!");
        return "redirect:/icterus";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("icterus", new Icterus());
        model.addAttribute("action", "create");
        model.addAttribute("icterusActive ", "active");

        return "icterus/icterusForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid Icterus icterus, RedirectAttributes redirectAttributes, @RequestParam("id") String id) {
        System.out.println(id);
        FixEntityUtil.fixEntity(icterus);
        icterusService.save(icterus);
        redirectAttributes.addFlashAttribute("message", "Great.. 创建患者信息成功!");
        return "redirect:/icterus";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("icterus", icterusService.getIcterus(id));
        model.addAttribute("action", "update");
        model.addAttribute("icterusActive", "active");
        return "icterus/icterusForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("icterus") Icterus icterus, RedirectAttributes redirectAttributes) {
        icterusService.save(icterus);
        redirectAttributes.addFlashAttribute("message", "Great.. 保存患者信息成功!");
        return "redirect:/icterus";
    }

    @RequestMapping(value = "toIcterusPicForm/{id}/pic/", method = RequestMethod.GET)
    public String toIcterusPicForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("icterus", icterusService.getIcterus(id));
        model.addAttribute("icterusPic", new IcterusPic());
        model.addAttribute("icterusActive", "active");

        return "/icterus/icterusPicForm";
    }

    @RequestMapping(value = "toIcterusPicForm/{id}/pic/{picId}", method = RequestMethod.GET)
    public String toIcterusPicForm(@PathVariable("id") String id, @PathVariable("picId") String picId,
                                   Model model) {
        model.addAttribute("icterus", icterusService.getIcterus(id));
        model.addAttribute("icterusPic", icterusPicService.getIcterusPic(picId));
        model.addAttribute("icterusActive", "active");

        return "/icterus/icterusPicForm";

    }

    @RequestMapping(value = "saveOrUpdateIcterusPic", method = RequestMethod.POST)
    public String saveOrUpdatePicInfo(@Valid IcterusPic icterusPic, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(icterusPic);
        icterusPicService.save(icterusPic);
        Icterus icterus = icterusService.getIcterus(icterusPic.getParent().getId());
        icterus.setIcterusPic(icterusPic);
        icterusService.save(icterus);

        redirectAttributes.addFlashAttribute("message", "Great ... 保存病患影像信息成功!!!");

        return "redirect:/icterus";
    }

    @RequestMapping(value = "toIcterusBiologicalForm/{id}", method = RequestMethod.GET)
    public String toIcterusBiologicalForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("icterus", icterusService.getIcterus(id));
        List<IcterusBiological> icterusBiologicalList = icterusBiologicalService.findAllByParentId(id);
        model.addAttribute("icterusBiologicalList", icterusBiologicalList);
        model.addAttribute("icterusActive", "active");

        return "/icterus/icterusBiologicalForm";
    }

    @RequestMapping(value = "saveOrUpdateBiological", method = RequestMethod.POST)
    public String saveOrUpdateIcterusBiological(@Valid IcterusBiological icterusBiological) {
        icterusBiologicalService.save(icterusBiological);

        return "redirect:/icterus/toIcterusBiologicalForm/" + icterusBiological.getParent().getId();
    }

    /**
     * 这里是获得相应的IcterusBioglogical信息
     * 使用的是json的格式，AJAX返回给页面上去，页面再进行相应的解析操作
     *
     * @param id
     * @return
     */
    @RequestMapping("getIcterusBiologicalInfo")
    @ResponseBody
    public IcterusBiological getIcterusBiologicalInfo(@RequestParam("id") String id) {
        return icterusBiologicalService.getIcterusBiological(id);
    }

    @RequestMapping(value = "toIcterusBloodForm/{id}", method = RequestMethod.GET)
    public String toIcterusBloodForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("icterus", icterusService.getIcterus(id));
        List<IcterusBlood> icterusBloods = icterusBloodService.findAllByParentId(id);
        model.addAttribute("icterusBloods", icterusBloods);
        model.addAttribute("icterusActive", "active");

        return "/icterus/icterusBloodForm";
    }

    @RequestMapping(value = "saveOrUpdateIcterusBlood", method = RequestMethod.POST)
    public String saveOrUpdateIcterusBlood(@Valid IcterusBlood icterusBlood) {
        icterusBloodService.save(icterusBlood);

        return "redirect:/icterus/toIcterusBloodForm/" + icterusBlood.getParent().getId();
    }

    @RequestMapping("getIcterusBlood")
    @ResponseBody
    public IcterusBlood getIcterusBlood(@RequestParam("id") String id) {
        return icterusBloodService.getIcterusBlodd(id);
    }

    @RequestMapping(value = "toIcterusImmune/{id}", method = RequestMethod.GET)
    public String toIcterusImmuneForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("icterus", icterusService.getIcterus(id));
        List<IcterusImmune> icterusImmunes = icterusImmuneService.findAllByParentId(id);
        model.addAttribute("icterusImmunes", icterusImmunes);
        model.addAttribute("icterusActive", "active");

        return "/icterus/icterusImmuneForm";
    }

    @RequestMapping(value = "saveOrUpdateIcterusImmune", method = RequestMethod.POST)
    public String saveOrUpdateIcterusImmune(@Valid IcterusImmune icterusImmune) {
        icterusImmuneService.save(icterusImmune);

        return "redirect:/icterus/toIcterusImmune/" + icterusImmune.getParent().getId();
    }

    @RequestMapping("getIcterusImmune")
    @ResponseBody
    public IcterusImmune getIcterusImmune(@RequestParam("id") String id) {
        return icterusImmuneService.getIcterusImmune(id);
    }

    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.reset();
        String exportDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String exportName = "梗阻性黄疸病患信息" + exportDate + ".xls";
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
        List<Icterus> list = icterusService.findAll();
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
        titleCell.setCellValue("梗阻性黄疸病患信息");
        hs.addMergedRegion(new CellRangeAddress(0, 0, 0, 26));

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
        cell = titleRow.createCell(14);
        cell.setCellValue("邮政编码");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(15);
        cell.setCellValue("入院时间");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(16);
        cell.setCellValue("体重");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(17);
        cell.setCellValue("身高");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(18);
        cell.setCellValue("手术史");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(19);
        cell.setCellValue("其他病史");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(20);
        cell.setCellValue("体能评分");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(21);
        cell.setCellValue("疼痛评分");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(22);
        cell.setCellValue("临床诊断");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(23);
        cell.setCellValue("诊断依据");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(24);
        cell.setCellValue("肿瘤类型");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(25);
        cell.setCellValue("治疗分组");
        cell.setCellStyle(titleCellStyle);
        cell = titleRow.createCell(26);
        cell.setCellValue("研究单位");
        cell.setCellStyle(titleCellStyle);

        HSSFRow normRow = null;

        int i = 2;
        for (Iterator<Icterus> iterator = list.iterator(); iterator.hasNext();) {
            Icterus icterus = iterator.next();
            normRow = hs.createRow(i);
            cell = normRow.createCell(0);
            cell.setCellValue(icterus.getId());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(1);
            cell.setCellValue(icterus.getPatientName());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(2);
            cell.setCellValue(icterus.getPatientName());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(3);
            cell.setCellValue(icterus.isPatientSex() == true ? "男" : "女");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(4);
            cell.setCellValue(icterus.getPatientAge());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(5);
            cell.setCellValue(icterus.getPatientAddress());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(6);
            cell.setCellValue(icterus.getPatientMobile());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(7);
            cell.setCellValue(icterus.isHighBloodPressure() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(8);
            cell.setCellValue(icterus.isGlycuresis() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(9);
            cell.setCellValue(icterus.isBloodFat() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(10);
            cell.setCellValue(icterus.isHeartDisease() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(11);
            cell.setCellValue(icterus.isSmoking() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(12);
            cell.setCellValue(icterus.isDrink() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(13);
            cell.setCellValue(icterus.isFamilyHistory() == true ? "Y" : "N");
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(14);
            cell.setCellValue(icterus.getzCode());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(15);
            cell.setCellValue(icterus.getCheckInTime());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(16);
            cell.setCellValue(icterus.getWeight());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(17);
            cell.setCellValue(icterus.getHeight());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(18);
            cell.setCellValue(icterus.getOperateInfo());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(19);
            cell.setCellValue(icterus.getOtherOperateInfo());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(20);
            cell.setCellValue(icterus.getEcog());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(21);
            cell.setCellValue(icterus.getPainScore());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(22);
            cell.setCellValue(icterus.getOperateCheck());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(23);
            cell.setCellValue(icterus.getOperateAvidence());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(24);
            cell.setCellValue(icterus.getcType());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(25);
            cell.setCellValue(icterus.getTreatGroup());
            cell.setCellStyle(normCellStyle);
            cell = normRow.createCell(26);
            cell.setCellValue(icterus.getSearchDept());
            cell.setCellStyle(normCellStyle);

            i ++;

        }

        for (int j = 0; j <= 26; j++) {
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
            model.addAttribute("icterus", icterusService.getIcterus(id));
        }
    }


    public IcterusService getIcterusService() {
        return icterusService;
    }

    @Autowired
    public void setIcterusService(IcterusService icterusService) {
        this.icterusService = icterusService;
    }

    public IcterusOperateService getIcterusOperateService() {
        return icterusOperateService;
    }

    @Autowired
    public void setIcterusOperateService(IcterusOperateService icterusOperateService) {
        this.icterusOperateService = icterusOperateService;
    }

    public IcterusVisitService getIcterusVisitService() {
        return icterusVisitService;
    }

    @Autowired
    public void setIcterusVisitService(IcterusVisitService icterusVisitService) {
        this.icterusVisitService = icterusVisitService;
    }

    public IcterusBloodService getIcterusBloodService() {
        return icterusBloodService;
    }

    @Autowired
    public void setIcterusBloodService(IcterusBloodService icterusBloodService) {
        this.icterusBloodService = icterusBloodService;
    }

    public IcterusImmuneService getIcterusImmuneService() {
        return icterusImmuneService;
    }

    @Autowired
    public void setIcterusImmuneService(IcterusImmuneService icterusImmuneService) {
        this.icterusImmuneService = icterusImmuneService;
    }

    public IcterusTumorService getIcterusTumorService() {
        return icterusTumorService;
    }

    @Autowired
    public void setIcterusTumorService(IcterusTumorService icterusTumorService) {
        this.icterusTumorService = icterusTumorService;
    }

    public IcterusBiologicalService getIcterusBiologicalService() {
        return icterusBiologicalService;
    }

    @Autowired
    public void setIcterusBiologicalService(IcterusBiologicalService icterusBiologicalService) {
        this.icterusBiologicalService = icterusBiologicalService;
    }

    public IcterusPicService getIcterusPicService() {
        return icterusPicService;
    }

    @Autowired
    public void setIcterusPicService(IcterusPicService icterusPicService) {
        this.icterusPicService = icterusPicService;
    }
}
