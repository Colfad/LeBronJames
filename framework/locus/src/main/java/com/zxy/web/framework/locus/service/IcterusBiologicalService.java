package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.IcterusBiological;
import com.zxy.web.framework.locus.repository.jpa.IcterusBiologicalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class IcterusBiologicalService {

    private IcterusBiologicalDao icterusBiologicalDao;


    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(IcterusBiological icterusBiological) {
        icterusBiologicalDao.save(icterusBiological);
    }

    public List<IcterusBiological> findAllByParentId(String parentId) {
        return icterusBiologicalDao.findAllByParentId(parentId);
    }

    public IcterusBiological getIcterusBiological(String id) {
        return icterusBiologicalDao.findOne(id);
    }

    public List<IcterusBiological> findAll() {
        return (List<IcterusBiological>) icterusBiologicalDao.findAll();
    }

    public IcterusBiologicalDao getIcterusBiologicalDao() {
        return icterusBiologicalDao;
    }

    @Autowired
    public void setIcterusBiologicalDao(IcterusBiologicalDao icterusBiologicalDao) {
        this.icterusBiologicalDao = icterusBiologicalDao;
    }
}
