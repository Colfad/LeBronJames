package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Coil
 *
 * @author James
 */
@Entity
@Table(name = "xz_artery_coil")
public class ArteryCoil extends BaseEntity {
    /** 数目 */
    private String number;

    /** 成篮圈直径，长度 */
    private String length;

    /** 10系总长 */
    private String tenTotalLength;

    /** 12系总长 */
    private String tweTotalLength;

    /** 18系总长 */
    private String engTotalLength;

    /** 栓塞比 */
    private String bi;

    private Artery parent;

    @OneToOne
    public Artery getParent() {
        return parent;
    }

    public void setParent(Artery parent) {
        this.parent = parent;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTenTotalLength() {
        return tenTotalLength;
    }

    public void setTenTotalLength(String tenTotalLength) {
        this.tenTotalLength = tenTotalLength;
    }

    public String getTweTotalLength() {
        return tweTotalLength;
    }

    public void setTweTotalLength(String tweTotalLength) {
        this.tweTotalLength = tweTotalLength;
    }

    public String getEngTotalLength() {
        return engTotalLength;
    }

    public void setEngTotalLength(String engTotalLength) {
        this.engTotalLength = engTotalLength;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }
}
