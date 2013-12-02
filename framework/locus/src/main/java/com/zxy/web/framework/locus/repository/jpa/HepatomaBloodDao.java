package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.HepatomaBlood;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HepatomaBloodDao extends PagingAndSortingRepository<HepatomaBlood, String>, JpaSpecificationExecutor<HepatomaBlood> {

    @Query("select hepatomaBlood from HepatomaBlood hepatomaBlood where hepatomaBlood.parent.id=?1")
    List<HepatomaBlood> findAllByParentId(String parentId);
}
