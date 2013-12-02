package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.IcterusTumor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author James
 */
public interface IcterusTumorDao extends PagingAndSortingRepository<IcterusTumor, String>, JpaSpecificationExecutor<IcterusTumor> {

    @Query("select icterusTumor from IcterusTumor icterusTumor where icterusTumor.parent.id=?1")
    List<IcterusTumor> findAllByParentId(String parentId);
}
