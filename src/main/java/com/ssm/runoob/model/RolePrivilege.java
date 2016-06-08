package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Phil on 2016/4/19.
 */
@Data
@NoArgsConstructor
public class RolePrivilege implements Serializable {
    private static final long serialVersionUID = 1432366654599822026L;
    private Long id;
    private Long roleId;
    private Long privilegeId;
    private Date crateTime;
}
