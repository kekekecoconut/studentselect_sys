package com.keke.domain;

import java.io.Serializable;

public class Highadmin implements Serializable {

    //管理员编号
    private String ano;

    //管理员密码
    private String apassword;

    private String adept;

    public String getAdept() {
        return adept;
    }

    public void setAdept(String adept) {
        this.adept = adept;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ano='" + ano + '\'' +
                ", apassword='" + apassword + '\'' +
                '}';
    }

}
