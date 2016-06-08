package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * The type User.
 */
@Data
@NoArgsConstructor
public class User implements Serializable{

    private static final long serialVersionUID = -775808141942546102L;
    private Long id;

    private String name;

    private String pwd;

    private int status;

    private String mobile;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Role role;//角色
}