package com.zxy.web.framework.locus.repository.mybatis;

import com.zxy.web.framework.locus.model.Column;
import com.zxy.web.framework.locus.model.TableEntity;
import com.zxy.web.module.core.annotation.MyBatisDaoAnnotation;

import java.util.List;
import java.util.Map;

/**
 * Table表的操作
 *
 * @author James
 */
@MyBatisDaoAnnotation
public interface TableEntityMyBatisDao {

    // create table xxx
    public List<TableEntity> findByPage(Map<String, String> map);

    public List<Column> findTableColumns(String tableId);

    public void createTable(Map<String, String> map);

    public void renameTable(Map<String, String> map);

    void deleteTable(Map<String, String> map);
}
