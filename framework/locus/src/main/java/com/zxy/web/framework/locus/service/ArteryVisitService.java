package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.ArteryVisit;
import com.zxy.web.framework.locus.repository.jpa.ArteryVisitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class ArteryVisitService {

    private ArteryVisitDao arteryVisitDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(ArteryVisit arteryVisit) {
        arteryVisitDao.save(arteryVisit);
    }

    public ArteryVisit getArteryVisit(String id) {
        return arteryVisitDao.findOne(id);
    }

    public ArteryVisit getByParentId(String parentId) {
        return arteryVisitDao.findByParentId(parentId);
    }

    public ArteryVisitDao getArteryVisitDao() {
        return arteryVisitDao;
    }

    @Autowired
    public void setArteryVisitDao(ArteryVisitDao arteryVisitDao) {
        this.arteryVisitDao = arteryVisitDao;
    }
}
