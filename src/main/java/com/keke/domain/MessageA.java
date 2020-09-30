package com.keke.domain;

import java.io.Serializable;

public class MessageA implements Serializable {

    private String sender;
    private String reciever;
    private String content;
    private String send_time;
    private Integer rn;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    @Override
    public String toString() {
        return "MessageA{" +
                "sender='" + sender + '\'' +
                ", reciever='" + reciever + '\'' +
                ", content='" + content + '\'' +
                ", send_time='" + send_time + '\'' +
                ", rn=" + rn +
                '}';
    }
}
