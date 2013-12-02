package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.ArteryCoil;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArteryCoilDao extends PagingAndSortingRepository<ArteryCoil, String>, JpaSpecificationExecutor<ArteryCoil> {

    @Query("select arteryCoil from ArteryCoil arteryCoil where arteryCoil.parent.id=?1")
    public ArteryCoil findByParentId(String parentId);
}
