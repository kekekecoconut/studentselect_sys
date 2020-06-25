package com.keke.domain;

import java.io.Serializable;

public class Grade implements Serializable {

    private String sno;
    private String cno;
    private Integer grade;
    private String tno;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", grade=" + grade +
                ", tno='" + tno + '\'' +
                '}';
    }
}
