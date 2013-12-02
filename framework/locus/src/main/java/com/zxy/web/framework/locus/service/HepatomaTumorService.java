package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.HepatomaTumor;
import com.zxy.web.framework.locus.repository.jpa.HepatomaTumorDao;
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
public class HepatomaTumorService {

    private HepatomaTumorDao hepatomaTumorDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(HepatomaTumor hepatomaTumor) {
        hepatomaTumorDao.save(hepatomaTumor);
    }

    public List<HepatomaTumor> findAllByParentId(String parentId) {
        return hepatomaTumorDao.findAllByParentId(parentId);
    }

    public HepatomaTumorDao getHepatomaTumorDao() {
        return hepatomaTumorDao;
    }

    @Autowired
    public void setHepatomaTumorDao(HepatomaTumorDao hepatomaTumorDao) {
        this.hepatomaTumorDao = hepatomaTumorDao;
    }
}
