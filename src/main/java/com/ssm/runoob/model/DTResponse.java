package com.ssm.runoob.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Phil on 2016/3/4.
 *
 * @param <T> the type parameter
 * @author Phil
 */
public class DTResponse<T> implements Serializable{

    private static final long serialVersionUID = -7031375338413546730L;
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data;

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
     * Gets records total.
     *
     * @return the records total
     */
    public long getRecordsTotal() {
        return recordsTotal;
    }

    /**
     * Sets records total.
     *
     * @param recordsTotal the records total
     */
    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    /**
     * Gets records filtered.
     *
     * @return the records filtered
     */
    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    /**
     * Sets records filtered.
     *
     * @param recordsFiltered the records filtered
     */
    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(List<T> data) {
        this.data = data;
    }
}
