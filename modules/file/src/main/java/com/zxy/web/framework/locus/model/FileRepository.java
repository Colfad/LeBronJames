package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

/**
 * File Repository
 * 只存储文件的UUID类型
 *
 * @author James
 */
public class FileRepository extends BaseEntity {

    /** mime type name like application/ms-excel */
    private String mimeTypeName;

    /** mime type extension like .xls */
    private String mimeTypeExtensionName;

    public String getMimeTypeName() {
        return mimeTypeName;
    }

    public void setMimeTypeName(String mimeTypeName) {
        this.mimeTypeName = mimeTypeName;
    }

    public String getMimeTypeExtensionName() {
        return mimeTypeExtensionName;
    }

    public void setMimeTypeExtensionName(String mimeTypeExtensionName) {
        this.mimeTypeExtensionName = mimeTypeExtensionName;
    }
}
