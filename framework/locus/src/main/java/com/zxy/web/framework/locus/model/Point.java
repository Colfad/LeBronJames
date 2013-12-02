package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * GIS的点
 *
 * @author James
 */
@Entity
@Table(name = "xz_point")
public class Point extends BaseEntity {

    /** 经度 */
    private String longitude;

    /** 纬度 */
    private String latitude;

    /** 点的名称 */
    private String pointName;

    /** 点的介绍内容 */
    private String content;

    /** 这个点的评分 */
    private String score;

    /** 这个店所在的点的照片 */
    private Image image;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
