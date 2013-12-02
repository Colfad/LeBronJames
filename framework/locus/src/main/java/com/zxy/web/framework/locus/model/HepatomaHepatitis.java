package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author James
 */
@Entity
@Table(name = "xz_hepatoma_hepatitis")
public class HepatomaHepatitis extends BaseEntity {
    private String checkTime;

    private String hbsag;

    private String hbsab;

    private String hbcab;

    private String hcvab;

    private Hepatoma parent;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Hepatoma getParent() {
        return parent;
    }

    public void setParent(Hepatoma parent) {
        this.parent = parent;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getHbsag() {
        return hbsag;
    }

    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }

    public String getHbsab() {
        return hbsab;
    }

    public void setHbsab(String hbsab) {
        this.hbsab = hbsab;
    }

    public String getHbcab() {
        return hbcab;
    }

    public void setHbcab(String hbcab) {
        this.hbcab = hbcab;
    }

    public String getHcvab() {
        return hcvab;
    }

    public void setHcvab(String hcvab) {
        this.hcvab = hcvab;
    }
}
