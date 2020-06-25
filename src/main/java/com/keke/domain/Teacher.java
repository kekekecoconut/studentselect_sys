package com.keke.domain;

import java.io.Serializable;

public class Teacher implements Serializable {

    private String tno;

    private String tname;

    private String tpassword;

    private String tsex;
    //所属学院
    private String tcoll;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTcoll() {
        return tcoll;
    }

    public void setTcoll(String tcoll) {
        this.tcoll = tcoll;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tpassword='" + tpassword + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tcoll='" + tcoll + '\'' +
                '}';
    }
}
