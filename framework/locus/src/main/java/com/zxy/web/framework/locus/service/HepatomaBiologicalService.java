package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.HepatomaBiological;
import com.zxy.web.framework.locus.repository.jpa.HepatomaBiologicalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class HepatomaBiologicalService {

    private HepatomaBiologicalDao hepatomaBiologicalDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(HepatomaBiological hepatomaBiological) {
        hepatomaBiologicalDao.save(hepatomaBiological);
    }

    public List<HepatomaBiological> findAllByParentId(String parentId) {
        return hepatomaBiologicalDao.findAllByParentId(parentId);
    }

    public HepatomaBiologicalDao getHepatomaBiologicalDao() {
        return hepatomaBiologicalDao;
    }

    @Autowired
    public void setHepatomaBiologicalDao(HepatomaBiologicalDao hepatomaBiologicalDao) {
        this.hepatomaBiologicalDao = hepatomaBiologicalDao;
    }
}
