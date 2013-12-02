package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 治疗信息
 *
 * @author James
 */
@Entity
@Table(name = "xz_artery_treat")
public class ArteryTreat extends BaseEntity {

    /** 距造影时间 */
    private String toShTime;

    private String microcatheter;

    private String guidewire;

    private String guiding;

    /** 辅助 */
    private String auxiliary;

    private String stent;

    private boolean technicalSuccess;

    /** 并发症 */
    private String complication;

    /** 住院时间 */
    private String checkInTime;

    /** 出院时间 */
    private String checkOutTime;

    /** 备注 */
    private String memo;

    private Artery parent;

    @OneToOne
    public Artery getParent() {
        return parent;
    }

    public void setParent(Artery parent) {
        this.parent = parent;
    }

    public String getToShTime() {
        return toShTime;
    }

    public void setToShTime(String toShTime) {
        this.toShTime = toShTime;
    }

    public String getMicrocatheter() {
        return microcatheter;
    }

    public void setMicrocatheter(String microcatheter) {
        this.microcatheter = microcatheter;
    }

    public String getGuidewire() {
        return guidewire;
    }

    public void setGuidewire(String guidewire) {
        this.guidewire = guidewire;
    }

    public String getGuiding() {
        return guiding;
    }

    public void setGuiding(String guiding) {
        this.guiding = guiding;
    }

    public String getAuxiliary() {
        return auxiliary;
    }

    public void setAuxiliary(String auxiliary) {
        this.auxiliary = auxiliary;
    }

    public String getStent() {
        return stent;
    }

    public void setStent(String stent) {
        this.stent = stent;
    }

    public boolean isTechnicalSuccess() {
        return technicalSuccess;
    }

    public void setTechnicalSuccess(boolean technicalSuccess) {
        this.technicalSuccess = technicalSuccess;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
