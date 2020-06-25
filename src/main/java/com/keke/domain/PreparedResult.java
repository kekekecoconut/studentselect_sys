package com.keke.domain;

import java.io.Serializable;

//课程编码 教师编号唯一确定一门有老师上的课
public class PreparedResult implements Serializable {

    //课程编码
    private String rcno;
    //学生学号
    private String rsno;

    private Integer id;

    private String tno;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PreparedResult{" +
                "rcno='" + rcno + '\'' +
                ", rsno='" + rsno + '\'' +
                ", id=" + id +
                '}';
    }
}
