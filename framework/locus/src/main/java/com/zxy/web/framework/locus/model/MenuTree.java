package com.zxy.web.framework.locus.model;

import com.zxy.web.module.core.orm.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "xz_menu_tree")
public class MenuTree extends BaseEntity {
    private String menuName;

    private String url;

//    private MenuTree parent;

//    private List<MenuTree> children;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

/*    @OneToOne
    public MenuTree getParent() {
        return parent;
    }

    public void setParent(MenuTree parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }*/
}
