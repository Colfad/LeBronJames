package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.HepatomaPic;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HepatomaPicDao extends PagingAndSortingRepository<HepatomaPic, String>, JpaSpecificationExecutor<HepatomaPic> {
}
