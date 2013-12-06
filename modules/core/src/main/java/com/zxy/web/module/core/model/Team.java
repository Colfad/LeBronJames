package com.zxy.web.module.core.model;

import com.zxy.web.module.core.orm.model.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * 用户组
 *
 * @author James
 */
@Entity
@Table(name = "xz_team")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Team extends BaseEntity {
    private String teamName;

    private List<User> userList;

    private List<Role> roleList;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @OneToMany(mappedBy = "team")
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @ManyToMany
    @JoinTable(name = "xz_team_role", joinColumns = {@JoinColumn(name = "team_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id ASC")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
