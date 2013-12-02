package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.IcterusTumor;
import com.zxy.web.framework.locus.repository.jpa.IcterusTumorDao;
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
public class IcterusTumorService {

    private IcterusTumorDao icterusTumorDao;

    public IcterusTumorDao getIcterusTumorDao() {
        return icterusTumorDao;
    }

    @Autowired
    public void setIcterusTumorDao(IcterusTumorDao icterusTumorDao) {
        this.icterusTumorDao = icterusTumorDao;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(IcterusTumor icterusTumor) {
        icterusTumorDao.save(icterusTumor);
    }

    public List<IcterusTumor> findAllByParentId(String parentId) {
        return icterusTumorDao.findAllByParentId(parentId);
    }

}
