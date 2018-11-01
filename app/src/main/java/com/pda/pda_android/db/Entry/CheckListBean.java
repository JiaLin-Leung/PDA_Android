package com.pda.pda_android.db.Entry;

import java.io.Serializable;
import java.util.List;

/**
 * 梁佳霖创建于：2018/11/1 11:11
 * 功能：
 */
public class CheckListBean implements Serializable {
    private String error;
    private String message;
    private String next;
    private List<CheckBean> data;

    @Override
    public String toString() {
        return "CheckListBean{" +
                "error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", next='" + next + '\'' +
                ", data=" + data +
                '}';
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

    public List<CheckBean> getData() {
        return data;
    }

    public void setData(List<CheckBean> data) {
        this.data = data;
    }
}
