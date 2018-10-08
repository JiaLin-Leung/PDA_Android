package com.pda.pda_android.base.network.bean;

import java.io.Serializable;

/**
 * Created by 梁佳霖 on 2018/7/19 15:26
 * {
 * 	"response": "fail",
 * 	"data": {},
 * 	"error": "500",
 * 	"next": "",
 * 	"message": "抱歉，服务器开小差了，请联系客服12556185"
 * }
 */
public class ErrorBean500 implements Serializable {

    private String response;
    private String error;
    private String next;
    private String message;
    private String data;

    @Override
    public String toString() {
        return "ErrorBean500{" +
                "response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", next='" + next + '\'' +
                ", message='" + message + '\'' +
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

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
