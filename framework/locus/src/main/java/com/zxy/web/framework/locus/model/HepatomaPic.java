package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "xz_hepatoma_pic")
public class HepatomaPic extends BaseEntity {
    /** CT检查日期 */
    private String ctTime;

    /** MR检查日期 */
    private String mrTime;

    /** PET-CT检查日期 */
    private String petctTime;

    /** ECT检查日期 */
    private String ectTime;

    /** CT检查报告 */
    private String ctReport;

    /** MR检查报告 */
    private String mrReport;

    /** PET-CT检查报告 */
    private String petctReport;

    /** ECT检查报告 */
    private String ectReport;

    /** 肿瘤类型（结节型，巨块型，弥漫型） */
    private String lType;

    /** 肿瘤数目 (1,2,3,多个) */
    private String amount;

    /** 门静脉癌栓 (有或无) */
    private boolean mjm;

    /** 门静脉癌栓位置 */
    private String mjmDetail;

    /** 肝静脉癌栓 (有或无) */
    private boolean gjm;

    /** 肝静脉癌栓位置 */
    private String gjmDetail;

    /** 下腔静脉癌栓 (有或无) */
    private boolean sqm;

    /** 下腔静脉癌栓位置 */
    private String sqmDetail;

    /** 肝动脉门静脉瘘 (有或无) */
    private boolean gdm;

    /** 肝动脉门静脉瘘位置 */
    private String gdmDetail;

    /** 肝动脉肝静脉瘘 (有或无) */
    private boolean gjml;

    /** 肝动脉肝静脉瘘位置 */
    private String gjmlDetail;

    /** 胆管侵犯 (有或无) */
    private boolean dgqf;

    /** 胆管扩张 (有或无) */
    private boolean dgkz;

    /** 淋巴结转移 (有或无) 位置 */
    private boolean lbjzy;

    /** 淋巴结转移 (有或无) 位置 */
    private String lbjzyDetail;

    /** 骨转移 (有或无)  位置 */
    private boolean gzy;

    /** 骨转移 (有或无)  位置 */
    private String gzyDetail;

    /** 肾上腺转移 (有或无) 位置 */
    private boolean ssxzy;

    /** 肾上腺转移 (有或无) 位置 */
    private String ssxzyDetail;

    /** 肝硬化 （有或无） */
    private boolean liver;

    /** 腹水 (无，少，中等，大量) */
    private String fs;

    /** 胸水 (无，少，中等，大量) */
    private String xs;

    /** 食管胃底静脉曲张 （无，有） */
    private boolean sgwqz;

    /** 脾大 （有或无） */
    private boolean pd;

    /** 肿瘤1碘油沉积 （好，中，差） */
    private String one;

    /** 肿瘤2碘油沉积 （好，中，差） */
    private String two;

    /** 肿瘤3碘油沉积 （好，中，差) */
    private String three;

    private Hepatoma parent;

    @OneToOne
    public Hepatoma getParent() {
        return parent;
    }

    public void setParent(Hepatoma parent) {
        this.parent = parent;
    }

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

    public String getPetctTime() {
        return petctTime;
    }

    public void setPetctTime(String petctTime) {
        this.petctTime = petctTime;
    }

    public String getEctTime() {
        return ectTime;
    }

    public void setEctTime(String ectTime) {
        this.ectTime = ectTime;
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

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public boolean isMjm() {
        return mjm;
    }

    public void setMjm(boolean mjm) {
        this.mjm = mjm;
    }

    public String getMjmDetail() {
        return mjmDetail;
    }

    public void setMjmDetail(String mjmDetail) {
        this.mjmDetail = mjmDetail;
    }

    public boolean isGjm() {
        return gjm;
    }

    public void setGjm(boolean gjm) {
        this.gjm = gjm;
    }

    public String getGjmDetail() {
        return gjmDetail;
    }

    public void setGjmDetail(String gjmDetail) {
        this.gjmDetail = gjmDetail;
    }

    public boolean isSqm() {
        return sqm;
    }

    public void setSqm(boolean sqm) {
        this.sqm = sqm;
    }

    public String getSqmDetail() {
        return sqmDetail;
    }

    public void setSqmDetail(String sqmDetail) {
        this.sqmDetail = sqmDetail;
    }

    public boolean isGdm() {
        return gdm;
    }

    public void setGdm(boolean gdm) {
        this.gdm = gdm;
    }

    public String getGdmDetail() {
        return gdmDetail;
    }

    public void setGdmDetail(String gdmDetail) {
        this.gdmDetail = gdmDetail;
    }

    public boolean isGjml() {
        return gjml;
    }

    public void setGjml(boolean gjml) {
        this.gjml = gjml;
    }

    public String getGjmlDetail() {
        return gjmlDetail;
    }

    public void setGjmlDetail(String gjmlDetail) {
        this.gjmlDetail = gjmlDetail;
    }

    public boolean isDgqf() {
        return dgqf;
    }

    public void setDgqf(boolean dgqf) {
        this.dgqf = dgqf;
    }

    public boolean isDgkz() {
        return dgkz;
    }

    public void setDgkz(boolean dgkz) {
        this.dgkz = dgkz;
    }

    public boolean isLbjzy() {
        return lbjzy;
    }

    public void setLbjzy(boolean lbjzy) {
        this.lbjzy = lbjzy;
    }

    public String getLbjzyDetail() {
        return lbjzyDetail;
    }

    public void setLbjzyDetail(String lbjzyDetail) {
        this.lbjzyDetail = lbjzyDetail;
    }

    public boolean isGzy() {
        return gzy;
    }

    public void setGzy(boolean gzy) {
        this.gzy = gzy;
    }

    public String getGzyDetail() {
        return gzyDetail;
    }

    public void setGzyDetail(String gzyDetail) {
        this.gzyDetail = gzyDetail;
    }

    public boolean isSsxzy() {
        return ssxzy;
    }

    public void setSsxzy(boolean ssxzy) {
        this.ssxzy = ssxzy;
    }

    public String getSsxzyDetail() {
        return ssxzyDetail;
    }

    public void setSsxzyDetail(String ssxzyDetail) {
        this.ssxzyDetail = ssxzyDetail;
    }

    public boolean isLiver() {
        return liver;
    }

    public void setLiver(boolean liver) {
        this.liver = liver;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getXs() {
        return xs;
    }

    public void setXs(String xs) {
        this.xs = xs;
    }

    public boolean isSgwqz() {
        return sgwqz;
    }

    public void setSgwqz(boolean sgwqz) {
        this.sgwqz = sgwqz;
    }

    public boolean isPd() {
        return pd;
    }

    public void setPd(boolean pd) {
        this.pd = pd;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }
}
