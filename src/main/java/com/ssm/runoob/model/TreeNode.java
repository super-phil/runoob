package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Phil on 2016/4/18.
 */
@Data
@NoArgsConstructor
public class TreeNode implements Serializable {

    private static final long serialVersionUID = 7643330044504647189L;
    private long id;
    private String name;
    private boolean checked;
    private List<TreeNode> children;
}
