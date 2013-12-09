package com.zxy.web.module.core.model;

import com.zxy.web.module.core.orm.model.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * 菜单
 * 菜单是有层级关系，这里封装为core包的方式。
 * 跟其他项目没有太多关系
 *
 * @author James
 */
@Entity
@Table(name = "xz_menu")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Menu extends BaseEntity {
    private String menuName;

    private String menuUrl;

    private Menu parent;

    private List<Menu> menuList;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
