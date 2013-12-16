package com.zxy.web.module.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;
import com.zxy.web.module.core.orm.model.BaseEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * 用户角色
 *
 * @author James
 */
@Entity
@Table(name = "xz_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends BaseEntity {

    @NotBlank
    private String roleName;

    private String permissions;

    @JsonIgnore
    @Column(length = 5000)
    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JsonIgnore
    @Transient
    public List<String> getPermissionList() {
        return ImmutableList.copyOf(StringUtils.split(permissions, ","));
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
