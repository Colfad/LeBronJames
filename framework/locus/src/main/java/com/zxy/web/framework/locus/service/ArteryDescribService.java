package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.ArteryDescrib;
import com.zxy.web.framework.locus.repository.jpa.ArteryDescribDao;
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
public class ArteryDescribService {

    private ArteryDescribDao arteryDescribDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(ArteryDescrib arteryDescrib) {
        arteryDescribDao.save(arteryDescrib);
    }

    public ArteryDescrib getArteryDescrib(String id) {
        return arteryDescribDao.findOne(id);
    }

    public ArteryDescrib getByParentId(String parentId) {
        return arteryDescribDao.findByParentId(parentId);
    }

    public ArteryDescribDao getArteryDescribDao() {
        return arteryDescribDao;
    }

    @Autowired
    public void setArteryDescribDao(ArteryDescribDao arteryDescribDao) {
        this.arteryDescribDao = arteryDescribDao;
    }
}
