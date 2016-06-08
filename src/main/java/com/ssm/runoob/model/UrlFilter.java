package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Phil on 2016/4/21.
 */
@Data
@NoArgsConstructor
public class UrlFilter implements Serializable {
    private static final long serialVersionUID = -1258823207777877186L;
    private String url;
    private String authc;
}
