package com.keke.domain;

import java.io.Serializable;

public class ResultDetail implements Serializable {

    private String sno;
    private String cno;
    private String cname;
    private String tno;
    private String tname;
    private String ctime;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "ResultDetail{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
