package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PatientInfo extends BaseEntity {

    /** 住院 */
    private String patientNumber;

    /** 病人名 */
    private String patientName;

    /** 病人性别 */
    private boolean patientSex;

    /** 病人年龄 */
    private String patientAge;

    /** 病人的联系方式 */
    private String patientMobile;

    /** 联系地址 */
    private String patientAddress;

    /** 是否有高血压史 */
    private boolean highBloodPressure;

    /** 是否是糖尿病 */
    private boolean glycuresis;

    /** 高血脂 */
    private boolean bloodFat;

    /** 心脏病 */
    private boolean heartDisease;

    /** 是否吸烟 */
    private boolean smoking;

    /** 是否酗酒 */
    private boolean drink;

    /** 家族病史 */
    private boolean familyHistory;

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public boolean isPatientSex() {
        return patientSex;
    }

    public void setPatientSex(boolean patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public boolean isHighBloodPressure() {
        return highBloodPressure;
    }

    public void setHighBloodPressure(boolean highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public boolean isGlycuresis() {
        return glycuresis;
    }

    public void setGlycuresis(boolean glycuresis) {
        this.glycuresis = glycuresis;
    }

    public boolean isBloodFat() {
        return bloodFat;
    }

    public void setBloodFat(boolean bloodFat) {
        this.bloodFat = bloodFat;
    }

    public boolean isHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(boolean heartDisease) {
        this.heartDisease = heartDisease;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isDrink() {
        return drink;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    public boolean isFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(boolean familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }
}
