package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Privilege.
 */
@Data
@NoArgsConstructor
public class Privilege implements Serializable{
    private static final long serialVersionUID = 3995552749785978360L;
    private Long id;

    private Long parentId;

    private String name;

    private String url;

    private String remark;

    private Date createTime;
}