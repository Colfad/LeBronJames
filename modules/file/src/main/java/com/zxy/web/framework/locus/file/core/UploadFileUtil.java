package com.zxy.web.framework.locus.file.core;

import com.zxy.web.framework.locus.exception.NotMultipartRequestException;
import com.zxy.web.framework.locus.model.FileRepository;
import com.zxy.web.framework.locus.model.MimeTypeExtension;
import com.zxy.web.framework.locus.model.dto.FileRepositoryDTO;
import com.zxy.web.framework.locus.service.FileRepositoryService;
import com.zxy.web.framework.locus.service.MimeTypeExtensionService;
import com.zxy.web.framework.locus.service.MimeTypeService;
import com.zxy.web.module.core.mapper.BeanMapper;
import com.zxy.web.module.core.orm.FixEntityUtil;
import com.zxy.web.module.core.utils.Base64;
import com.zxy.web.module.core.utils.FileUtil;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 文件上传的UTIL
 *
 * 这里虽然是尽量拨离出来，但是还是跟主项目中具有一定的耦合性
 * 如果脱离了spring，并且扫描的路径不同的话，那么这里的service
 * 是无法注入到类里面的，那么整个类也就没有办法用
 * 与DB之后的通信，交互也不是的JDBC而是JPA+SPRINGDATA
 * 所以也存在问题，这是以后需要进行修改的地方，第一版就这样吧
 *
 * 这里要注意一个地方，这里用到了FileRepositoryService
 * 而FileRespositoryService这个类里面还用到了UploadFileUtil这个类
 * 那么Spring在注入Bean的时候就会造成循环的情况。
 * 所以这里要使用@Lazy这个标签来进行注解，让其懒加载，以便能在后面注入
 * 实体类@Lazy这个Annotation相当于
 * <bean id="uploadFileUtil" class="com.zxy.web.framework.locus.file.core.UploadFileUtil" lazy-init="true" />
 * 上面的写法跟这里的方式其实就是一个意思
 *
 * @author James
 */
@Component
public class UploadFileUtil {

    private static final Logger logger = LoggerFactory.getLogger(UploadFileUtil.class);
    private MimeTypeService mimeTypeService;
    private MimeTypeExtensionService mimeTypeExtensionService;

    public MimeTypeService getMimeTypeService() {
        return mimeTypeService;
    }

    @Autowired
    public void setMimeTypeService(MimeTypeService mimeTypeService) {
        this.mimeTypeService = mimeTypeService;
    }

    public MimeTypeExtensionService getMimeTypeExtensionService() {
        return mimeTypeExtensionService;
    }

    @Autowired
    public void setMimeTypeExtensionService(MimeTypeExtensionService mimeTypeExtensionService) {
        this.mimeTypeExtensionService = mimeTypeExtensionService;
    }

    /**
     * 文件的上传服务
     *
     * @param request
     * @return
     * @throws FileUploadException
     * @throws IOException
     */
    public FileRepository uploadFile(HttpServletRequest request) throws FileUploadException, IOException {

        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        FileRepository fileRepository = null;
        if (isMultipartContent) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            for (Iterator<FileItem> iterator=items.iterator(); iterator.hasNext();) {
                FileItem item = iterator.next();
                InputStream inputStream = item.getInputStream();
                // 获得文件名
                String fileName = item.getName();
                String fileExtension = FileUtil.getFileExtension(fileName);
                // 获得文件的Extension类型
                MimeTypeExtension mimeTypeExtension = mimeTypeExtensionService.findByMimeTypeExtensionName(fileExtension);
                fileRepository = new FileRepository();
                FixEntityUtil.fixEntity(fileRepository);
                String fileRepoId = fileRepository.getId();
                fileRepository.setMimeTypeExtensionName(fileExtension);
                if (mimeTypeExtension.getMimeType() != null) {
                    fileRepository.setMimeTypeName(mimeTypeExtension.getMimeType().getMimeTypeName());
                }
                fileRepository.setFileName(fileName);
                String datePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
                String saveFilePath = Config.UPLOAD_FILE_PATH + "/" + datePath + "/";
                File file = new File(saveFilePath);
                if (!file.exists()) {
                    file.mkdirs();
                }

                file = new File(saveFilePath + fileRepoId + ".xzsoft");
                ByteArrayOutputStream out = new ByteArrayOutputStream();

                int byteRead = 0;
                byte[] buffer = new byte[8192];
                while ((byteRead = inputStream.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, byteRead);
                }

                inputStream.close();
                // 将上传的文件变Base64加密过的字符串
                String content = Base64.encode(out.toByteArray());
                out.close();

                // 将加密过后的数据存储到硬盘中
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write(content);
                bw.flush();
                fileWriter.flush();
                bw.close();
                fileWriter.close();
            }

        } else {
            throw new NotMultipartRequestException("上传的文件里面没有Multipart内容");
        }

        return fileRepository;
    }

    /**
     * 下载文件的时候会使用的方法，把硬盘里的数据读取出来，然后再解析成
     * byte[]数组，以便下面再往客户端去写数据
     *
     *
     * @return
     * @throws IOException
     */
    public byte[] getFileContent(String filePath) throws IOException {
        StringBuilder builder = new StringBuilder();
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String readLineStr = null;
        while ((readLineStr = br.readLine()) != null) {
            builder.append(readLineStr);
        }

        String fileContent = builder.toString();

        return Base64.decode(fileContent);

    }

    /**
     *
     * 返回FileRepositoryDTO类
     *
     * @return
     * @throws IOException
     * s
     * @see FileRepositoryDTO
     */
    public FileRepositoryDTO getFileContentWithFileRepository(String filePath, FileRepository fileRepository) throws IOException {

        StringBuilder builder = new StringBuilder();
        filePath = Config.UPLOAD_FILE_PATH + "/" + filePath + "/" + fileRepository.getId() + ".xzsoft";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String readLineStr = null;
        while ((readLineStr = br.readLine()) != null) {
            builder.append(readLineStr);
        }

        String fileContent = builder.toString();

        FileRepositoryDTO dto = new FileRepositoryDTO();
        BeanMapper.copy(fileRepository, dto);
        dto.setContent(Base64.decode(fileContent));

        return dto;

    }


}
