package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.Icterus;
import com.zxy.web.framework.locus.repository.jpa.IcterusDao;
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

import java.util.List;
import java.util.Map;

/**
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class IcterusService {

    private IcterusDao icterusDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Icterus icterus) {
        icterusDao.save(icterus);
    }

    public Page<Icterus> getIcterusByPage(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                          String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Icterus> spec = buildSpecification(searchParams);
        return icterusDao.findAll(spec, pageRequest);
    }

    private Specification<Icterus> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<Icterus> spec = DynamicSpecifications.bySearchFilter(filters.values(), Icterus.class);
        return spec;
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auot".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "createDate");
        } else if ("patientName".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "patientName");
        }

        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    public Icterus getIcterus(String id) {
        return icterusDao.findOne(id);
    }

    public List<Icterus> findAll() {
        return (List<Icterus>) icterusDao.findAll();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(String id) {
        icterusDao.delete(id);
    }

    public IcterusDao getIcterusDao() {
        return icterusDao;
    }

    @Autowired
    public void setIcterusDao(IcterusDao icterusDao) {
        this.icterusDao = icterusDao;
    }
}
