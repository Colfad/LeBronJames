package com.zxy.web.module.core.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * MYBATIS DAO标识的Annotation
 * 
 * @author James
 *
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyBatisDaoAnnotation {
    String value() default "";
}
