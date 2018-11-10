package com.pda.pda_android.bean;

import java.util.List;

public class JyDetailBean {


    /**
     * response : ok
     * error :
     * data : {"sqdate":"2018-10-31 09:37:18","jcdate":"2018-11-05 10:58:55","bgdate":"2018-11-07 08:03:30","detail":[{"item_name":"弗劳地枸橼酸杆菌","jyjg":null,"jg1":null,"jg2":null,"jg3":null,"flag":null,"unit":null,"range":null}]}
     * message :
     * next :
     */

    private String response;
    private String error;
    private DataBean data;
    private String message;
    private String next;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * sqdate : 2018-10-31 09:37:18
         * jcdate : 2018-11-05 10:58:55
         * bgdate : 2018-11-07 08:03:30
         * detail : [{"item_name":"弗劳地枸橼酸杆菌","jyjg":null,"jg1":null,"jg2":null,"jg3":null,"flag":null,"unit":null,"range":null}]
         */

        private String sqdate;
        private String jcdate;
        private String bgdate;
        private List<DetailBean> detail;

        public String getSqdate() {
            return sqdate;
        }

        public void setSqdate(String sqdate) {
            this.sqdate = sqdate;
        }

        public String getJcdate() {
            return jcdate;
        }

        public void setJcdate(String jcdate) {
            this.jcdate = jcdate;
        }

        public String getBgdate() {
            return bgdate;
        }

        public void setBgdate(String bgdate) {
            this.bgdate = bgdate;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * item_name : 弗劳地枸橼酸杆菌
             * jyjg : null
             * jg1 : null
             * jg2 : null
             * jg3 : null
             * flag : null
             * unit : null
             * range : null
             */

            private String item_name;
            private Object jyjg;
            private Object jg1;
            private Object jg2;
            private Object jg3;
            private Object flag;
            private Object unit;
            private Object range;

            public String getItem_name() {
                return item_name;
            }

            public void setItem_name(String item_name) {
                this.item_name = item_name;
            }

            public Object getJyjg() {
                return jyjg;
            }

            public void setJyjg(Object jyjg) {
                this.jyjg = jyjg;
            }

            public Object getJg1() {
                return jg1;
            }

            public void setJg1(Object jg1) {
                this.jg1 = jg1;
            }

            public Object getJg2() {
                return jg2;
            }

            public void setJg2(Object jg2) {
                this.jg2 = jg2;
            }

            public Object getJg3() {
                return jg3;
            }

            public void setJg3(Object jg3) {
                this.jg3 = jg3;
            }

            public Object getFlag() {
                return flag;
            }

            public void setFlag(Object flag) {
                this.flag = flag;
            }

            public Object getUnit() {
                return unit;
            }

            public void setUnit(Object unit) {
                this.unit = unit;
            }

            public Object getRange() {
                return range;
            }

            public void setRange(Object range) {
                this.range = range;
            }
        }
    }
}
