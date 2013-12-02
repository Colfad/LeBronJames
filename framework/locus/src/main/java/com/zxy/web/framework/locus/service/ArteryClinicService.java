package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.ArteryClinic;
import com.zxy.web.framework.locus.repository.jpa.ArteryClinicDao;
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
public class ArteryClinicService {

    private ArteryClinicDao arteryClinicDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(ArteryClinic arteryClinic) {

        arteryClinicDao.save(arteryClinic);
    }

    public ArteryClinic getArteryClinic(String id) {
        return arteryClinicDao.findOne(id);
    }

    public ArteryClinic findByParentId(String parentId) {
        return arteryClinicDao.findByParentId(parentId);
    }

    public ArteryClinicDao getArteryClinicDao() {
        return arteryClinicDao;
    }

    @Autowired
    public void setArteryClinicDao(ArteryClinicDao arteryClinicDao) {
        this.arteryClinicDao = arteryClinicDao;
    }
}
