package com.ssm.runoob.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Phil on 2016/4/19.
 */
public class RolePrivilege implements Serializable {
    private static final long serialVersionUID = 1432366654599822026L;
    private Long id;
    private Long roleId;
    private Long privilegeId;
    private Date crateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }
}
