package com.keke.domain;

import java.io.Serializable;

public class GradeTeacher implements Serializable {

    /***
     * ca.cname,s.sname,s.sno,g.grade
     */
    private String cname;
    private String sname;
    private String sno;
    private Integer grade;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "GradeTeacher{" +
                "cname='" + cname + '\'' +
                ", sname='" + sname + '\'' +
                ", sno='" + sno + '\'' +
                ", grade=" + grade +
                '}';
    }
}
