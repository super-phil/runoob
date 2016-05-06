package com.ssm.runoob.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type Role.
 */
public class Role  implements Serializable{
    private static final long serialVersionUID = 2191082512416800373L;
    private Long id;

    private String name;

    private String remark;

    private Date createTime;

    private List<Privilege> privileges;

    /**
     * Gets privileges.
     *
     * @return the privileges
     */
    public List<Privilege> getPrivileges() {
        return privileges;
    }

    /**
     * Sets privileges.
     *
     * @param privileges the privileges
     */
    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * Gets remark.
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets remark.
     *
     * @param remark the remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets create time.
     *
     * @return the create time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Sets create time.
     *
     * @param createTime the create time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}