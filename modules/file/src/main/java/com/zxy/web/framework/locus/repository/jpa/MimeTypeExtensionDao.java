package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.MimeTypeExtension;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MimeTypeExtensionDao extends PagingAndSortingRepository<MimeTypeExtension, Integer>, JpaSpecificationExecutor<MimeTypeExtension> {
    MimeTypeExtension findByMimeTypeExtensionName(String mimeTypeExtensionName);
}
