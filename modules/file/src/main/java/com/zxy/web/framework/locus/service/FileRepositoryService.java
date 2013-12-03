package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.file.core.Config;
import com.zxy.web.framework.locus.file.core.UploadFileUtil;
import com.zxy.web.framework.locus.model.FileRepository;
import com.zxy.web.framework.locus.model.dto.FileRepositoryDTO;
import com.zxy.web.framework.locus.repository.jpa.FileRepositoryDao;
import com.zxy.web.module.core.orm.util.DynamicSpecifications;
import com.zxy.web.module.core.orm.util.SearchFilter;
import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

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
    private UploadFileUtil uploadFileUtil;

    private static final Logger logger = LoggerFactory.getLogger(FileRepositoryService.class);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(FileRepository fileRepository) {
        fileRepositoryDao.save(fileRepository);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(HttpServletRequest request) {
        try {
            // 上传文件的时候会自动生成一个FileRepository对象的，然后再返回给我们
            FileRepository fileRepository = uploadFileUtil.uploadFile(request);
            fileRepositoryDao.save(fileRepository);
        } catch (FileUploadException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(String id) {
        // 只是从数据库中删除数据
        fileRepositoryDao.delete(id);

        // 将实体文件删除掉
    }

    public byte[] getFileContent(String path, FileRepository fileRepository) {
        FileRepositoryDTO dto = null;
        try {
            dto = uploadFileUtil.getFileContentWithFileRepository(path, fileRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dto.getContent();

    }

    public Page<FileRepository> getFileRepositoryByPage(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                                        String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<FileRepository> spec = buildSpecification(searchParams);
        return fileRepositoryDao.findAll(spec, pageRequest);
    }

    private Specification<FileRepository> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<FileRepository> spec = DynamicSpecifications.bySearchFilter(filters.values(), FileRepository.class);
        return spec;
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "createDate");
        } else if ("mimeTypeExtensionName".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "mimeTypeExtensionName");
        }

        return new PageRequest(pageNumber - 1, pageSize, sort);
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

    public UploadFileUtil getUploadFileUtil() {
        return uploadFileUtil;
    }

    @Autowired
    public void setUploadFileUtil(UploadFileUtil uploadFileUtil) {
        this.uploadFileUtil = uploadFileUtil;
    }
}
