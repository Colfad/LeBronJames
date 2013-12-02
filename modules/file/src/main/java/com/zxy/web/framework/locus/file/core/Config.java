package com.zxy.web.framework.locus.file.core;

import com.zxy.web.module.core.utils.FileInputStreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 定义系统中要用到的配置信息，以便有一个统一的地方进行相应的修改操作
 *
 * @author James
 */
public class Config {
    /** 最大的文件上传大小设置为2M */
    public static Long MAX_UPLOAD_FILE_SIZE;
    /** 允许上传的文件扩展类型 */
    public static String ALLOW_UPLOAD_FILE_LIST;
    /** 不允许上传的文件扩展类型 */
    public static String DENIED_UPLOAD_FILE_LIST;
    /** 文件的上传路径 */
    public static String UPLOAD_FILE_PATH;

    /**
     * 加载文件上传的时的配置文件信息
     */
    public static void loadProperties() {
        InputStream stream = FileInputStreamUtil.getFileInputStream(Config.class, "application-file-upload.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
            MAX_UPLOAD_FILE_SIZE = Long.valueOf(properties.getProperty("max.upload.file.size"));
            ALLOW_UPLOAD_FILE_LIST = properties.getProperty("allow.upload.file.list");
            DENIED_UPLOAD_FILE_LIST = properties.getProperty("denied.upload.file.list");
            UPLOAD_FILE_PATH = properties.getProperty("upload.file.path");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

