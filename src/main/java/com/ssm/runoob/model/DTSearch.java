package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Phil on 2016/3/4.
 */
@Data
@NoArgsConstructor
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
}
