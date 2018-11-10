package com.pda.pda_android.bean;

import java.util.List;

public class JyBean {


    /**
     * response : ok
     * error :
     * data : [{"date":"2018-11-07","list":[{"name":"痰培养＋药敏＋细菌涂片","result_date":"2018-11-07 08:03:30","sqxh":"5815367"}]},{"date":"2018-11-05","list":[{"name":"痰培养＋药敏＋细菌涂片","result_date":"2018-11-05 17:11:46","sqxh":"5804624"},{"name":"血培养（厌氧）+药敏","result_date":"2018-11-05 10:09:21","sqxh":"5802050"},{"name":"血培养（需氧）+药敏","result_date":"2018-11-05 10:09:21","sqxh":"5802051"}]}]
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
         * date : 2018-11-07
         * list : [{"name":"痰培养＋药敏＋细菌涂片","result_date":"2018-11-07 08:03:30","sqxh":"5815367"}]
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
             * name : 痰培养＋药敏＋细菌涂片
             * result_date : 2018-11-07 08:03:30
             * sqxh : 5815367
             */

            private String name;
            private String result_date;
            private String sqxh;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getResult_date() {
                return result_date;
            }

            public void setResult_date(String result_date) {
                this.result_date = result_date;
            }

            public String getSqxh() {
                return sqxh;
            }

            public void setSqxh(String sqxh) {
                this.sqxh = sqxh;
            }
        }
    }
}
