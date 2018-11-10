package com.pda.pda_android.bean;

import java.util.List;

public class SsxxBean {

    /**
     * response : ok
     * error :
     * data : [{"date":"2018-11-09","list":[{"id":2023,"oper_name":"剖腹探查加肠粘连松解术","endoper_time":"2018-11-09 13:40:00","surgeon_name":"韩广森"},{"id":1562,"oper_name":"腹腔热灌注治疗","endoper_time":"2018-11-09 15:25:00","surgeon_name":"韩广森"}]}]
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

    public static class DataBean {
        /**
         * date : 2018-11-09
         * list : [{"id":2023,"oper_name":"剖腹探查加肠粘连松解术","endoper_time":"2018-11-09 13:40:00","surgeon_name":"韩广森"},{"id":1562,"oper_name":"腹腔热灌注治疗","endoper_time":"2018-11-09 15:25:00","surgeon_name":"韩广森"}]
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

        public static class ListBean {
            /**
             * id : 2023
             * oper_name : 剖腹探查加肠粘连松解术
             * endoper_time : 2018-11-09 13:40:00
             * surgeon_name : 韩广森
             */

            private int id;
            private String oper_name;
            private String endoper_time;
            private String surgeon_name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOper_name() {
                return oper_name;
            }

            public void setOper_name(String oper_name) {
                this.oper_name = oper_name;
            }

            public String getEndoper_time() {
                return endoper_time;
            }

            public void setEndoper_time(String endoper_time) {
                this.endoper_time = endoper_time;
            }

            public String getSurgeon_name() {
                return surgeon_name;
            }

            public void setSurgeon_name(String surgeon_name) {
                this.surgeon_name = surgeon_name;
            }
        }
    }
}
