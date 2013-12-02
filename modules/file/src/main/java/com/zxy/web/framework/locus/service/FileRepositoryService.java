package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.file.core.Config;
import com.zxy.web.framework.locus.model.FileRepository;
import com.zxy.web.framework.locus.repository.jpa.FileRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

/**
 *
 * FileRepository Service 类
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class FileRepositoryService {

    private FileRepositoryDao fileRepositoryDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(FileRepository fileRepository) {
        fileRepositoryDao.save(fileRepository);
    }

    public FileRepository getFileRepository(String id) {
        return fileRepositoryDao.findOne(id);
    }

    public FileRepositoryDao getFileRepositoryDao() {
        return fileRepositoryDao;
    }

    /**
     * 根据文件的ID来找到存储的文件路径，以便 FileUtil去读取DISK中的文件
     * 再返回给客户
     *
     * @param id
     * @return
     */
    public String getFilePathById(String id) {
        FileRepository fileRepository = fileRepositoryDao.findOne(id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String datePath = format.format(fileRepository.getCreateDate());
        String filePath = Config.UPLOAD_FILE_PATH + "/" + datePath + "/" + id + ".data";

        return filePath;
    }

    @Autowired
    public void setFileRepositoryDao(FileRepositoryDao fileRepositoryDao) {
        this.fileRepositoryDao = fileRepositoryDao;
    }
}
