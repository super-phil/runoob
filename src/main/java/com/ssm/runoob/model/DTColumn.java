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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    public boolean isOrderable() {
        return orderable;
    }

    public void setOrderable(boolean orderable) {
        this.orderable = orderable;
    }

    public DTSearch getSearch() {
        return search;
    }

    public void setSearch(DTSearch search) {
        this.search = search;
    }
}
