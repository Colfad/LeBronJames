package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.Artery;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 *
 * @author James
 */
public interface ArteryDao extends PagingAndSortingRepository<Artery, String>, JpaSpecificationExecutor<Artery> {
}
