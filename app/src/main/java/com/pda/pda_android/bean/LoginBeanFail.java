package com.pda.pda_android.bean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/10/30 14:03
 * 功能：
 */
public class LoginBeanFail implements Serializable {

    private String response;
    private String error;
    private String data;
    private String message;
    private String next;

    @Override
    public String toString() {
        return "LoginBeanFail{" +
                "response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                ", next='" + next + '\'' +
                '}';
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
