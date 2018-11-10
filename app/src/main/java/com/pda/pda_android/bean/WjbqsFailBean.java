package com.pda.pda_android.bean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/11/10 14:17
 * 功能：无菌包签收失败的bean
 *  {
 * 	"response": "fail",
 * 	"error": "",
 * 	"data": {
 * 		"type": 1
 *        },
 * 	"message": "",
 * 	"next": ""
 * }
 */
public class WjbqsFailBean implements Serializable {

    private String response;
    private String error;
    private String message;
    private String next;
    private WjbqsFailBeanDataBean data;

    @Override
    public String toString() {
        return "WjbqsFailBean{" +
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

    public WjbqsFailBeanDataBean getData() {
        return data;
    }

    public void setData(WjbqsFailBeanDataBean data) {
        this.data = data;
    }

    public class WjbqsFailBeanDataBean implements Serializable{
        private String type;

        @Override
        public String toString() {
            return "WjbqsFailBeanDataBean{" +
                    "type='" + type + '\'' +
                    '}';
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
