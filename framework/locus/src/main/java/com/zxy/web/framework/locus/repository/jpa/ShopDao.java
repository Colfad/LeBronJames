package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.Shop;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * 店铺的DAO层封装
 *
 * @author James
 */
public interface ShopDao extends PagingAndSortingRepository<Shop, String>, JpaSpecificationExecutor<Shop> {
}
