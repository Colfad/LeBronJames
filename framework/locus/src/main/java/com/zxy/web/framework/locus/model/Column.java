package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 存放表里面的列名信息
 *
 *
 * @author James
 */
@Entity
@Table(name = "xz_column")
public class Column extends BaseEntity {
    private String columnName;

    private String columnType;

    private String columnLength;

    private String showName;

    private Boolean gridShow;

    private TableEntity table;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Boolean getGridShow() {
        return gridShow;
    }

    public void setGridShow(Boolean gridShow) {
        this.gridShow = gridShow;
    }

    @ManyToOne
    @JoinColumn(name = "table_id")
    public TableEntity getTable() {
        return table;
    }

    public void setTable(TableEntity table) {
        this.table = table;
    }
}
