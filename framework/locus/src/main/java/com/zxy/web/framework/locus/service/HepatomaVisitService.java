package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.HepatomaVisit;
import com.zxy.web.framework.locus.repository.jpa.HepatomaVisitDao;
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
public class HepatomaVisitService {

    private HepatomaVisitDao hepatomaVisitDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(HepatomaVisit hepatomaVisit) {
        hepatomaVisitDao.save(hepatomaVisit);
    }

    public List<HepatomaVisit> findAllByParentId(String parentId) {
        return hepatomaVisitDao.findAllByParentId(parentId);
    }

    public HepatomaVisitDao getHepatomaVisitDao() {
        return hepatomaVisitDao;
    }

    @Autowired
    public void setHepatomaVisitDao(HepatomaVisitDao hepatomaVisitDao) {
        this.hepatomaVisitDao = hepatomaVisitDao;
    }
}
