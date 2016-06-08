package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type Role.
 */
@Data
@NoArgsConstructor
public class Role  implements Serializable{
    private static final long serialVersionUID = 2191082512416800373L;
    private Long id;

    private String name;

    private String remark;

    private Date createTime;

    private List<Privilege> privileges;
}