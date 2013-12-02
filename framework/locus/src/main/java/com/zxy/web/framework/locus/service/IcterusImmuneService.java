package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.IcterusImmune;
import com.zxy.web.framework.locus.repository.jpa.IcterusImmuneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class IcterusImmuneService {

    private IcterusImmuneDao icterusImmuneDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(IcterusImmune icterusImmune) {
        icterusImmuneDao.save(icterusImmune);
    }

    public IcterusImmune getIcterusImmune(String id) {
        return icterusImmuneDao.findOne(id);
    }

    public List<IcterusImmune> findAll() {
        return (List<IcterusImmune>) icterusImmuneDao.findAll();
    }

    public List<IcterusImmune> findAllByParentId(String parentId) {
        return icterusImmuneDao.findAllByParentId(parentId);
    }

    public IcterusImmuneDao getIcterusImmuneDao() {
        return icterusImmuneDao;
    }

    @Autowired
    public void setIcterusImmuneDao(IcterusImmuneDao icterusImmuneDao) {
        this.icterusImmuneDao = icterusImmuneDao;
    }
}
