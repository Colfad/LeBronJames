package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.IcterusBiological;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author James
 */
public interface IcterusBiologicalDao extends PagingAndSortingRepository<IcterusBiological, String>, JpaSpecificationExecutor<IcterusBiological> {

    @Query("select icterusBiological from IcterusBiological icterusBiological where icterusBiological.parent.id=?1")
    public List<IcterusBiological> findAllByParentId(String parentId);


}
