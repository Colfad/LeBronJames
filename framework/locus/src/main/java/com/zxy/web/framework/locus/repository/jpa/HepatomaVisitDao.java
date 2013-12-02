package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.HepatomaVisit;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HepatomaVisitDao extends PagingAndSortingRepository<HepatomaVisit, String>, JpaSpecificationExecutor<HepatomaVisit> {

    @Query("select hepatomaVisit from HepatomaVisit hepatomaVisit where hepatomaVisit.parent.id=?1")
    List<HepatomaVisit> findAllByParentId(String parentId);
}
