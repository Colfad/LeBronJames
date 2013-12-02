package com.zxy.web.module.core.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.charset.Charset;

/**
 * 为了简化Spring开发时的一些问题
 *
 * @author James
 */
public class SpringMvcUtils {

    /**
     * 为了解决IE下面返回JSON数据的时候会出现下载的页面
     * IE无论是什么版本，当页面返回是JSON数据的时候都会出现问题
     *
     * @param t 要返回的对象
     * @param <T> 泛型定义
     * @return 要返回的ResponseEntity
     */
    public static <T> ResponseEntity<T> getTextPlainEntity(T t) {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("text", "plain", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
        ResponseEntity<T> entity = new ResponseEntity<T>(t, headers, HttpStatus.OK);
        return entity;
    }

    /**
     * 是为了封装Xml对象返回的时候进行的封装操作
     *
     * param t 要返回的对象
     * @param <T> 泛型定义
     * @return 要返回的ResponseEntity
     */
    public static <T> ResponseEntity<T> getXmlEntity(T t) {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("text", "xml", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
        ResponseEntity<T> entity = new ResponseEntity<T>(t, headers, HttpStatus.OK);
        return entity;
    }

    /**
     * 是为了封装HTML对象返回的时候进行的封装操作
     *
     * param t 要返回的对象
     * @param <T> 泛型定义
     * @return 要返回的ResponseEntity
     */
    public static <T> ResponseEntity<T> getHtmlEntity(T t) {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("text", "html", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
        ResponseEntity<T> entity = new ResponseEntity<T>(t, headers, HttpStatus.OK);
        return entity;
    }
}
