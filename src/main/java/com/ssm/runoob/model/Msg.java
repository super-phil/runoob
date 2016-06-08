package com.ssm.runoob.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 全局提示信息
 * Created by Phil on 2015/12/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Msg implements Serializable {
    private static final long serialVersionUID = -7761970428777599005L;
    private int code;
    private String msg;
    private Object obj;
}
