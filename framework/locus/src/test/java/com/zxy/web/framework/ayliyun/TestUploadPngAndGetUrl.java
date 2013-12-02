package com.zxy.web.framework.ayliyun;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 阿里云的上传服务
 *
 * @author James
 */
public class TestUploadPngAndGetUrl {

//    @Test
    public void testUploadImage() {
        String accessKeyId = "jo8nPbtig5N4UcNH";
        String accessKeyKeySecret = "MdwZXJ6MZg9cQ85iAwm1DLfEy9IRZ2";

        OSSClient client = new OSSClient(accessKeyId, accessKeyKeySecret);


        File file = new File("F:\\testPng.png");
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
        }

        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(file.length());
        meta.setContentType("image/x-png");
        PutObjectResult result = client.putObject("jamestestbucket", "testPng", stream, meta);
        System.out.println(result.getETag());



    }
}
