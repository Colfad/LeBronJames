package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.ArteryClinic;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArteryClinicDao extends PagingAndSortingRepository<ArteryClinic, String>, JpaSpecificationExecutor<ArteryClinic> {

    @Query("select arteryClinic from ArteryClinic arteryClinic where arteryClinic.parent.id=?1")
    public ArteryClinic findByParentId(String parentId);
}
