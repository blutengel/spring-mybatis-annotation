package com.example.domain;

/**
 * Created by Hugo on 3/26/2016.
 */
public class PageBean {
    private int offset;
    private int limit;

    public PageBean() {
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
