package com.zxy.web.framework.locus.web;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;
import com.google.common.collect.Maps;
import com.zxy.web.module.core.info.OperateInfo;
import com.zxy.web.module.core.orm.FixEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.Map;

/**
 * 获得图片的url
 *
 * @author James
 */
@Controller
@RequestMapping("/image/file/")
public class ImageController {

    private OSSClient ossClient;

    private static Map<String, MediaType> map = Maps.newLinkedHashMap();

    static {
        map.put("image/x-png", MediaType.IMAGE_PNG);
        map.put("image/jpg", MediaType.IMAGE_JPEG);
    }

    @RequestMapping("key/{key}")
    @ResponseBody
    public ResponseEntity<String> getImage(@PathVariable("key") String key) throws URISyntaxException {
        String accessKeyId = "jo8nPbtig5N4UcNH";
        String accessKeyKeySecret = "MdwZXJ6MZg9cQ85iAwm1DLfEy9IRZ2";

        OSSClient client = new OSSClient(accessKeyId, accessKeyKeySecret);

        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        URL url = client.generatePresignedUrl("jamestestbucket", key, expiration);
/*        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);*/

//        OSSObject object = client.getObject("jamestestbucket", key);

        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(url.toURI());
//        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(headers, HttpStatus.OK);
//        headers.setContentType(MediaType.IMAGE_PNG);
//        ResponseEntity<URI> entity = new ResponseEntity<URI>(url.toURI(), headers, HttpStatus.OK);
//        headers.setContentType(map.get(object.getObjectMetadata().getContentType()));
        headers.setContentType(MediaType.TEXT_PLAIN);
        ResponseEntity<String> entity = new ResponseEntity<String>(url.toURI().toString(), headers, HttpStatus.OK);

        return entity;

    }



/*    @RequestMapping("upload")
    public String uploadImage(HttpServletRequest request, @RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
        } else {
            InputStream inputStream = multipartFile.getInputStream();
            Image image = new Image();
            image.setContentType(multipartFile.getContentType());
            FixEntityUtil.fixEntity(image);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(multipartFile.getContentType());
            metadata.setContentLength(multipartFile.getSize());
            PutObjectResult result = ossClient.putObject("jamesimagebucket", image.getId(), inputStream, metadata);
            image.seteTag(result.getETag());

            // 设定的失效时间为一年的时间，第一周的晚上会进行一次统一的更新操作
            Date expiration = new Date(new Date().getTime() + 3600 * 24 * 365);
            URL url = ossClient.generatePresignedUrl("jamesimagebucket", image.getId(), expiration);
            image.setUrl(url.toString());
            imageService.save(image);
        }

        return "index";
    }

    public OSSClient getOssClient() {
        return ossClient;
    }

    @Autowired
    public void setOssClient(OSSClient ossClient) {
        this.ossClient = ossClient;
    }

    public ImageService getImageService() {
        return imageService;
    }

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    private ImageService imageService;*/


}
