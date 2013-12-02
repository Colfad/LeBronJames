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
@Table(name = "xz_hepatoma_tumor")
public class HepatomaTumor extends BaseEntity {

    private String checkTime;

    private String cea;

    private String ca;

    private String afp;

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

    public String getCea() {
        return cea;
    }

    public void setCea(String cea) {
        this.cea = cea;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }
}
