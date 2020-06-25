package com.keke.domain;

import java.io.Serializable;

public class StudentCourse implements Serializable {
    private String cno;
    private String cname;
    private String cintro;
    private String cpno;
    private String tname;
    private String tno;

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

    @Override
    public String toString() {
        return "StudentCourse{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", cintro='" + cintro + '\'' +
                ", cpno='" + cpno + '\'' +
                ", tname='" + tname + '\'' +
                ", tno='" + tno + '\'' +
                '}';
    }
}
