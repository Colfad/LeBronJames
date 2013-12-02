package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.ArteryTreat;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author James
 */
public interface ArteryTreatDao extends PagingAndSortingRepository<ArteryTreat, String>, JpaSpecificationExecutor<ArteryTreat> {

    @Query("select arteryTreat from ArteryTreat arteryTreat where arteryTreat.parent.id=?1")
    public ArteryTreat findByParentId(String parentId);
}
