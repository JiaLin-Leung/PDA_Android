package com.pda.pda_android.bean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/11/10 14:17
 * 功能：无菌包签收失败的bean
 *  {
 * 	"response": "ok",
 * 	"error": "",
 * 	"data": {
 * 		"code": "00009",
 * 		"name": "假数据4",
 * 		"send_date": "2018-11-10 14:50:03"
 *        },
 * 	"message": "",
 * 	"next": ""
 * }
 */
public class WjbqsOkBean implements Serializable {

    private String response;
    private String error;
    private String message;
    private String next;
    private WjbqsOkBeanDataBean data;

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

    public WjbqsOkBeanDataBean getData() {
        return data;
    }

    public void setData(WjbqsOkBeanDataBean data) {
        this.data = data;
    }

    public class WjbqsOkBeanDataBean implements Serializable{

        /**
         *  * 		"code": "00009",
         *  * 		"name": "假数据4",
         *  * 		"send_date": "2018-11-10 14:50:03"
         */
        private String code;
        private String name;
        private String send_date;

        @Override
        public String toString() {
            return "WjbqsOkBeanDataBean{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", send_date='" + send_date + '\'' +
                    '}';
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSend_date() {
            return send_date;
        }

        public void setSend_date(String send_date) {
            this.send_date = send_date;
        }
    }
}
