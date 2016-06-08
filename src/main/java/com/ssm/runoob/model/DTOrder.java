package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Phil on 2016/3/4.
 */
@Data
@NoArgsConstructor
public class DTOrder {
    private int column;//排序的列索引 从0开始
    private String dir;//排序规则 asc?desc
}
