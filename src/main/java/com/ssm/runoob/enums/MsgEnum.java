package com.ssm.runoob.enums;

/**
 * Created by Phil on 2015/12/19.
 */
public enum MsgEnum {
    ADD_ERROR(1, "添加失败！"),
    ADD_SUCCESS(0, "添加成功！"),
    LOGIN_ERROR(1, "用户名或密码错误！"),
    LOGIN_SUCCESS(0, "登陆成功！"),
    DEL_SUCCESS(0, "删除成功！"),
    DEL_ERROR(1, "删除失败！"),
    UPDATE_SUCCESS(0, "修改成功！"),
    UPDATE_ERROR(1, "修改失败！");


    private int code;
    private String msg;


    MsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
