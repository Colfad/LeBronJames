package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * 颅内肿瘤 病患
 *
 * @author James
 */
@Entity
@Table(name = "xz_artery_clinic")
public class ArteryClinic extends BaseEntity {
    /** 未破动脉瘤检出方式 */
    private String wpCheckout;

    /** 首发症状 */
    private String firstSign;

    /** 出血 */
    private boolean blood;

    /** Fisher 分级 */
    private String fisherLevel;

    /** 出血次数 */
    private String bloodTimes;

    /** 距CT时间 */
    private String toCTTime;

    /** 距造影时间 */
    private String toShTime;

    /** hunt-less 分级 */
    private String huntHessLevel;

    /** WFNS评分 */
    private String wfns;

    /** GCS评分 */
    private String gcs;

    /** NIHSS评分 */
    private String nihss;

    /** MRS评分 */
    private String mrs;

    /** 血压 */
    private String bloodPressure;

    private Artery parent;

    public String getWpCheckout() {
        return wpCheckout;
    }

    public void setWpCheckout(String wpCheckout) {
        this.wpCheckout = wpCheckout;
    }

    public String getFirstSign() {
        return firstSign;
    }

    public void setFirstSign(String firstSign) {
        this.firstSign = firstSign;
    }

    public boolean isBlood() {
        return blood;
    }

    public void setBlood(boolean blood) {
        this.blood = blood;
    }

    public String getFisherLevel() {
        return fisherLevel;
    }

    public void setFisherLevel(String fisherLevel) {
        this.fisherLevel = fisherLevel;
    }

    public String getBloodTimes() {
        return bloodTimes;
    }

    public void setBloodTimes(String bloodTimes) {
        this.bloodTimes = bloodTimes;
    }

    public String getToCTTime() {
        return toCTTime;
    }

    public void setToCTTime(String toCTTime) {
        this.toCTTime = toCTTime;
    }

    public String getToShTime() {
        return toShTime;
    }

    public void setToShTime(String toShTime) {
        this.toShTime = toShTime;
    }

    public String getHuntHessLevel() {
        return huntHessLevel;
    }

    public void setHuntHessLevel(String huntHessLevel) {
        this.huntHessLevel = huntHessLevel;
    }

    public String getWfns() {
        return wfns;
    }

    public void setWfns(String wfns) {
        this.wfns = wfns;
    }

    public String getGcs() {
        return gcs;
    }

    public void setGcs(String gcs) {
        this.gcs = gcs;
    }

    public String getNihss() {
        return nihss;
    }

    public void setNihss(String nihss) {
        this.nihss = nihss;
    }

    public String getMrs() {
        return mrs;
    }

    public void setMrs(String mrs) {
        this.mrs = mrs;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    @OneToOne
    public Artery getParent() {
        return parent;
    }

    public void setParent(Artery parent) {
        this.parent = parent;
    }
}
