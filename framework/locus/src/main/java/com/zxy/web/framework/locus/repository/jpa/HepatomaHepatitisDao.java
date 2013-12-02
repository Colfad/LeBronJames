package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.HepatomaHepatitis;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author James
 */
public interface HepatomaHepatitisDao extends PagingAndSortingRepository<HepatomaHepatitis, String>, JpaSpecificationExecutor<HepatomaHepatitis> {

    @Query("select hepatomaHepatitis from HepatomaHepatitis hepatomaHepatitis where hepatomaHepatitis.parent.id=?1")
    List<HepatomaHepatitis> findAllByParentId(String parentId);
}
