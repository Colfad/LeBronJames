package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.IcterusVisit;
import com.zxy.web.framework.locus.repository.jpa.IcterusVisitDao;
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
public class IcterusVisitService {

    private IcterusVisitDao icterusVisitDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(IcterusVisit icterusVisit) {
        icterusVisitDao.save(icterusVisit);
    }

    public List<IcterusVisit> findAllByParentId(String parentId) {
        return icterusVisitDao.findAllByParentId(parentId);
    }

    public IcterusVisitDao getIcterusVisitDao() {
        return icterusVisitDao;
    }

    @Autowired
    public void setIcterusVisitDao(IcterusVisitDao icterusVisitDao) {
        this.icterusVisitDao = icterusVisitDao;
    }
}
