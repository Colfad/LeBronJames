package com.zxy.web.module.core.orm;

import com.zxy.web.module.core.orm.model.BaseEntity;
import com.zxy.web.module.core.orm.util.UUIDGenerator;

import java.util.Date;

/**
 * 对Entity进行修复的操作
 *
 * @author James
 */
public class FixEntityUtil {
    /**
     * 是将Entity进行修复的操作
     *
     * @param t 待修复的Entity对象
     * @param <T> 继承自BaseEntity的泛型定义
     */
    public static <T extends BaseEntity> void fixEntity(T t) {
        if (null == t.getId() || "".equals(t.getId())) {
            t.setId(UUIDGenerator.getUUID());
        }
        if (null == t.getCreateDate()) {
            t.setCreateDate(new Date());
        }
    }
}
