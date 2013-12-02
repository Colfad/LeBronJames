package com.zxy.web.framework.locus.model;

import com.google.common.collect.Lists;
import com.zxy.web.module.core.orm.model.BaseEntity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * 商品的类别表
 *
 * @author James
 */
@Entity
@Table(name = "xz_good_type")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GoodType extends BaseEntity {
    private String typeName;

    private GoodType parent;

    private Boolean leaf;

    private List<GoodType> typeList = Lists.newArrayList();;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @OneToOne
    public GoodType getParent() {
        return parent;
    }

    public void setParent(GoodType parent) {
        this.parent = parent;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    /**
     * 只为在MYBATIS工作的时候可以更加方便的进行操    作
     *
     * @return
     */
    @OneToMany(mappedBy = "parent")
    public List<GoodType> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<GoodType> typeList) {
        this.typeList = typeList;
    }
}
