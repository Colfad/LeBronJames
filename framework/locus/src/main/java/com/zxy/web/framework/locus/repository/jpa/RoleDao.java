package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 权限DAO
 *
 * @author James
 */
public interface RoleDao extends PagingAndSortingRepository<Role, String>, JpaSpecificationExecutor<Role> {
}