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
@Table(name = "xz_hepatoma_biological")
public class HepatomaBiological extends BaseEntity {

    /** 检查时间 */
    private String checkTime;

    /** 谷丙转氨酶 */
    private String gpt;

    /** 谷草转氨酶 */
    private String ast;

    /** γ--谷氨酰基转移酶 */
    private String yast;

    /** 碱性磷酸酶 */
    private String akp;

    /** 白蛋白 */
    private String alb;

    /** 球蛋白 */
    private String globin;

    /** 总胆红素 */
    private String tbil;

    /** 直接胆红素 */
    private String dbil;

    /** 间接胆红素 */
    private String indirectBilirubin;

    /** 总胆固醇 */
    private String tc;

    /** 甘油三酯 */
    private String tg;

    /** 尿素 */
    private String bun;

    /** 肌酐 */
    private String ci;

    /** 钾 */
    private String potassium;

    /** 钠 */
    private String na;

    /** 氯 */
    private String chlorine;

    /** 钙 */
    private String ca;

    /** 葡萄糖 */
    private String glucose;

    private Hepatoma parent;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Hepatoma getParent() {
        return parent;
    }

    public void setParent(Hepatoma parent) {
        this.parent = parent;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getGpt() {
        return gpt;
    }

    public void setGpt(String gpt) {
        this.gpt = gpt;
    }

    public String getAst() {
        return ast;
    }

    public void setAst(String ast) {
        this.ast = ast;
    }

    public String getYast() {
        return yast;
    }

    public void setYast(String yast) {
        this.yast = yast;
    }

    public String getAkp() {
        return akp;
    }

    public void setAkp(String akp) {
        this.akp = akp;
    }

    public String getAlb() {
        return alb;
    }

    public void setAlb(String alb) {
        this.alb = alb;
    }

    public String getGlobin() {
        return globin;
    }

    public void setGlobin(String globin) {
        this.globin = globin;
    }

    public String getTbil() {
        return tbil;
    }

    public void setTbil(String tbil) {
        this.tbil = tbil;
    }

    public String getDbil() {
        return dbil;
    }

    public void setDbil(String dbil) {
        this.dbil = dbil;
    }

    public String getIndirectBilirubin() {
        return indirectBilirubin;
    }

    public void setIndirectBilirubin(String indirectBilirubin) {
        this.indirectBilirubin = indirectBilirubin;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getBun() {
        return bun;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPotassium() {
        return potassium;
    }

    public void setPotassium(String potassium) {
        this.potassium = potassium;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    public String getChlorine() {
        return chlorine;
    }

    public void setChlorine(String chlorine) {
        this.chlorine = chlorine;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }
}
