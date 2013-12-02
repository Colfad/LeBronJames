package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.ArteryDescrib;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author James
 */
public interface ArteryDescribDao extends PagingAndSortingRepository<ArteryDescrib, String>, JpaSpecificationExecutor<ArteryDescrib> {

    @Query("select arteryDescrib from ArteryDescrib arteryDescrib where arteryDescrib.parent.id=?1")
    public ArteryDescrib findByParentId(String parentId);
}
