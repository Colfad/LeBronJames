package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.IcterusOperate;
import com.zxy.web.framework.locus.repository.jpa.IcterusOperateDao;
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
public class IcterusOperateService {

    private IcterusOperateDao icterusOperateDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(IcterusOperate icterusOperate) {
        icterusOperateDao.save(icterusOperate);
    }

    public IcterusOperate getByParentId(String parentId) {
        return icterusOperateDao.getByParentId(parentId);
    }


    public IcterusOperateDao getIcterusOperateDao() {
        return icterusOperateDao;
    }

    @Autowired
    public void setIcterusOperateDao(IcterusOperateDao icterusOperateDao) {
        this.icterusOperateDao = icterusOperateDao;
    }
}
