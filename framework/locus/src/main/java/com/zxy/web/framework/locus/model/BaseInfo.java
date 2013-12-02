package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "xz_baseInfo")
public class BaseInfo extends BaseEntity {
    private String patientId;

    private String patientName;

    private String ceReport;

    private String ctDate;

    private String mrReport;

    private String mrDate;

    private String mrcpReport;

    private String mcrpDate;

    private String tumorKind;

    private String rumorLength;

    private String rumorWidth;

    private String rumorHeight;

    private String tumorLocation;

    private String biliaryStenosis;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getCeReport() {
        return ceReport;
    }

    public void setCeReport(String ceReport) {
        this.ceReport = ceReport;
    }

    public String getMrReport() {
        return mrReport;
    }

    public void setMrReport(String mrReport) {
        this.mrReport = mrReport;
    }

    public String getMrcpReport() {
        return mrcpReport;
    }

    public void setMrcpReport(String mrcpReport) {
        this.mrcpReport = mrcpReport;
    }

    public String getTumorKind() {
        return tumorKind;
    }

    public void setTumorKind(String tumorKind) {
        this.tumorKind = tumorKind;
    }

    public String getRumorLength() {
        return rumorLength;
    }

    public void setRumorLength(String rumorLength) {
        this.rumorLength = rumorLength;
    }

    public String getRumorHeight() {
        return rumorHeight;
    }

    public void setRumorHeight(String rumorHeight) {
        this.rumorHeight = rumorHeight;
    }

    public String getRumorWidth() {
        return rumorWidth;
    }

    public void setRumorWidth(String rumorWidth) {
        this.rumorWidth = rumorWidth;
    }

    public String getTumorLocation() {
        return tumorLocation;
    }

    public void setTumorLocation(String tumorLocation) {
        this.tumorLocation = tumorLocation;
    }

    public String getBiliaryStenosis() {
        return biliaryStenosis;
    }

    public void setBiliaryStenosis(String biliaryStenosis) {
        this.biliaryStenosis = biliaryStenosis;
    }

    public String getCtDate() {
        return ctDate;
    }

    public void setCtDate(String ctDate) {
        this.ctDate = ctDate;
    }

    public String getMrDate() {
        return mrDate;
    }

    public void setMrDate(String mrDate) {
        this.mrDate = mrDate;
    }

    public String getMcrpDate() {
        return mcrpDate;
    }

    public void setMcrpDate(String mcrpDate) {
        this.mcrpDate = mcrpDate;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
