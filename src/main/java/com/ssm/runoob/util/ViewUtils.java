package com.ssm.runoob.util;

/**
 * Created by Phil on 2016/4/20.
 */
public class ViewUtils {
    public ViewUtils() {
    }

    public boolean isNull(Object obj) {
        return null == obj;
    }

    public static boolean isNotNull(Object obj) {
        return null != obj;
    }
}
