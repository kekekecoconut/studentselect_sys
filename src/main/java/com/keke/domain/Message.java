package com.keke.domain;

import java.io.Serializable;

public class Message implements Serializable {
    private String sender;
    private String reciever;
    private String content;

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", reciever='" + reciever + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

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
}
