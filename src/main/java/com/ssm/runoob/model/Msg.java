package com.ssm.runoob.model;

import java.io.Serializable;

/**
 * 全局提示信息
 * Created by Phil on 2015/12/19.
 */
public class Msg implements Serializable {
    private static final long serialVersionUID = -7761970428777599005L;
    private int code;
    private String msg;
    private Object obj;

    public Msg() {
    }

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
