package com.pride.domain.typecode;

public class TypeCode {
    private String status;
    private String msg;
    private String date;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TypeCode() {

    }

    public TypeCode(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public TypeCode(String status, String msg, String date) {
        this.status = status;
        this.msg = msg;
        this.date = date;
    }
}
