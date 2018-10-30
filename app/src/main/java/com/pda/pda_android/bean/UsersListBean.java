package com.pda.pda_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/30 11:31
 * 功能：
 */
public class UsersListBean implements Serializable {

    private String response;
    private String error;
    private String message;
    private String next;
    private List<UserBean> data;

    @Override
    public String toString() {
        return "UsersListBean{" +
                "response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", data=" + data +
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

    public List<UserBean> getData() {
        return data;
    }

    public void setData(List<UserBean> data) {
        this.data = data;
    }
}
