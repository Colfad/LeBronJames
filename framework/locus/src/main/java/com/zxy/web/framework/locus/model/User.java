package com.zxy.web.framework.locus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zxy.web.module.core.orm.model.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.Column;

import javax.persistence.*;
import java.util.List;

/**
 * table_name : xz_user
 *
 * @author James
 */
@Entity
@Table(name = "xz_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends BaseEntity {
    /** 用户的名称 */
    private String userName;

    /** 用户的密码 */
    private String password;

    /** 用户的真实姓名 */
    private String realName;

    /** 用户在更新以及注册时候使用的中间field */
    private String plainPassword;

    /** 用户的email */
    private String email;

    /** 用户的地址 */
    private String address;

    /** 用户的手机联系电话 */
    private String mobile;

    /** 用户的密码的加盐 */
    private String salt;

    /** 用户的头像 */
    private String userPic;

    /** 用户的状态，因为有些用户有违规的操作，那么就需要把这个用户给禁用掉 */
    private String status;

    private List<Role> roleList;

    private Team team;

    @Column(name = "user_name", length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "user_password", length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    @JsonIgnore
    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    @Column(name = "user_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "user_address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "user_mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "salt", length = 100)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Column(name = "user_pic")
    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    @Column(name = "user_status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToMany
    @JoinTable(name = "xz_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id ASC")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @ManyToOne
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
