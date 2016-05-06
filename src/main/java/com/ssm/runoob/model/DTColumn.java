package com.ssm.runoob.model;

/**
 * Created by Phil on 2016/3/4.
 */
public class DTColumn {
    private String data;
    private String name;
    private boolean searchable;
    private boolean orderable;
    private DTSearch search;

    /**
     * Gets data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(String data) {
        this.data = data;
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
     * Is searchable boolean.
     *
     * @return the boolean
     */
    public boolean isSearchable() {
        return searchable;
    }

    /**
     * Sets searchable.
     *
     * @param searchable the searchable
     */
    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    /**
     * Is orderable boolean.
     *
     * @return the boolean
     */
    public boolean isOrderable() {
        return orderable;
    }

    /**
     * Sets orderable.
     *
     * @param orderable the orderable
     */
    public void setOrderable(boolean orderable) {
        this.orderable = orderable;
    }

    /**
     * Gets search.
     *
     * @return the search
     */
    public DTSearch getSearch() {
        return search;
    }

    /**
     * Sets search.
     *
     * @param search the search
     */
    public void setSearch(DTSearch search) {
        this.search = search;
    }
}
