package com.ssm.runoob.model;

import java.io.Serializable;

/**
 * Created by Phil on 2016/4/21.
 */
public class UrlFilter implements Serializable {
    private static final long serialVersionUID = -1258823207777877186L;
    private String url;
    private String authc;

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets authc.
     *
     * @return the authc
     */
    public String getAuthc() {
        return authc;
    }

    /**
     * Sets authc.
     *
     * @param authc the authc
     */
    public void setAuthc(String authc) {
        this.authc = authc;
    }
}
