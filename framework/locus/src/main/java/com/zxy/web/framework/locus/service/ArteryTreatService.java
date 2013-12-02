package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.ArteryTreat;
import com.zxy.web.framework.locus.repository.jpa.ArteryTreatDao;
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
public class ArteryTreatService {
    private ArteryTreatDao arteryTreatDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(ArteryTreat arteryTreat) {
        arteryTreatDao.save(arteryTreat);
    }

    public ArteryTreat getArteryTreat(String id) {
        return arteryTreatDao.findOne(id);
    }

    public ArteryTreat getByParentId(String parentId) {
        return arteryTreatDao.findByParentId(parentId);
    }

    public ArteryTreatDao getArteryTreatDao() {
        return arteryTreatDao;
    }

    @Autowired
    public void setArteryTreatDao(ArteryTreatDao arteryTreatDao) {
        this.arteryTreatDao = arteryTreatDao;
    }
}
