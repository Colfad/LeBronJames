package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.HepatomaBiological;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HepatomaBiologicalDao extends PagingAndSortingRepository<HepatomaBiological, String>, JpaSpecificationExecutor<HepatomaBiological> {

    @Query("select hepatomaBiological from HepatomaBiological hepatomaBiological where hepatomaBiological.parent.id=?1")
    List<HepatomaBiological> findAllByParentId(String parentId);
}
