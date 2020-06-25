package com.keke.domain;

import java.io.Serializable;

/***
 * <resultMap type="StuSelectResult" id="resultListStuSelectResult">
 *         <result column="cno" property="cno' />
 *         <result column="cname" property="cname" />
 *         <result column="tname" property="ctname" />
 *         <result column="ctype" property="ctype" />
 *         <result column="time" property="time" />
 *         <result column="place" property="place" />
 *         <result column="credits" property="credits" />
 *         <result column="week" property="week" />
 *         <result column="cclass" property="cclass" />
 *         <result column="cpno" property="cpno" />
 *
 *     </resultMap>
 *     根据课程大类筛选课程
 */
public class Course implements Serializable {

    private String cno;
    private String cname;
    private String tno;
    private String tname;
    private String ctype;
    private String ctime;
    private String place;
    private Integer credits;
    private String week;
    private String cclass;//合班标志
    private String cpno;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
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

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getCclass() {
        return cclass;
    }

    public void setCclass(String cclass) {
        this.cclass = cclass;
    }

    public String getCpno() {
        return cpno;
    }

    public void setCpno(String cpno) {
        this.cpno = cpno;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", ctype='" + ctype + '\'' +
                ", ctime='" + ctime + '\'' +
                ", place='" + place + '\'' +
                ", credits=" + credits +
                ", week='" + week + '\'' +
                ", cclass='" + cclass + '\'' +
                ", cpno='" + cpno + '\'' +
                '}';
    }
}
