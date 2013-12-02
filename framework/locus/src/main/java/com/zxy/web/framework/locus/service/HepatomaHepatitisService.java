package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.HepatomaHepatitis;
import com.zxy.web.framework.locus.repository.jpa.HepatomaHepatitisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class HepatomaHepatitisService {

    private HepatomaHepatitisDao hepatomaHepatitisDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(HepatomaHepatitis hepatomaHepatitis) {
        hepatomaHepatitisDao.save(hepatomaHepatitis);
    }

    public List<HepatomaHepatitis> findAllByParentId(String parentId) {
        return hepatomaHepatitisDao.findAllByParentId(parentId);
    }

    public HepatomaHepatitisDao getHepatomaHepatitisDao() {
        return hepatomaHepatitisDao;
    }

    @Autowired
    public void setHepatomaHepatitisDao(HepatomaHepatitisDao hepatomaHepatitisDao) {
        this.hepatomaHepatitisDao = hepatomaHepatitisDao;
    }
}
