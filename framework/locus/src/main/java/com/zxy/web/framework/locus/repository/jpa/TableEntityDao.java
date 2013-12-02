package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.TableEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 *
 * @author James
 */
public interface TableEntityDao extends PagingAndSortingRepository<TableEntity, String>, JpaSpecificationExecutor<TableEntity> {

}
