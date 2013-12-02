package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.MenuTree;
import com.zxy.web.framework.locus.repository.jpa.MenuTreeDao;
import com.zxy.web.module.core.orm.util.DynamicSpecifications;
import com.zxy.web.module.core.orm.util.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Menu Tree 的Service 类
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class MenuTreeService {
    private MenuTreeDao menuTreeDao;

    public MenuTree getMenuTree(String id) {
        return menuTreeDao.findOne(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveMenuTree(MenuTree menuTree) {
        menuTreeDao.save(menuTree);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(String id) {
        menuTreeDao.delete(id);
    }

    private Specification<MenuTree> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<MenuTree> spec = DynamicSpecifications.bySearchFilter(filters.values(), MenuTree.class);
        return spec;
    }

    public Page<MenuTree> getMenuTreeByPage(Map<String, Object> searchParams, int pageNumber,
                                            int pageSize, String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<MenuTree> spec = buildSpecification(searchParams);
        return menuTreeDao.findAll(spec, pageRequest);
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "createDate");
        } else if ("menuName".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "menuName");
        }

        return new PageRequest(pageNumber - 1, pageSize, sort);
    }


    public MenuTreeDao getMenuTreeDao() {
        return menuTreeDao;
    }

    @Autowired
    public void setMenuTreeDao(MenuTreeDao menuTreeDao) {
        this.menuTreeDao = menuTreeDao;
    }
}
