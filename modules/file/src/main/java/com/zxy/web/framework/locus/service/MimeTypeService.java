package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.MimeType;
import com.zxy.web.framework.locus.repository.jpa.MimeTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class MimeTypeService {

    private MimeTypeDao mimeTypeDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(MimeType mimeType) {
        mimeTypeDao.save(mimeType);
    }

    public MimeType getMimeType(int id) {
        return mimeTypeDao.findOne(id);
    }

    public MimeTypeDao getMimeTypeDao() {
        return mimeTypeDao;
    }

    @Autowired
    public void setMimeTypeDao(MimeTypeDao mimeTypeDao) {
        this.mimeTypeDao = mimeTypeDao;
    }
}
