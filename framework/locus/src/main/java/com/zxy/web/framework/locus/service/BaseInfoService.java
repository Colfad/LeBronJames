package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.BaseInfo;
import com.zxy.web.framework.locus.repository.jpa.BaseInfoDao;
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

@Component
@Transactional(readOnly = true)
public class BaseInfoService {

    private BaseInfoDao baseInfoDao;

    public BaseInfo getBaseInfo(String id) {
        return baseInfoDao.findOne(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveBaseInfo(BaseInfo baseInfo) {
        baseInfoDao.save(baseInfo);
    }

    public List<BaseInfo> getAllBaseInfo() {
        return (List<BaseInfo>) baseInfoDao.findAll();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteBaseInfo(String id) {
        baseInfoDao.delete(id);
    }

    public Page<BaseInfo> getBaseInfoByPage(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                            String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<BaseInfo> spec = buildSpecification(searchParams);
        return baseInfoDao.findAll(spec, pageRequest);

    }

    private Specification<BaseInfo> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<BaseInfo> spec = DynamicSpecifications.bySearchFilter(filters.values(), BaseInfo.class);
        return spec;
    }

    //这里需要自己去写相关的代码,根据什么来进行排序,这些都要进行简单的二次开发
    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "id");
        } 
        else if ("patientName".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "patientName");
        }

        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    public BaseInfoDao getBaseInfoDao() {
        return baseInfoDao;
    }

    @Autowired
    public void setBaseInfoDao(BaseInfoDao baseInfoDao) {
        this.baseInfoDao = baseInfoDao;
    }
}