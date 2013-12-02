package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 免疫指标检查
 *
 * @author James
 */
@Entity
@Table(name = "xz_icterus_immune")
public class IcterusImmune extends BaseEntity {

    private String checkTime;

    private String iga;

    private String igg;

    private String igm;

    private String cThree;

    private String cFour;

    private Icterus parent;

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getIga() {
        return iga;
    }

    public void setIga(String iga) {
        this.iga = iga;
    }

    public String getIgg() {
        return igg;
    }

    public void setIgg(String igg) {
        this.igg = igg;
    }

    public String getIgm() {
        return igm;
    }

    public void setIgm(String igm) {
        this.igm = igm;
    }

    public String getcThree() {
        return cThree;
    }

    public void setcThree(String cThree) {
        this.cThree = cThree;
    }

    public String getcFour() {
        return cFour;
    }

    public void setcFour(String cFour) {
        this.cFour = cFour;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Icterus getParent() {
        return parent;
    }

    public void setParent(Icterus parent) {
        this.parent = parent;
    }
}
