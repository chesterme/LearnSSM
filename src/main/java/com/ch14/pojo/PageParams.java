package com.ch14.pojo;

/**
 * 封装分页参数
 */
public class PageParams {

    private int start;
    private int limit;

    public PageParams(){}

    public PageParams(int start, int limit){
        this.limit = limit;
        this.start = start;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String toString(){
        return "start: " + start + ", limit: " + limit;
    }
}
