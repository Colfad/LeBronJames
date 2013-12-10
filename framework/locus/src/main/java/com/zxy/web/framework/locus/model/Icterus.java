package com.zxy.web.framework.locus.model;

import javax.persistence.*;
import java.util.List;

/**
 * 黄疸病患的基本信息
 *
 * @author James
 */
@Entity
@Table(name = "xz_icterus")
public class Icterus extends PatientInfo {
    /** 邮政编码 */
    private String zCode;

    /** 入院时间 */
    private String checkInTime;

    /** 体重 */
    private String weight;

    /** 身高 */
    private String height;

    /** 手术史 */
    private String operateInfo;

    /** 其他病史 */
    private String otherOperateInfo;

    /** 体能评分 */
    private String ecog;

    /** 疼痛评分 */
    private String painScore;

    /** 临床诊断 */
    private String operateCheck;

    /** 诊断依据 */
    private String operateAvidence;

    /** 肿瘤类型 */
    private String cType;

    /** 治疗分组 */
    private String treatGroup;

    /** 研究单位 */
    private String searchDept;

    private IcterusPic icterusPic;

    private IcterusOperate icterusOperate;

    private List<IcterusBlood> icterusBloods;

    private List<IcterusBiological> icterusBiologicalList;

    private List<IcterusTumor> icterusTumors;

    private List<IcterusImmune> icterusImmunes;

    private List<IcterusVisit> icterusVisits;

    @OneToMany(mappedBy = "parent")
    public List<IcterusVisit> getIcterusVisits() {
        return icterusVisits;
    }

    public void setIcterusVisits(List<IcterusVisit> icterusVisits) {
        this.icterusVisits = icterusVisits;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public IcterusOperate getIcterusOperate() {
        return icterusOperate;
    }

    public void setIcterusOperate(IcterusOperate icterusOperate) {
        this.icterusOperate = icterusOperate;
    }

    @OneToMany(mappedBy = "parent")
    public List<IcterusImmune> getIcterusImmunes() {
        return icterusImmunes;
    }

    public void setIcterusImmunes(List<IcterusImmune> icterusImmunes) {
        this.icterusImmunes = icterusImmunes;
    }

    @OneToMany(mappedBy = "parent")
    public List<IcterusTumor> getIcterusTumors() {
        return icterusTumors;
    }

    public void setIcterusTumors(List<IcterusTumor> icterusTumors) {
        this.icterusTumors = icterusTumors;
    }

    @OneToMany(mappedBy = "parent")
    public List<IcterusBlood> getIcterusBloods() {
        return icterusBloods;
    }

    public void setIcterusBloods(List<IcterusBlood> icterusBloods) {
        this.icterusBloods = icterusBloods;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public IcterusPic getIcterusPic() {
        return icterusPic;
    }

    public void setIcterusPic(IcterusPic icterusPic) {
        this.icterusPic = icterusPic;
    }

    @OneToMany(mappedBy = "parent")
    public List<IcterusBiological> getIcterusBiologicalList() {
        return icterusBiologicalList;
    }

    public void setIcterusBiologicalList(List<IcterusBiological> icterusBiologicalList) {
        this.icterusBiologicalList = icterusBiologicalList;
    }

    public String getzCode() {
        return zCode;
    }

    public void setzCode(String zCode) {
        this.zCode = zCode;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getOperateInfo() {
        return operateInfo;
    }

    public void setOperateInfo(String operateInfo) {
        this.operateInfo = operateInfo;
    }

    public String getEcog() {
        return ecog;
    }

    public void setEcog(String ecog) {
        this.ecog = ecog;
    }

    public String getPainScore() {
        return painScore;
    }

    public void setPainScore(String painScore) {
        this.painScore = painScore;
    }

    public String getOperateCheck() {
        return operateCheck;
    }

    public void setOperateCheck(String operateCheck) {
        this.operateCheck = operateCheck;
    }

    public String getOperateAvidence() {
        return operateAvidence;
    }

    public void setOperateAvidence(String operateAvidence) {
        this.operateAvidence = operateAvidence;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getTreatGroup() {
        return treatGroup;
    }

    public void setTreatGroup(String treatGroup) {
        this.treatGroup = treatGroup;
    }

    public String getSearchDept() {
        return searchDept;
    }

    public void setSearchDept(String searchDept) {
        this.searchDept = searchDept;
    }

    public String getOtherOperateInfo() {
        return otherOperateInfo;
    }

    public void setOtherOperateInfo(String otherOperateInfo) {
        this.otherOperateInfo = otherOperateInfo;
    }
}
