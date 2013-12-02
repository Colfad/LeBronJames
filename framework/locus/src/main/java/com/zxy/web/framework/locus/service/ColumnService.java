package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.Column;
import com.zxy.web.framework.locus.repository.jpa.ColumnDao;
import com.zxy.web.framework.locus.repository.mybatis.ColumnMyBatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ColumnService服务
 *
 * @author James
 */
@Transactional(readOnly = true)
@Component
public class ColumnService {

    private ColumnDao columnDao;
    private ColumnMyBatisDao columnMyBatisDao;

    public ColumnDao getColumnDao() {
        return columnDao;
    }

    @Autowired
    public void setColumnDao(ColumnDao columnDao) {
        this.columnDao = columnDao;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Column column) {

        columnDao.save(column);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Column column, String tableName) {
        columnDao.save(column);
        Map<String, String> map = new HashMap<String, String>();
        map.put("tableName", tableName);
        map.put("columnName", column.getColumnName());
        String columnType = column.getColumnType();
        if (columnType.equals("pic")) {
            columnType = "varchar(255)";
        } else if (columnType.equals("varchar")) {
            columnType = "varchar(" + column.getColumnLength() + ")";
        }
        map.put("columnType", columnType);
        columnMyBatisDao.alterTable(map);

    }

    @Transactional(readOnly = true)
    public List<Column> findAllColumnByTable(String tableId) {
        return columnDao.findAllColumnByTable(tableId);

    }

    public ColumnMyBatisDao getColumnMyBatisDao() {
        return columnMyBatisDao;
    }

    @Autowired
    public void setColumnMyBatisDao(ColumnMyBatisDao columnMyBatisDao) {
        this.columnMyBatisDao = columnMyBatisDao;
    }
}
