package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.IcterusVisit;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author James
 */
public interface IcterusVisitDao extends PagingAndSortingRepository<IcterusVisit, String>, JpaSpecificationExecutor<IcterusVisit> {

    @Query("select icterusVisit from IcterusVisit icterusVisit where icterusVisit.parent.id=?1")
    List<IcterusVisit> findAllByParentId(String parentId);
}
