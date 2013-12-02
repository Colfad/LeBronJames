package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "xz_artery_visit")
public class ArteryVisit extends BaseEntity {
    private String visitDate;

    private String threeMRS;

    private String threeHIHSS;

    private String threeGOS;

    private String sixMRS;

    private String sixHIHSS;

    private boolean again;

    private String treatAgain;

    private Artery parent;

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getThreeMRS() {
        return threeMRS;
    }

    public void setThreeMRS(String threeMRS) {
        this.threeMRS = threeMRS;
    }

    public String getThreeHIHSS() {
        return threeHIHSS;
    }

    public void setThreeHIHSS(String threeHIHSS) {
        this.threeHIHSS = threeHIHSS;
    }

    public String getThreeGOS() {
        return threeGOS;
    }

    public void setThreeGOS(String threeGOS) {
        this.threeGOS = threeGOS;
    }

    public String getSixMRS() {
        return sixMRS;
    }

    public void setSixMRS(String sixMRS) {
        this.sixMRS = sixMRS;
    }

    public String getSixHIHSS() {
        return sixHIHSS;
    }

    public void setSixHIHSS(String sixHIHSS) {
        this.sixHIHSS = sixHIHSS;
    }

    public boolean isAgain() {
        return again;
    }

    public void setAgain(boolean again) {
        this.again = again;
    }

    public String getTreatAgain() {
        return treatAgain;
    }

    public void setTreatAgain(String treatAgain) {
        this.treatAgain = treatAgain;
    }

    @OneToOne
    public Artery getParent() {
        return parent;
    }

    public void setParent(Artery parent) {
        this.parent = parent;
    }
}
