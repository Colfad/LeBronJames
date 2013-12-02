package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.HepatomaPic;
import com.zxy.web.framework.locus.repository.jpa.HepatomaPicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class HepatomaPicService {

    private HepatomaPicDao hepatomaPicDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(HepatomaPic hepatomaPic) {
        hepatomaPicDao.save(hepatomaPic);
    }

    public HepatomaPicDao getHepatomaPicDao() {
        return hepatomaPicDao;
    }

    @Autowired
    public void setHepatomaPicDao(HepatomaPicDao hepatomaPicDao) {
        this.hepatomaPicDao = hepatomaPicDao;
    }
}
