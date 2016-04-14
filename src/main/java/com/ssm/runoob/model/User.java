package com.ssm.runoob.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = -6305517349569466735L;
    private Long id;
    private String name;
    private String pwd;
    private int status;
    private String mobile;
    private String email;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (status != user.status) return false;
        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        if (!pwd.equals(user.pwd)) return false;
        if (!mobile.equals(user.mobile)) return false;
        if (!email.equals(user.email)) return false;
        if (!createTime.equals(user.createTime)) return false;
        return updateTime.equals(user.updateTime);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + pwd.hashCode();
        result = 31 * result + status;
        result = 31 * result + mobile.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + createTime.hashCode();
        result = 31 * result + updateTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", status=" + status +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}