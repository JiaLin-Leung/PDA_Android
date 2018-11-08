package com.pda.pda_android.bean;

import java.io.Serializable;
import java.util.List;

public class WjbEndBean implements Serializable{
    /**
     * response : ok
     * error :
     * data : [{"date":"2018-11-08","list":[{"code":"00006","name":"假数据1","js_date":"2018-11-08 13:30:40","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00001","name":"测试测试","js_date":"2018-11-08 13:30:48","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00002","name":"无菌包1","js_date":"2018-11-08 13:32:31","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00003","name":"无菌包2","js_date":"2018-11-08 13:32:44","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00004","name":"无菌包2","js_date":"2018-11-08 13:35:54","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00007","name":"假数据2","js_date":"2018-11-08 13:43:40","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"000017","name":"假数据12","js_date":"2018-11-08 13:43:46","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"000016","name":"假数据11","js_date":"2018-11-08 13:43:51","js_user_name":null,"datastate":"2","type":"手动签收"}]}]
     * message :
     * next :
     */

    private String response;
    private String error;
    private String message;
    private String next;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * date : 2018-11-08
         * list : [{"code":"00006","name":"假数据1","js_date":"2018-11-08 13:30:40","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00001","name":"测试测试","js_date":"2018-11-08 13:30:48","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00002","name":"无菌包1","js_date":"2018-11-08 13:32:31","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00003","name":"无菌包2","js_date":"2018-11-08 13:32:44","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00004","name":"无菌包2","js_date":"2018-11-08 13:35:54","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"00007","name":"假数据2","js_date":"2018-11-08 13:43:40","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"000017","name":"假数据12","js_date":"2018-11-08 13:43:46","js_user_name":null,"datastate":"2","type":"手动签收"},{"code":"000016","name":"假数据11","js_date":"2018-11-08 13:43:51","js_user_name":null,"datastate":"2","type":"手动签收"}]
         */

        private String date;
        private List<ListBean> list;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * code : 00006
             * name : 假数据1
             * js_date : 2018-11-08 13:30:40
             * js_user_name : null
             * datastate : 2
             * type : 手动签收
             */

            private String code;
            private String name;
            private String js_date;
            private String js_user_name;
            private String datastate;
            private String type;

            public String getJs_user_name() {
                return js_user_name;
            }

            public void setJs_user_name(String js_user_name) {
                this.js_user_name = js_user_name;
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

            public String getJs_date() {
                return js_date;
            }

            public void setJs_date(String js_date) {
                this.js_date = js_date;
            }





            public String getDatastate() {
                return datastate;
            }

            public void setDatastate(String datastate) {
                this.datastate = datastate;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
