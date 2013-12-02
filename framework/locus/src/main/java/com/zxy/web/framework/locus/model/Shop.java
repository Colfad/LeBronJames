package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * 用户的商铺
 *
 * @author James
 */
@Entity
@Table(name = "xz_shop")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Shop extends BaseEntity {
    /** 店铺的名称 */
    private String shopName;

    /** 店铺的得分 */
    private Double score;

    /** 店铺的内容 */
    private String content;

    /** 店铺的地址 */
    private String site;

    /** 店铺的联系电话 */
    private String phone;

    /** 店铺的营业执照 */
    private String manageCode;

    /** 店铺的图片 */
    private Image image;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getManageCode() {
        return manageCode;
    }

    public void setManageCode(String manageCode) {
        this.manageCode = manageCode;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
