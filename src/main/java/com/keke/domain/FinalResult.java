package com.keke.domain;

import java.io.Serializable;

public class FinalResult implements Serializable {

    //课程编号
    private String rcno;
    //学生编号
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
}
