package com.ssm.runoob.model;

/**
 * Created by Phil on 2016/3/4.
 */
public class DTOrder {
    private int column;//排序的列索引 从0开始
    private String dir;//排序规则 asc?desc

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
