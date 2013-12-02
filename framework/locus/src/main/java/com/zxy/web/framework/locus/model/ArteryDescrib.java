package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 动脉瘤描述
 *
 * @author James
 */
@Entity
@Table(name = "xz_artery_describ")
public class ArteryDescrib extends BaseEntity {

    /** L/R */
    private String lr;

    private String num;

    private String shape;

    private String location;

    private String length;

    private String width;

    private String height;

    private String volume;

    private String parentA;

    /** ratio(Neck/Artery */
    private String ratioNeck;

    /** ratio(Dome/Neck) */
    private String ratioDome;

    /** 血管痉挛 */
    private String blood;

    private Artery parent;

    @OneToOne
    public Artery getParent() {
        return parent;
    }

    public void setParent(Artery parent) {
        this.parent = parent;
    }

    public String getParentA() {
        return parentA;
    }

    public void setParentA(String parentA) {
        this.parentA = parentA;
    }

    public String getLr() {
        return lr;
    }

    public void setLr(String lr) {
        this.lr = lr;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getRatioNeck() {
        return ratioNeck;
    }

    public void setRatioNeck(String ratioNeck) {
        this.ratioNeck = ratioNeck;
    }

    public String getRatioDome() {
        return ratioDome;
    }

    public void setRatioDome(String ratioDome) {
        this.ratioDome = ratioDome;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
