package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.ArteryVisit;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArteryVisitDao extends PagingAndSortingRepository<ArteryVisit, String>, JpaSpecificationExecutor<ArteryVisit> {
    @Query("select arteryVisit from ArteryVisit arteryVisit where arteryVisit.parent.id=?1")
    ArteryVisit findByParentId(String parentId);
}
