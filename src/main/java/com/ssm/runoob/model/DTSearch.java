package com.ssm.runoob.model;

/**
 * Created by Phil on 2016/3/4.
 */
public class DTSearch {
    private String value;
    private String regex;

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value.equals("") ? null : value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets regex.
     *
     * @return the regex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * Sets regex.
     *
     * @param regex the regex
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }
}
