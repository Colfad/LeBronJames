package com.zxy.web.framework.locus.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * mime type extension 就是对应mime type 的后缀
 *
 * @author James
 */
@Entity
@Table(name = "xz_mime_type_extension")
public class MimeTypeExtension {

    private MimeType mimeType;

    private String mimeTypeExtensionName;

    @ManyToOne
    @JoinColumn(name = "MTE_ID")
    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * 使用 mte_name来为id
     * 在hibernate或者jpa中，没有ID的话，会持久化出错，所以必须要指定一个id
     * 而assigned意思是由用户去指定ID的生成方式。
     * 由用户去决定ID的值，而不是自动生成或者自增长的方式
     *
     * @return
     */
    @Column(name = "MTE_NAME")
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy="assigned")
    public String getMimeTypeExtensionName() {
        return mimeTypeExtensionName;
    }

    public void setMimeTypeExtensionName(String mimeTypeExtensionName) {
        this.mimeTypeExtensionName = mimeTypeExtensionName;
    }
}
