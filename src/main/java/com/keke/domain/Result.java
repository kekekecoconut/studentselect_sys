package com.keke.domain;

public class Result {
    //课程编号
    private String rcno;
    //学生编号
    private String rsno;

    private String tno;

    public String getRcno() {
        return rcno;
    }

    public void setRcno(String rcno) {
        this.rcno = rcno;
    }

    public String getRsno() {
        return rsno;
    }

    public void setRsno(String rsno) {
        this.rsno = rsno;
    }


    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    @Override
    public String toString() {
        return "Result{" +
                "rcno='" + rcno + '\'' +
                ", rsno='" + rsno + '\'' +
                ", tno='" + tno + '\'' +
                '}';
    }
}
