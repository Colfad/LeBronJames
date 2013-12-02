package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 黄疸影像信息
 *
 * @author James
 */
@Entity
@Table(name = "xz_icterus_pic")
public class IcterusPic extends BaseEntity {
    /** CT时间 */
    private String ctTime;

    /** MR时间 */
    private String mrTime;

    /** MRCP时间 */
    private String mrcpTime;

    /** PET-CT时间 */
    private String petctTime;

    /** CT报告 */
    private String ctReport;

    /** MR报告 */
    private String mrReport;

    /** MRCP报告 */
    private String mrcpReport;

    /** PET-CT报告 */
    private String petctReport;

    /** ECT报告 */
    private String ectReport;

    /** 肿瘤位置 */
    private String site;

    /** 肿瘤高度 */
    private String height;

    /** 肿瘤长度 */
    private String length;

    /** 肿瘤高度 */
    private String width;

    /** 肿瘤类型 */
    private String type;

    /** 胆道狭窄度 */
    private String cuLength;

    /** 支架的通畅行 */
    private String strut;

    /** 支架是否位移 */
    private boolean strutMove;

    /** I-125粒子数目 */
    private String iNumber;

    /** I-125粒子位置是否位移 */
    private boolean iMove;

    /** I-125粒子辐射剂量 */
    private String iMount;

    private Icterus parent;

    public String getCtTime() {
        return ctTime;
    }

    public void setCtTime(String ctTime) {
        this.ctTime = ctTime;
    }

    public String getMrTime() {
        return mrTime;
    }

    public void setMrTime(String mrTime) {
        this.mrTime = mrTime;
    }

    public String getMrcpTime() {
        return mrcpTime;
    }

    public void setMrcpTime(String mrcpTime) {
        this.mrcpTime = mrcpTime;
    }

    public String getPetctTime() {
        return petctTime;
    }

    public void setPetctTime(String petctTime) {
        this.petctTime = petctTime;
    }

    public String getCtReport() {
        return ctReport;
    }

    public void setCtReport(String ctReport) {
        this.ctReport = ctReport;
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

    public String getPetctReport() {
        return petctReport;
    }

    public void setPetctReport(String petctReport) {
        this.petctReport = petctReport;
    }

    public String getEctReport() {
        return ectReport;
    }

    public void setEctReport(String ectReport) {
        this.ectReport = ectReport;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCuLength() {
        return cuLength;
    }

    public void setCuLength(String cuLength) {
        this.cuLength = cuLength;
    }

    public String getStrut() {
        return strut;
    }

    public void setStrut(String strut) {
        this.strut = strut;
    }

    public boolean isStrutMove() {
        return strutMove;
    }

    public void setStrutMove(boolean strutMove) {
        this.strutMove = strutMove;
    }

    public String getiNumber() {
        return iNumber;
    }

    public void setiNumber(String iNumber) {
        this.iNumber = iNumber;
    }

    public boolean isiMove() {
        return iMove;
    }

    public void setiMove(boolean iMove) {
        this.iMove = iMove;
    }

    public String getiMount() {
        return iMount;
    }

    public void setiMount(String iMount) {
        this.iMount = iMount;
    }

    @OneToOne
    public Icterus getParent() {
        return parent;
    }

    public void setParent(Icterus parent) {
        this.parent = parent;
    }
}
