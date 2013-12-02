package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.HepatomaBlood;
import com.zxy.web.framework.locus.repository.jpa.HepatomaBloodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class HepatomaBloodService {
    private HepatomaBloodDao hepatomaBloodDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(HepatomaBlood hepatomaBlood) {
        hepatomaBloodDao.save(hepatomaBlood);
    }

    public List<HepatomaBlood> findAllByParentId(String parentId) {
        return hepatomaBloodDao.findAllByParentId(parentId);
    }

    public HepatomaBloodDao getHepatomaBloodDao() {
        return hepatomaBloodDao;
    }

    @Autowired
    public void setHepatomaBloodDao(HepatomaBloodDao hepatomaBloodDao) {
        this.hepatomaBloodDao = hepatomaBloodDao;
    }
}
