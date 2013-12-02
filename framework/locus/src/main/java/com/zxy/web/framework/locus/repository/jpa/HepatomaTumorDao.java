package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.HepatomaTumor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author James
 */
public interface HepatomaTumorDao extends PagingAndSortingRepository<HepatomaTumor, String>, JpaSpecificationExecutor<HepatomaTumor> {

    @Query("select hepatomaTumor from HepatomaTumor hepatomaTumor where hepatomaTumor.parent.id=?1")
    List<HepatomaTumor> findAllByParentId(String parentId);
}
