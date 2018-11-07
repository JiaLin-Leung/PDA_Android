package com.pda.pda_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 梁佳霖创建于：2018/11/7 17:06
 * 功能：
 */
public class WjbqsBean implements Serializable {

    private String response;
    private String error;
    private String message;
    private String next;
    private List<WjbqsBeanListBean> data;

    @Override
    public String toString() {
        return "WjbqsBean{" +
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

    public List<WjbqsBeanListBean> getData() {
        return data;
    }

    public void setData(List<WjbqsBeanListBean> data) {
        this.data = data;
    }

    public class WjbqsBeanListBean implements Serializable{

        private String date;
        private List<WjbqsBeanListBeanListBean> list;

        @Override
        public String toString() {
            return "WjbqsBeanListBean{" +
                    "date='" + date + '\'' +
                    ", list=" + list +
                    '}';
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<WjbqsBeanListBeanListBean> getList() {
            return list;
        }

        public void setList(List<WjbqsBeanListBeanListBean> list) {
            this.list = list;
        }

        public class WjbqsBeanListBeanListBean implements Serializable{

            private String code;
            private String name;
            private String send_date;

            @Override
            public String toString() {
                return "WjbqsBeanListBeanListBean{" +
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
}
