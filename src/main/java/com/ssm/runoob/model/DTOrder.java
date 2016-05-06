package com.ssm.runoob.model;

/**
 * Created by Phil on 2016/3/4.
 */
public class DTOrder {
    private int column;//排序的列索引 从0开始
    private String dir;//排序规则 asc?desc

    /**
     * Gets column.
     *
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Sets column.
     *
     * @param column the column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Gets dir.
     *
     * @return the dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * Sets dir.
     *
     * @param dir the dir
     */
    public void setDir(String dir) {
        this.dir = dir;
    }
}
