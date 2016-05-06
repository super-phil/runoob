package com.ssm.runoob.enums;

/**
 * Created by Phil on 2015/12/19.
 */
public enum MsgEnum {
    /**
     * Error msg enum.
     */
    ERROR(999, "服务器异常!"),
    /**
     * Illegalargument msg enum.
     */
    ILLEGALARGUMENT(998, "非法参数!"),
    /**
     * Un auth error msg enum.
     */
    UN_AUTH_ERROR(997, "您没有该功能权限,请联系管理员!"),
    /**
     * Success msg enum.
     */
    SUCCESS(0, "服务器正常!"),
    /**
     * Add error msg enum.
     */
    ADD_ERROR(1, "添加失败！"),
    /**
     * Add success msg enum.
     */
    ADD_SUCCESS(0, "添加成功！"),
    /**
     * Login error msg enum.
     */
    LOGIN_ERROR(1, "用户名或密码错误！"),
    /**
     * Login success msg enum.
     */
    LOGIN_SUCCESS(0, "登陆成功！"),
    /**
     * Del success msg enum.
     */
    DEL_SUCCESS(0, "删除成功！"),
    /**
     * Del error msg enum.
     */
    DEL_ERROR(1, "删除失败！"),
    /**
     * Update success msg enum.
     */
    UPDATE_SUCCESS(0, "修改成功！"),
    /**
     * Update error msg enum.
     */
    UPDATE_ERROR(1, "修改失败！");



    private int code;
    private String msg;


    MsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

}
