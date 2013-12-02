package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.IcterusBlood;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author James
 */
public interface IcterusBloodDao extends PagingAndSortingRepository<IcterusBlood, String>, JpaSpecificationExecutor<IcterusBlood> {
    @Query("select icterusBlood from IcterusBlood icterusBlood where icterusBlood.parent.id=?1")
    List<IcterusBlood> findAllByParentId(String parentId);
}
