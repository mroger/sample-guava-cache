package br.org.roger.spring.domain;

import java.io.Serializable;

public class EmailMessage implements Serializable {
    private String subject;
    private String text;
    private Object fromAddress;
    private Object fromName;
    private String toAddress;
    private String toName;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFromAddress(Object fromAddress) {
        this.fromAddress = fromAddress;
    }

    public void setFromName(Object fromName) {
        this.fromName = fromName;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
