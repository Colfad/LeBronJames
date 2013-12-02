package com.zxy.web.framework.locus.repository.mybatis;

import com.zxy.web.module.core.annotation.MyBatisDaoAnnotation;

import java.util.Map;

/**
 *
 * @author James
 */
@MyBatisDaoAnnotation
public interface ColumnMyBatisDao {

    public void saveColumn(String alterSql);

    void alterTable(Map<String, String> map);

}
