package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Phil on 2016/3/4.
 */
@Data
@NoArgsConstructor
public class DTColumn {
    private String data;
    private String name;
    private boolean searchable;
    private boolean orderable;
    private DTSearch search;
}
