package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.MimeType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MimeTypeDao extends PagingAndSortingRepository<MimeType, Integer>, JpaSpecificationExecutor<MimeType> {
}
