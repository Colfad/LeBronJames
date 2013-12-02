package com.zxy.web.framework.locus.web;

import com.zxy.web.framework.locus.service.FileRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileRepository Controller类
 *
 * @author James
 */
@Controller
@RequestMapping("/file")
public class FileRepositoryController {
    private FileRepositoryService fileRepositoryService;

    @RequestMapping("")
    public String toFileList() {
        return "file/uploadFileList";
    }

    public FileRepositoryService getFileRepositoryService() {
        return fileRepositoryService;
    }

    @Autowired
    public void setFileRepositoryService(FileRepositoryService fileRepositoryService) {
        this.fileRepositoryService = fileRepositoryService;
    }
}
