package com.ssm.runoob.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Phil on 2016/4/18.
 */
public class TreeNode implements Serializable {

    private static final long serialVersionUID = 7643330044504647189L;
    private long id;
    private String name;
    private boolean checked;
    private List<TreeNode> children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
