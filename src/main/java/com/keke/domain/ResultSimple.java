package com.keke.domain;


import java.io.Serializable;

public class ResultSimple implements Serializable {

    private String cname;
    private Integer count;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResultSimple{" +
                "cname='" + cname + '\'' +
                ", count=" + count +
                '}';
    }
}
