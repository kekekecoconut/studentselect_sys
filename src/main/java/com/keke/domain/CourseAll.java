package com.keke.domain;

import java.io.Serializable;

public class CourseAll implements Serializable {

    //课程编号
    private String cno;
    //课程名
    private String cname;
    //课程类型
    private String ctype;
    //课程所属学院
    private String ccoll;
    //课程简介
    private String cintro;
    //课程先修课名称
    private String cpno;

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

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCcoll() {
        return ccoll;
    }

    public void setCcoll(String ccoll) {
        this.ccoll = ccoll;
    }

    public String getCintro() {
        return cintro;
    }

    public void setCintro(String cintro) {
        this.cintro = cintro;
    }

    public String getCpno() {
        return cpno;
    }

    public void setCpno(String cpno) {
        this.cpno = cpno;
    }



    @Override
    public String toString() {
        return "CourseAll{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", ctype='" + ctype + '\'' +
                ", ccoll='" + ccoll + '\'' +
                ", cintro='" + cintro + '\'' +
                ", cpno='" + cpno + '\'' +
                '}';
    }
}
