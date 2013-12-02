package com.zxy.web.framework.locus.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author James
 */
@Entity
@Table(name = "xz_hepatoma")
public class Hepatoma extends PatientInfo {

    /** 邮政编码 */
    private String zCode;

    /** 乙肝 有/无 */
    private boolean hepatitis;

    /** 丙肝 有/无 */
    private boolean annt;

    /** 血吸虫感染病史 有/无 */
    private boolean schistosome;

    /** 肝硬化 有/无 */
    private boolean cirrhosis;

    /** 肝脏其他疾病 */
    private boolean otherLiver;

    /** 肿瘤活检 有/无 */
    private boolean checkLiver;

    /** 手术史 */
    private String operateHistory;

    /** 其他病史 */
    private String otherDis;

    /** 体能评分(ECOG) (0-4) */
    private String bodyScore;

    /** 疼痛评分 (0-10) */
    private String painScore;

    /** 临床诊断 */
    private String check;

    /** 诊断依据 */
    private String depend;

    /** 肿瘤病理类型 */
    private String lType;

    /** 治疗分组 */
    private String treatGroup;

    /** 研究单位 */
    private String searchDept;

    private HepatomaPic hepatomaPic;

    private List<HepatomaBiological> hepatomaBiologicalList;

    private List<HepatomaBlood> hepatomaBloods;

    private List<HepatomaHepatitis> hepatomaHepatitises;

    private List<HepatomaTumor> hepatomaTumors;

    private List<HepatomaVisit> hepatomaVisits;

    @OneToMany(mappedBy = "parent")
    public List<HepatomaVisit> getHepatomaVisits() {
        return hepatomaVisits;
    }

    public void setHepatomaVisits(List<HepatomaVisit> hepatomaVisits) {
        this.hepatomaVisits = hepatomaVisits;
    }

    @OneToMany(mappedBy = "parent")
    public List<HepatomaTumor> getHepatomaTumors() {
        return hepatomaTumors;
    }

    public void setHepatomaTumors(List<HepatomaTumor> hepatomaTumors) {
        this.hepatomaTumors = hepatomaTumors;
    }

    @OneToMany(mappedBy = "parent")
    public List<HepatomaHepatitis> getHepatomaHepatitises() {
        return hepatomaHepatitises;
    }

    public void setHepatomaHepatitises(List<HepatomaHepatitis> hepatomaHepatitises) {
        this.hepatomaHepatitises = hepatomaHepatitises;
    }

    @OneToMany(mappedBy = "parent")
    public List<HepatomaBlood> getHepatomaBloods() {
        return hepatomaBloods;
    }

    public void setHepatomaBloods(List<HepatomaBlood> hepatomaBloods) {
        this.hepatomaBloods = hepatomaBloods;
    }

    @OneToMany(mappedBy = "parent")
    public List<HepatomaBiological> getHepatomaBiologicalList() {
        return hepatomaBiologicalList;
    }

    public void setHepatomaBiologicalList(List<HepatomaBiological> hepatomaBiologicalList) {
        this.hepatomaBiologicalList = hepatomaBiologicalList;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public HepatomaPic getHepatomaPic() {
        return hepatomaPic;
    }

    public void setHepatomaPic(HepatomaPic hepatomaPic) {
        this.hepatomaPic = hepatomaPic;
    }

    public String getzCode() {
        return zCode;
    }

    public void setzCode(String zCode) {
        this.zCode = zCode;
    }

    public boolean isHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(boolean hepatitis) {
        this.hepatitis = hepatitis;
    }

    public boolean isAnnt() {
        return annt;
    }

    public void setAnnt(boolean annt) {
        this.annt = annt;
    }

    public boolean isSchistosome() {
        return schistosome;
    }

    public void setSchistosome(boolean schistosome) {
        this.schistosome = schistosome;
    }

    public boolean isCirrhosis() {
        return cirrhosis;
    }

    public void setCirrhosis(boolean cirrhosis) {
        this.cirrhosis = cirrhosis;
    }

    public boolean isOtherLiver() {
        return otherLiver;
    }

    public void setOtherLiver(boolean otherLiver) {
        this.otherLiver = otherLiver;
    }

    public boolean isCheckLiver() {
        return checkLiver;
    }

    public void setCheckLiver(boolean checkLiver) {
        this.checkLiver = checkLiver;
    }

    public String getOperateHistory() {
        return operateHistory;
    }

    public void setOperateHistory(String operateHistory) {
        this.operateHistory = operateHistory;
    }

    public String getOtherDis() {
        return otherDis;
    }

    public void setOtherDis(String otherDis) {
        this.otherDis = otherDis;
    }

    public String getBodyScore() {
        return bodyScore;
    }

    public void setBodyScore(String bodyScore) {
        this.bodyScore = bodyScore;
    }

    public String getPainScore() {
        return painScore;
    }

    public void setPainScore(String painScore) {
        this.painScore = painScore;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getDepend() {
        return depend;
    }

    public void setDepend(String depend) {
        this.depend = depend;
    }

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType;
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
}
