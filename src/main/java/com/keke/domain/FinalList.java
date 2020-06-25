package com.keke.domain;

import java.io.Serializable;

public class FinalList implements Serializable {
    private String sno;
    private String sname;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "FinalList{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
