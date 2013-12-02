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
@Table(name = "xz_icterus_visit")
public class IcterusVisit extends BaseEntity {

    /** 随访日期 */
    private String visitTime;

    /** 随访者 */
    private String visitor;

    /** 随访结果 */
    private String visitResult;

    /** 失访 （有 或 无） */
    private String loseVisit;

    /** 失访日期 （有 或 无） */
    private String loseVisitTime;

    /** 再黄疸（有 或 无） */
    private String sickAgain;

    /** 再黄疸时间 */
    private String sickAgainTime;

    /** 再黄疸处理 */
    private String treatAgain;

    /** 疼痛评分 （0-10） */
    private String painScore;

    /** 体能评分(ECOG) （0-4） */
    private String bodyScore;

    /** 有无其他问题 */
    private String otherQuestion;

    private Icterus parent;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Icterus getParent() {
        return parent;
    }

    public void setParent(Icterus parent) {
        this.parent = parent;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getVisitResult() {
        return visitResult;
    }

    public void setVisitResult(String visitResult) {
        this.visitResult = visitResult;
    }

    public String getLoseVisit() {
        return loseVisit;
    }

    public void setLoseVisit(String loseVisit) {
        this.loseVisit = loseVisit;
    }

    public String getLoseVisitTime() {
        return loseVisitTime;
    }

    public void setLoseVisitTime(String loseVisitTime) {
        this.loseVisitTime = loseVisitTime;
    }

    public String getSickAgain() {
        return sickAgain;
    }

    public void setSickAgain(String sickAgain) {
        this.sickAgain = sickAgain;
    }

    public String getSickAgainTime() {
        return sickAgainTime;
    }

    public void setSickAgainTime(String sickAgainTime) {
        this.sickAgainTime = sickAgainTime;
    }

    public String getTreatAgain() {
        return treatAgain;
    }

    public void setTreatAgain(String treatAgain) {
        this.treatAgain = treatAgain;
    }

    public String getPainScore() {
        return painScore;
    }

    public void setPainScore(String painScore) {
        this.painScore = painScore;
    }

    public String getBodyScore() {
        return bodyScore;
    }

    public void setBodyScore(String bodyScore) {
        this.bodyScore = bodyScore;
    }

    public String getOtherQuestion() {
        return otherQuestion;
    }

    public void setOtherQuestion(String otherQuestion) {
        this.otherQuestion = otherQuestion;
    }
}
