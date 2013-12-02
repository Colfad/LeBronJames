package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.Icterus;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author James
 */
public interface IcterusDao extends PagingAndSortingRepository<Icterus, String>, JpaSpecificationExecutor<Icterus> {
}
