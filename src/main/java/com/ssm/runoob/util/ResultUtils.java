package com.ssm.runoob.util;

import com.alibaba.fastjson.JSONObject;
import com.ssm.runoob.enums.MsgEnum;
import com.ssm.runoob.model.Msg;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Phil on 2015/12/19.
 */
public class ResultUtils {
    /**
     * Update success json object.
     *
     * @return the json object
     */
    public static JSONObject updateSuccess() {
        return delSuccess(MsgEnum.UPDATE_SUCCESS.getMsg());
    }

    /**
     * Update success json object.
     *
     * @param msg the msg
     * @return the json object
     */
    public static JSONObject updateSuccess(String msg) {
        return msg(MsgEnum.UPDATE_SUCCESS.getCode(), msg);
    }

    /**
     * Update error json object.
     *
     * @return the json object
     */
    public static JSONObject updateError() {
        return delSuccess(MsgEnum.UPDATE_ERROR.getMsg());
    }

    /**
     * Update error json object.
     *
     * @param msg the msg
     * @return the json object
     */
    public static JSONObject updateError(String msg) {
        return msg(MsgEnum.UPDATE_ERROR.getCode(), msg);
    }

    /**
     * 删除成功
     *
     * @return json json object
     */
    public static JSONObject delSuccess() {
        return delSuccess(MsgEnum.DEL_SUCCESS.getMsg());
    }

    /**
     * 删除成功
     *
     * @param msg 自定义
     * @return json json object
     */
    public static JSONObject delSuccess(String msg) {
        return msg(MsgEnum.DEL_SUCCESS.getCode(), msg);
    }

    /**
     * 删除成功
     *
     * @return json json object
     */
    public static JSONObject delError() {
        return delError(MsgEnum.DEL_ERROR.getMsg());
    }

    /**
     * 删除成功
     *
     * @param msg 自定义
     * @return json json object
     */
    public static JSONObject delError(String msg) {
        return msg(MsgEnum.DEL_ERROR.getCode(), msg);
    }

    /**
     * 添加成功
     *
     * @return json json object
     */
    public static JSONObject addSuccess() {
        return addSuccess(MsgEnum.ADD_SUCCESS.getMsg());
    }

    /**
     * 添加成功
     *
     * @param msg 自定义
     * @return json json object
     */
    public static JSONObject addSuccess(String msg) {
        return msg(MsgEnum.ADD_SUCCESS.getCode(), msg);
    }

    /**
     * Add error json object.
     *
     * @return the json object
     */
    public static JSONObject addError() {
        return addError(MsgEnum.ADD_ERROR.getMsg());
    }

    private static JSONObject addError(String msg) {
        return msg(MsgEnum.ADD_ERROR.getCode(), msg);
    }

    /**
     * 登陆成功
     *
     * @return json json object
     */
    public static JSONObject loginSuccess() {
        return msg(MsgEnum.LOGIN_SUCCESS.getCode(), MsgEnum.LOGIN_SUCCESS.getMsg());
    }

    /**
     * Login success json object.
     *
     * @param data the data
     * @return the json object
     */
    public static JSONObject loginSuccess(String data) {
        return msg(MsgEnum.LOGIN_SUCCESS.getCode(), data);
    }

    /**
     * 登陆失败
     *
     * @return json json object
     */
    public static JSONObject loginError() {
        return msg(MsgEnum.LOGIN_ERROR.getCode(), MsgEnum.LOGIN_ERROR.getMsg());
    }


    /**
     * Illegal argument error json object.
     *
     * @return the json object
     */
    public static JSONObject IllegalArgumentError() {
        return msg(MsgEnum.ILLEGALARGUMENT.getCode(), MsgEnum.ILLEGALARGUMENT.getMsg());
    }

    /**
     * @param code   状态值
     * @param tmpMsg 模板提示
     * @return json
     */
    private static JSONObject msg(int code, String tmpMsg) {
        return msg(code, tmpMsg, null);
    }

    /**
     * @param code   状态值
     * @param tmpMsg 模板提示
     * @param msg    自定义提示 允许为空
     * @return json
     */
    private static JSONObject msg(int code, String tmpMsg, String msg) {
        msg = StringUtils.isBlank(msg) ? tmpMsg : msg;
        JSONObject jo = new JSONObject();
        jo.put("data", new Msg(code, msg));
        return jo;
    }

    /**
     * Data json object.
     *
     * @param data 自定义提示 允许为空
     * @return json json object
     */
    public static JSONObject data(Object data) {
        JSONObject jo = new JSONObject();
        jo.put("data", new Msg(MsgEnum.SUCCESS.getCode(), data));
        return jo;
    }

    /**
     * Error json object.
     *
     * @return the json object
     */
    public static JSONObject error() {
        return msg(MsgEnum.ERROR.getCode(), MsgEnum.ERROR.getMsg(), null);
    }

    /**
     * Error json object.
     *
     * @param msg the msg
     * @return the json object
     */
    public static JSONObject error(String msg) {
        return msg(MsgEnum.ERROR.getCode(), msg);
    }

    /**
     * Success json object.
     *
     * @param msg the msg
     * @return the json object
     */
    public static JSONObject success(String msg) {
        return msg(MsgEnum.SUCCESS.getCode(), msg);
    }

    /**
     * Success json object.
     *
     * @param data the data
     * @return the json object
     */
    public static JSONObject success(Object data) {
        return data(data);
    }

    /**
     * Un authc error json object.
     *
     * @return the json object
     */
    public static JSONObject UnAuthcError() {
        return msg(MsgEnum.UN_AUTH_ERROR.getCode(), MsgEnum.UN_AUTH_ERROR.getMsg());
    }
}
