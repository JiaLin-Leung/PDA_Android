package com.pda.pda_android.db.Entry;

import java.io.Serializable;
import java.util.List;

/**
 * 梁佳霖创建于：2018/11/1 11:11
 * 功能：
 */
public class SsxxListBean implements Serializable {
    private String error;
    private String message;
    private String next;
    private List<SsxxBean> data;

    @Override
    public String toString() {
        return "SsxxListBean{" +
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

    public List<SsxxBean> getData() {
        return data;
    }

    public void setData(List<SsxxBean> data) {
        this.data = data;
    }
}
