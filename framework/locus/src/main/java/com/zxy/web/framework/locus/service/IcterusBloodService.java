package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.IcterusBlood;
import com.zxy.web.framework.locus.repository.jpa.IcterusBloodDao;
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
public class IcterusBloodService {
    private IcterusBloodDao icterusBloodDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(IcterusBlood icterusBlood) {
        icterusBloodDao.save(icterusBlood);
    }

    public IcterusBlood getIcterusBlodd(String id) {
        return icterusBloodDao.findOne(id);
    }

    public List<IcterusBlood> findAll() {
        return (List<IcterusBlood>) icterusBloodDao.findAll();
    }

    public List<IcterusBlood> findAllByParentId(String parentId) {
        return icterusBloodDao.findAllByParentId(parentId);
    }

    public IcterusBloodDao getIcterusBloodDao() {
        return icterusBloodDao;
    }

    @Autowired
    public void setIcterusBloodDao(IcterusBloodDao icterusBloodDao) {
        this.icterusBloodDao = icterusBloodDao;
    }
}
