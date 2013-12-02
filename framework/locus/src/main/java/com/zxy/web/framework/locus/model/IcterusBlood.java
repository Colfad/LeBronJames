package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.*;

/**
 * 黄疸血检
 *
 * @author James
 */
@Entity
@Table(name = "xz_icterus_blood")
public class IcterusBlood extends BaseEntity {
    /** */
    private String checkTime;

    /** 白细胞 */
    private String whiteBloodCell;

    /** 中性粒细胞比例 */
    private String neurtropil;

    /** 淋巴细胞比例 */
    private String lymphocyte;

    /** 血红蛋白 */
    private String hemoglobin;

    /** 血小板 */
    private String platelet;

    /** 血培养 */
    private boolean hemoculture;

    /** 培养细菌结果 */
    private String cultureBacteriaResult;

    private Icterus parent;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Icterus getParent() {
        return parent;
    }

    public void setParent(Icterus parent) {
        this.parent = parent;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getWhiteBloodCell() {
        return whiteBloodCell;
    }

    public void setWhiteBloodCell(String whiteBloodCell) {
        this.whiteBloodCell = whiteBloodCell;
    }

    public String getNeurtropil() {
        return neurtropil;
    }

    public void setNeurtropil(String neurtropil) {
        this.neurtropil = neurtropil;
    }

    public String getLymphocyte() {
        return lymphocyte;
    }

    public void setLymphocyte(String lymphocyte) {
        this.lymphocyte = lymphocyte;
    }

    public String getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getPlatelet() {
        return platelet;
    }

    public void setPlatelet(String platelet) {
        this.platelet = platelet;
    }

    public boolean isHemoculture() {
        return hemoculture;
    }

    public void setHemoculture(boolean hemoculture) {
        this.hemoculture = hemoculture;
    }

    public String getCultureBacteriaResult() {
        return cultureBacteriaResult;
    }

    public void setCultureBacteriaResult(String cultureBacteriaResult) {
        this.cultureBacteriaResult = cultureBacteriaResult;
    }
}
