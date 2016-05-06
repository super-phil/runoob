package com.ssm.runoob.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Phil on 2016/3/4.
 */
public class DTRequest implements Serializable {

    private static final long serialVersionUID = 1056725809206873758L;
    private int draw;
    private int start;//开始
    private int length;//长度
    private DTSearch search;//查询参数
    private List<DTOrder> order;
    private List<DTColumn> columns;

    /**
     * 查询参数
     * Gets search.
     *
     * @return the search
     */
    public String getSearch() {
        return search.getValue();
    }

    /**
     * 排序
     *
     * @return the string
     */
    public String getOrder(){
        DTOrder dtOrder = order.get(0);//默认列排序
        return columns.get(dtOrder.getColumn()).getData() + " " + dtOrder.getDir();
    }

    /**
     * Gets draw.
     *
     * @return the draw
     */
    public int getDraw() {
        return draw;
    }

    /**
     * Sets draw.
     *
     * @param draw the draw
     */
    public void setDraw(int draw) {
        this.draw = draw;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets length.
     *
     * @param length the length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Sets search.
     *
     * @param search the search
     */
    public void setSearch(DTSearch search) {
        this.search = search;
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(List<DTOrder> order) {
        this.order = order;
    }

    /**
     * Sets columns.
     *
     * @param columns the columns
     */
    public void setColumns(List<DTColumn> columns) {
        this.columns = columns;
    }


}
