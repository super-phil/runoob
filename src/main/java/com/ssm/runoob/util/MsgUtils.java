package com.ssm.runoob.util;

import com.alibaba.fastjson.JSONObject;
import com.ssm.runoob.enums.MsgEnum;
import com.ssm.runoob.model.Msg;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Phil on 2015/12/19.
 */
public class MsgUtils {
    public static JSONObject updateSuccess() {return delSuccess(MsgEnum.UPDATE_SUCCESS.getMsg());}
    public static JSONObject updateSuccess(String msg)  {
        return msg(MsgEnum.UPDATE_SUCCESS.getCode(), msg);}
    public static JSONObject updateError(){return delSuccess(MsgEnum.UPDATE_ERROR.getMsg());}
    public static JSONObject updateError(String msg) {
        return msg(MsgEnum.UPDATE_ERROR.getCode(), msg);}
    /**
     * 删除成功
     *
     * @return json
     */
    public static JSONObject delSuccess() {
        return delSuccess(MsgEnum.DEL_SUCCESS.getMsg());
    }

    /**
     * 删除成功
     *
     * @param msg 自定义
     * @return json
     */
    public static JSONObject delSuccess(String msg) {
        return msg(MsgEnum.DEL_SUCCESS.getCode(), msg);
    }

    /**
     * 删除成功
     *
     * @return json
     */
    public static JSONObject delError() {
        return delError(MsgEnum.DEL_ERROR.getMsg());
    }

    /**
     * 删除成功
     *
     * @param msg 自定义
     * @return json
     */
    public static JSONObject delError(String msg) {
        return msg(MsgEnum.DEL_ERROR.getCode(), msg);
    }

    /**
     * 添加成功
     *
     * @return json
     */
    public static JSONObject addSuccess() {
        return addSuccess(MsgEnum.ADD_SUCCESS.getMsg());
    }

    /**
     * 添加成功
     *
     * @param msg 自定义
     * @return json
     */
    public static JSONObject addSuccess(String msg) {
        return msg(MsgEnum.ADD_SUCCESS.getCode(), msg);
    }

    public static JSONObject addError() {
        return addError(MsgEnum.ADD_ERROR.getMsg());
    }

    private static JSONObject addError(String msg) {
        return msg(MsgEnum.ADD_ERROR.getCode(), msg);
    }

    /**
     * 登陆成功
     *
     * @return json
     */
    public static JSONObject loginSuccess() {
        return msg(MsgEnum.LOGIN_SUCCESS.getCode(), MsgEnum.LOGIN_SUCCESS.getMsg());
    }

    public static JSONObject loginSuccess(String data) {
        return msg(MsgEnum.LOGIN_SUCCESS.getCode(), data);
    }

    /**
     * 登陆失败
     *
     * @return json
     */
    public static JSONObject loginError() {
        return msg(MsgEnum.LOGIN_ERROR.getCode(), MsgEnum.LOGIN_ERROR.getMsg());
    }

    /**
     * @param code   状态值
     * @param tmpMsg 模板提示
     * @return json
     */
    public static JSONObject msg(int code, String tmpMsg) {
        return msg(code, tmpMsg, null);
    }

    /**
     * @param code   状态值
     * @param tmpMsg 模板提示
     * @param msg    自定义提示 允许为空
     * @return json
     */
    public static JSONObject msg(int code, String tmpMsg, String msg) {
        msg = StringUtils.isBlank(msg) ? tmpMsg : msg;
        JSONObject jo = new JSONObject();
        jo.put("data",new Msg(code, msg));
        return jo;
    }
    public static JSONObject error() {
        return msg(0, "服务器异常", null);
    }

}
