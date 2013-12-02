package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.ArteryCoil;
import com.zxy.web.framework.locus.repository.jpa.ArteryCoilDao;
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
public class ArteryCoilService {

    private ArteryCoilDao arteryCoilDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(ArteryCoil arteryCoil) {
        arteryCoilDao.save(arteryCoil);
    }

    public ArteryCoil getArteryCoil(String id) {
        return arteryCoilDao.findOne(id);
    }

    public ArteryCoil findByParentId(String parentId) {
        return arteryCoilDao.findByParentId(parentId);
    }

    public ArteryCoilDao getArteryCoilDao() {
        return arteryCoilDao;
    }

    @Autowired
    public void setArteryCoilDao(ArteryCoilDao arteryCoilDao) {
        this.arteryCoilDao = arteryCoilDao;
    }
}
