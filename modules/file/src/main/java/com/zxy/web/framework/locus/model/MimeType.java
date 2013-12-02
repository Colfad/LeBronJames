package com.zxy.web.framework.locus.model;

import javax.persistence.*;
import java.util.List;

/**
 * MimeType对应的类
 *
 * @author James
 */
@Entity
@Table(name = "xz_mime_type")
public class MimeType {
    private int id;

    private String mimeTypeName;

    private List<MimeTypeExtension> mimeTypeExtensions;

    @OneToMany(mappedBy = "mimeType")
    public List<MimeTypeExtension> getMimeTypeExtensions() {
        return mimeTypeExtensions;
    }

    public void setMimeTypeExtensions(List<MimeTypeExtension> mimeTypeExtensions) {
        this.mimeTypeExtensions = mimeTypeExtensions;
    }

    @Id
    @GeneratedValue
    @Column(name = "MT_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "MT_NAME")
    public String getMimeTypeName() {
        return mimeTypeName;
    }

    public void setMimeTypeName(String mimeTypeName) {
        this.mimeTypeName = mimeTypeName;
    }
}
