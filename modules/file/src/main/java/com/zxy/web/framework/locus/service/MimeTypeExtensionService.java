package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.MimeTypeExtension;
import com.zxy.web.framework.locus.repository.jpa.MimeTypeExtensionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class MimeTypeExtensionService {

    private MimeTypeExtensionDao mimeTypeExtensionDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(MimeTypeExtension mimeTypeExtension) {
        mimeTypeExtensionDao.save(mimeTypeExtension);
    }

    public MimeTypeExtension getMimeTypeExtension(int id) {
        return mimeTypeExtensionDao.findOne(id);
    }

    /**
     * 根据后缀名找到所在的MimeTypeExtension以及MimeType类型，以便进行存储的操作
     *
     * @param mimeTypeExtensionName
     * @return
     */
    public MimeTypeExtension findByMimeTypeExtensionName(String mimeTypeExtensionName) {
        return mimeTypeExtensionDao.findByMimeTypeExtensionName(mimeTypeExtensionName);
    }

    public MimeTypeExtensionDao getMimeTypeExtensionDao() {
        return mimeTypeExtensionDao;
    }

    @Autowired
    public void setMimeTypeExtensionDao(MimeTypeExtensionDao mimeTypeExtensionDao) {
        this.mimeTypeExtensionDao = mimeTypeExtensionDao;
    }
}
