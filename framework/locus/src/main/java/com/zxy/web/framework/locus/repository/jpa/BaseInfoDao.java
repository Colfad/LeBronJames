package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.BaseInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BaseInfoDao extends PagingAndSortingRepository<BaseInfo, String>, JpaSpecificationExecutor<BaseInfo> {
}