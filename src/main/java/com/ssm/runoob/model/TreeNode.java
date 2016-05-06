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

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Is checked boolean.
     *
     * @return the boolean
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Sets checked.
     *
     * @param checked the checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * Gets children.
     *
     * @return the children
     */
    public List<TreeNode> getChildren() {
        return children;
    }

    /**
     * Sets children.
     *
     * @param children the children
     */
    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
