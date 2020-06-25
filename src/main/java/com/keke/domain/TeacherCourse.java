package com.keke.domain;

import java.io.Serializable;

public class TeacherCourse implements Serializable {
    private String cno;
    private String cname;
    private String cintro;
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
        return "TeacherCourse{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cintro='" + cintro + '\'' +
                ", cpno='" + cpno + '\'' +
                '}';
    }
}
