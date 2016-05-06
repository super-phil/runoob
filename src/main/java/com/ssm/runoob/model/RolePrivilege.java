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

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Sets role id.
     *
     * @param roleId the role id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets privilege id.
     *
     * @return the privilege id
     */
    public Long getPrivilegeId() {
        return privilegeId;
    }

    /**
     * Sets privilege id.
     *
     * @param privilegeId the privilege id
     */
    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    /**
     * Gets crate time.
     *
     * @return the crate time
     */
    public Date getCrateTime() {
        return crateTime;
    }

    /**
     * Sets crate time.
     *
     * @param crateTime the crate time
     */
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }
}
