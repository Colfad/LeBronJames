package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.Team;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * 用户组的Dao层代码
 *
 * @author James
 */
public interface TeamDao extends PagingAndSortingRepository<Team, String>, JpaSpecificationExecutor<Team> {
}
