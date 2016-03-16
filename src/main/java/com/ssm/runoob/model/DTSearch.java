package com.ssm.runoob.model;

/**
 * Created by Phil on 2016/3/4.
 */
public class DTSearch {
    private String value;
    private String regex;

    public String getValue() {
        return value.equals("") ? null : value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
