package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.IcterusImmune;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author James
 */
public interface IcterusImmuneDao extends PagingAndSortingRepository<IcterusImmune, String>, JpaSpecificationExecutor<IcterusImmune> {

    @Query("select icterusImmune from IcterusImmune icterusImmune where icterusImmune.parent.id=?1")
    List<IcterusImmune> findAllByParentId(String parentId);
}
