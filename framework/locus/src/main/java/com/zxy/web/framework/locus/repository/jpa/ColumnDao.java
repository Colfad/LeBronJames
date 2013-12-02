package com.zxy.web.framework.locus.repository.jpa;


import com.zxy.web.framework.locus.model.Column;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ColumnDao extends PagingAndSortingRepository<Column, String>, JpaSpecificationExecutor<Column> {

    @Query("select col from Column col where col.table.id=?1")
    List<Column> findAllColumnByTable(String tableId);
}
