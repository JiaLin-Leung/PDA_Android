package com.pda.pda_android.bean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/10/30 13:59
 * 功能：
 */
public class LoginBean implements Serializable {

    private String response;
    private String error;
    private String message;
    private String next;
    private LoginBeanData data;

    @Override
    public String toString() {
        return "LoginBean{" +
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

    public LoginBeanData getData() {
        return data;
    }

    public void setData(LoginBeanData data) {
        this.data = data;
    }

    public class LoginBeanData implements Serializable{

        private String nis_token;

        @Override
        public String toString() {
            return "LoginBeanData{" +
                    "nis_token='" + nis_token + '\'' +
                    '}';
        }

        public String getNis_token() {
            return nis_token;
        }

        public void setNis_token(String nis_token) {
            this.nis_token = nis_token;
        }
    }
}
