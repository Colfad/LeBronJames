package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author James
 */
@Entity
@Table(name = "xz_icterus_operate")
public class IcterusOperate extends BaseEntity {

    /** 手术时间 */
    private String operateTime;

    /** 手术者 */
    private String operator;

    /** 手术报告 */
    private String operateReport;

    /** 胆管狭窄位置 */
    private String site;

    /** 胆管狭窄长度 */
    private String width;

    /** 术前有无感染 */
    private boolean infectBeforeOperate;

    /** 引流管个数 */
    private String numberOfDrain;

    /** 支架个数 */
    private String numberOfStrut;

    /** 支架种类  (国产 或 进口) */
    private String strutType;

    /** 支架型号 （？MM*? CM） */
    private String strutSize;

    /** 碘粒子个数 */
    private String numberOfD;

    /** 碘粒子条数 */
    private String piceceOfD;

    /** 碘粒子单个剂量（单位mci） */
    private String dSize;

    /** 碘粒子总剂量 （密排 或 疏排） */
    private String dTotal;

    /** 碘粒子排布方式 */
    private String dType;

    /** 手术结果 （是否成功） */
    private boolean operateSuccess;

    /** 手术不成功原因 */
    private String operateReason;

    /** 并发症 （有 或 无） */
    private boolean complication;

    /** 并发症详情 */
    private String complicationDetail;

    /** 并发症处理 */
    private String complicationResult;

    /** 引流管拔除（有 或 无） */
    private boolean takeOver;

    /** 引流管拔除时间 */
    private String takeOverTime;

    /** 出院时间 */
    private String checkOutTime;

    private Icterus parent;

    @OneToOne
    public Icterus getParent() {
        return parent;
    }

    public void setParent(Icterus parent) {
        this.parent = parent;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateReport() {
        return operateReport;
    }

    public void setOperateReport(String operateReport) {
        this.operateReport = operateReport;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public boolean isInfectBeforeOperate() {
        return infectBeforeOperate;
    }

    public void setInfectBeforeOperate(boolean infectBeforeOperate) {
        this.infectBeforeOperate = infectBeforeOperate;
    }

    public String getNumberOfDrain() {
        return numberOfDrain;
    }

    public void setNumberOfDrain(String numberOfDrain) {
        this.numberOfDrain = numberOfDrain;
    }

    public String getNumberOfStrut() {
        return numberOfStrut;
    }

    public void setNumberOfStrut(String numberOfStrut) {
        this.numberOfStrut = numberOfStrut;
    }

    public String getStrutType() {
        return strutType;
    }

    public void setStrutType(String strutType) {
        this.strutType = strutType;
    }

    public String getStrutSize() {
        return strutSize;
    }

    public void setStrutSize(String strutSize) {
        this.strutSize = strutSize;
    }

    public String getNumberOfD() {
        return numberOfD;
    }

    public void setNumberOfD(String numberOfD) {
        this.numberOfD = numberOfD;
    }

    public String getPiceceOfD() {
        return piceceOfD;
    }

    public void setPiceceOfD(String piceceOfD) {
        this.piceceOfD = piceceOfD;
    }

    public String getdSize() {
        return dSize;
    }

    public void setdSize(String dSize) {
        this.dSize = dSize;
    }

    public String getdTotal() {
        return dTotal;
    }

    public void setdTotal(String dTotal) {
        this.dTotal = dTotal;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public boolean isOperateSuccess() {
        return operateSuccess;
    }

    public void setOperateSuccess(boolean operateSuccess) {
        this.operateSuccess = operateSuccess;
    }

    public String getOperateReason() {
        return operateReason;
    }

    public void setOperateReason(String operateReason) {
        this.operateReason = operateReason;
    }

    public boolean isComplication() {
        return complication;
    }

    public void setComplication(boolean complication) {
        this.complication = complication;
    }

    public String getComplicationDetail() {
        return complicationDetail;
    }

    public void setComplicationDetail(String complicationDetail) {
        this.complicationDetail = complicationDetail;
    }

    public String getComplicationResult() {
        return complicationResult;
    }

    public void setComplicationResult(String complicationResult) {
        this.complicationResult = complicationResult;
    }

    public boolean isTakeOver() {
        return takeOver;
    }

    public void setTakeOver(boolean takeOver) {
        this.takeOver = takeOver;
    }

    public String getTakeOverTime() {
        return takeOverTime;
    }

    public void setTakeOverTime(String takeOverTime) {
        this.takeOverTime = takeOverTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
