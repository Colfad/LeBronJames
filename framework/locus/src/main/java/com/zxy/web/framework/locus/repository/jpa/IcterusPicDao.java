package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.IcterusPic;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author James
 */
public interface IcterusPicDao extends PagingAndSortingRepository<IcterusPic, String>, JpaSpecificationExecutor<IcterusPic> {

    @Query("select icterusPic from IcterusPic icterusPic where icterusPic.parent.id=?1")
    IcterusPic getByParentId(String parentId);
}
