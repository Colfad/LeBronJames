package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.Hepatoma;
import com.zxy.web.framework.locus.repository.jpa.HepatomaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class HepatomaService {

    private HepatomaDao hepatomaDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Hepatoma hepatoma) {
        hepatomaDao.save(hepatoma);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(String id) {
        hepatomaDao.delete(id);
    }

    public HepatomaDao getHepatomaDao() {
        return hepatomaDao;
    }

    @Autowired
    public void setHepatomaDao(HepatomaDao hepatomaDao) {
        this.hepatomaDao = hepatomaDao;
    }
}
