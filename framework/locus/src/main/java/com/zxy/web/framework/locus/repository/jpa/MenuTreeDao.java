package com.zxy.web.framework.locus.repository.jpa;

import com.zxy.web.framework.locus.model.MenuTree;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * MenuTree dao 接口
 *
 * @author James
 */
public interface MenuTreeDao extends PagingAndSortingRepository<MenuTree, String>, JpaSpecificationExecutor<MenuTree> {
}
