package com.ssm.runoob.model;

import java.io.Serializable;

/**
 * Created by Phil on 2016/4/21.
 */
public class UrlFilter implements Serializable {
    private static final long serialVersionUID = -1258823207777877186L;
    private String url;
    private String authc;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthc() {
        return authc;
    }

    public void setAuthc(String authc) {
        this.authc = authc;
    }
}
