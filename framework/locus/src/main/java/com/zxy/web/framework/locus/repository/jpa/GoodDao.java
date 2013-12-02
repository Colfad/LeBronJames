package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.Good;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 货物DAO
 *
 * @author James
 */
public interface GoodDao extends PagingAndSortingRepository<Good, String>, JpaSpecificationExecutor<Good> {
}
