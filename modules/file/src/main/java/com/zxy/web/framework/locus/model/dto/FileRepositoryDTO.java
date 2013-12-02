package com.zxy.web.framework.locus.model.dto;

import java.io.Serializable;

/**
 *
 * @author James
 */
public class FileRepositoryDTO implements Serializable {

    /** mime type name like application/ms-excel */
    private String mimeTypeName;

    /** mime type extension like .xls */
    private String mimeTypeExtensionName;

    private byte[] content;

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
