package com.zxy.web.module.core.service;


import com.zxy.web.module.core.model.Role;
import com.zxy.web.module.core.orm.util.DynamicSpecifications;
import com.zxy.web.module.core.orm.util.SearchFilter;
import com.zxy.web.module.core.repository.jpa.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 角色的Service类
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class RoleService {

    private RoleDao roleDao;

    public Role getRole(String id) {
        return roleDao.findOne(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveRole(Role role) {
        roleDao.save(role);
    }

    public List<Role> getAllRole() {
        return (List<Role>) roleDao.findAll();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteRole(String id) {
        roleDao.delete(id);
    }

    public Page<Role> getRoleByPage(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                    String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Role> spec = buildSpecification(searchParams);
        return roleDao.findAll(spec, pageRequest);

    }

    private Specification<Role> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<Role> spec = DynamicSpecifications.bySearchFilter(filters.values(), Role.class);
        return spec;
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "id");
        } else if ("roleName".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "roleName");
        }

        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
