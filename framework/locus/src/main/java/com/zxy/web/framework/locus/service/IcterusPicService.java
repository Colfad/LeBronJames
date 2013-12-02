package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.IcterusPic;
import com.zxy.web.framework.locus.repository.jpa.IcterusPicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class IcterusPicService {

    private IcterusPicDao icterusPicDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(IcterusPic icterusPic) {
        icterusPicDao.save(icterusPic);
    }

    public IcterusPic getByParentId(String parentId) {
        return icterusPicDao.getByParentId(parentId);
    }

    public IcterusPic getIcterusPic(String id) {
        return icterusPicDao.findOne(id);
    }

    public IcterusPicDao getIcterusPicDao() {
        return icterusPicDao;
    }

    @Autowired
    public void setIcterusPicDao(IcterusPicDao icterusPicDao) {
        this.icterusPicDao = icterusPicDao;
    }
}
