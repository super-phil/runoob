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

    /**
     * Instantiates a new Msg.
     */
    public Msg() {
    }

    /**
     * Instantiates a new Msg.
     *
     * @param code the code
     * @param msg  the msg
     */
    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Instantiates a new Msg.
     *
     * @param code the code
     * @param obj  the obj
     */
    public Msg(int code, Object obj) {
        this.code = code;
        this.obj = obj;
    }

    /**
     * Gets obj.
     *
     * @return the obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * Sets obj.
     *
     * @param obj the obj
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets msg.
     *
     * @param msg the msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
