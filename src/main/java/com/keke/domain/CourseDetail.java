package com.keke.domain;

import java.io.Serializable;

public class CourseDetail implements Serializable {

    private String cno;
    private String tno;
    private String ctime;
    private Integer credits;
    private String place;
    private Integer maxnum;
    private String cclass;
    private String week;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(Integer maxnum) {
        this.maxnum = maxnum;
    }

    public String getCclass() {
        return cclass;
    }

    public void setCclass(String cclass) {
        this.cclass = cclass;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "CourseDetail{" +
                "cno='" + cno + '\'' +
                ", tno='" + tno + '\'' +
                ", ctime='" + ctime + '\'' +
                ", credits=" + credits +
                ", place='" + place + '\'' +
                ", maxnum=" + maxnum +
                ", cclass='" + cclass + '\'' +
                ", week='" + week + '\'' +
                '}';
    }
}
