package com.zxy.web.framework.locus.web;

import com.google.common.collect.Maps;
import com.zxy.web.framework.locus.model.FileRepository;
import com.zxy.web.framework.locus.service.FileRepositoryService;
import com.zxy.web.module.core.web.Servlets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.Map;

/**
 * FileRepository Controller类
 *
 * @author James
 */
@Controller
@RequestMapping("/file")
public class FileRepositoryController {
    private static final String PAGE_SIZE = "5";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

    private FileRepositoryService fileRepositoryService;

    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("mimeTypeExtensionName", "文件后缀名");
    }

    @RequestMapping("")
    public String toFileList(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                             @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                             @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                             Model model, ServletRequest request) {

        Map<String, Object> searchParam = Servlets.getParametersStartingWith(request, "search_");
        Page<FileRepository> fileRepositories = fileRepositoryService.getFileRepositoryByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("fileRepositories", fileRepositories);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        model.addAttribute("fileActive", "active");

        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "file/uploadFileList";
    }

    @RequestMapping("delete/{id}")
    public String deleteFile(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        fileRepositoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Great ... 删除文件成功!!!");
        return "redirect:/file";
    }


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("action", "create");
        model.addAttribute("fileActive", "active");

        return "file/uploadFileForm";
    }

    /**
     *
     * 文件提交的Action，文件会以Ajax的方式去上传过来。
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> create(HttpServletRequest request,
                         HttpServletResponse response) {

//        redirectAttributes.addFlashAttribute("message", "Great ... 上伟文件成功!!!");
//        return "redirect:/file";

        String uploadResult = null;
        ResponseEntity<String> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        try {
            // 上传文件
            fileRepositoryService.save(request);
            uploadResult = "上传成功";
            entity = new ResponseEntity<String>(uploadResult, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            uploadResult = "系统发生错误，上传失败";
            entity = new ResponseEntity<String>(uploadResult, headers, HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    /**
     * 文件下载
     *
     * @param yyyy
     * @param mm
     * @param dd
     * @param id
     */
    @RequestMapping(value = "download/{yyyy}/{mm}/{dd}/{id}")
    public void downloadFile(@PathVariable("yyyy") String yyyy, @PathVariable("mm") String mm,
                             @PathVariable("dd") String dd, @PathVariable("id") String id, HttpServletResponse response) throws UnsupportedEncodingException {
        FileRepository fileRepository = fileRepositoryService.getFileRepository(id);
        response.setCharacterEncoding("utf-8");
        if (fileRepository.getMimeTypeName() == null || fileRepository.getMimeTypeName().equals("")) {
            response.setContentType("multipart/form-data");
        } else {
            response.setContentType(fileRepository.getMimeTypeName());
        }

        response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileRepository.getFileName().getBytes(), "iso8859-1"));

        String filePath = yyyy + "/" + mm + "/" + dd;
        byte[] content = fileRepositoryService.getFileContent(filePath, fileRepository);
        InputStream inputStream = new ByteArrayInputStream(content);
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            byte[] byteContent = new byte[1024];
            int length;
            while ((length = inputStream.read(byteContent)) > 0) {
                outputStream.write(byteContent, 0, length);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "download/{yyyy}/{mm}/{dd}/{id}/image")
    @ResponseBody
    public ResponseEntity<String> downloadFile(@PathVariable("yyyy") String yyyy, @PathVariable("mm") String mm,
                             @PathVariable("dd") String dd, @PathVariable("id") String id) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("");
        sb.append("<div><image id=\"loadImage\" src=\"/file/download")
                .append("/").append(yyyy).append("/").append(mm).append("/").append(dd).append("/").append(id).append("\" /></div>");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_HTML);
        ResponseEntity<String> entity = new ResponseEntity<String>(sb.toString(), httpHeaders, HttpStatus.OK);
        return entity;

        /*FileRepository fileRepository = fileRepositoryService.getFileRepository(id);
        String filePath = yyyy + "/" + mm + "/" + dd;
        byte[] content = fileRepositoryService.getFileContent(filePath, fileRepository);
        HttpHeaders headers = new HttpHeaders();
        if (fileRepository.getMimeTypeName() == null || fileRepository.getMimeTypeName().equals("")) {
            headers.set("Content-Type", "multipart/form-data");
        } else {
            headers.set("Content-Type", fileRepository.getMimeTypeName());
        }

        headers.setContentDispositionFormData("attachment", new String(fileRepository.getFileName().getBytes(), "iso8859-1"));
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);

        return entity;*/
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("fileRepository", fileRepositoryService.getFileRepository(id));
        model.addAttribute("action", "update");
        model.addAttribute("fileActive", "active");
        return "file/uploadFileForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("fileRepository") FileRepository fileRepository, RedirectAttributes redirectAttributes) {
        fileRepositoryService.save(fileRepository);
        redirectAttributes.addFlashAttribute("message", "Great ... 更新文件成功");
        return "redirect:/file";
    }

    @ModelAttribute
    public void getFileRepository(@RequestParam(value = "id", required = false) String id,
                                  Model model) {
        if (id != null && !id.trim().equals("")) {
            model.addAttribute("fileRepository", fileRepositoryService.getFileRepository(id));
        }
    }

    public FileRepositoryService getFileRepositoryService() {
        return fileRepositoryService;
    }

    @Autowired
    public void setFileRepositoryService(FileRepositoryService fileRepositoryService) {
        this.fileRepositoryService = fileRepositoryService;
    }
}
