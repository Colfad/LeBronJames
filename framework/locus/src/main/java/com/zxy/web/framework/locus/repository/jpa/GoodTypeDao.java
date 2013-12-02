package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.GoodType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 商品类型的DAO
 *
 * @author James
 */
public interface GoodTypeDao extends PagingAndSortingRepository<GoodType, String>, JpaSpecificationExecutor<GoodType> {
}
