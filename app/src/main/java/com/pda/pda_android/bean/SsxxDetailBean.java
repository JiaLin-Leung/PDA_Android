package com.pda.pda_android.bean;

public class SsxxDetailBean {

    /**
     * response : ok
     * error :
     * data : {"xhhs_name":"何  瑾","operdiag":"结肠癌术后","operdiag_after":"结肠癌术后","hisappform":"503826","mzfs":"全身麻醉","mzys_name":"韩  博","operscale":"3","operstate":null,"djtime":null,"operxh":null,"ward_code":"2012","operid":"2","oper_name":"剖腹探查加肠粘连松解术","oper_code":"S991","yytime":"2018-11-09 08:10:00","inoper_time":"2018-11-09 12:00:00","endoper_time":"2018-11-09 13:40:00","outoper_time":null,"inpacu_time":"2018-11-09 13:50:00","outpacu_time":null,"oper_roomno":"17","sequence_no":"0","surgeon_name":"韩广森","surgeon_code":"000304"}
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
         * xhhs_name : 何  瑾
         * operdiag : 结肠癌术后
         * operdiag_after : 结肠癌术后
         * hisappform : 503826
         * mzfs : 全身麻醉
         * mzys_name : 韩  博
         * operscale : 3
         * operstate : null
         * djtime : null
         * operxh : null
         * ward_code : 2012
         * operid : 2
         * oper_name : 剖腹探查加肠粘连松解术
         * oper_code : S991
         * yytime : 2018-11-09 08:10:00
         * inoper_time : 2018-11-09 12:00:00
         * endoper_time : 2018-11-09 13:40:00
         * outoper_time : null
         * inpacu_time : 2018-11-09 13:50:00
         * outpacu_time : null
         * oper_roomno : 17
         * sequence_no : 0
         * surgeon_name : 韩广森
         * surgeon_code : 000304
         */

        private String xhhs_name;
        private String operdiag;
        private String operdiag_after;
        private String hisappform;
        private String mzfs;
        private String mzys_name;
        private String operscale;
        private String operstate;
        private String djtime;
        private String operxh;
        private String ward_code;
        private String operid;
        private String oper_name;
        private String oper_code;
        private String yytime;
        private String inoper_time;
        private String endoper_time;
        private String outoper_time;
        private String inpacu_time;
        private String outpacu_time;
        private String oper_roomno;
        private String sequence_no;
        private String surgeon_name;
        private String surgeon_code;

        public String getDjtime() {
            return djtime;
        }

        public String getXhhs_name() {
            return xhhs_name;
        }

        public void setXhhs_name(String xhhs_name) {
            this.xhhs_name = xhhs_name;
        }

        public String getOperdiag() {
            return operdiag;
        }

        public void setOperdiag(String operdiag) {
            this.operdiag = operdiag;
        }

        public String getOperdiag_after() {
            return operdiag_after;
        }

        public void setOperdiag_after(String operdiag_after) {
            this.operdiag_after = operdiag_after;
        }

        public String getHisappform() {
            return hisappform;
        }

        public void setHisappform(String hisappform) {
            this.hisappform = hisappform;
        }

        public String getMzfs() {
            return mzfs;
        }

        public void setMzfs(String mzfs) {
            this.mzfs = mzfs;
        }

        public String getMzys_name() {
            return mzys_name;
        }

        public void setMzys_name(String mzys_name) {
            this.mzys_name = mzys_name;
        }

        public String getOperscale() {
            return operscale;
        }

        public void setOperscale(String operscale) {
            this.operscale = operscale;
        }

        public void setWard_code(String ward_code) {
            this.ward_code = ward_code;
        }

        public String getOperid() {
            return operid;
        }

        public void setOperid(String operid) {
            this.operid = operid;
        }

        public String getOper_name() {
            return oper_name;
        }

        public void setOper_name(String oper_name) {
            this.oper_name = oper_name;
        }

        public String getOper_code() {
            return oper_code;
        }

        public void setOper_code(String oper_code) {
            this.oper_code = oper_code;
        }

        public String getYytime() {
            return yytime;
        }

        public void setYytime(String yytime) {
            this.yytime = yytime;
        }

        public String getInoper_time() {
            return inoper_time;
        }

        public void setInoper_time(String inoper_time) {
            this.inoper_time = inoper_time;
        }

        public String getEndoper_time() {
            return endoper_time;
        }

        public void setEndoper_time(String endoper_time) {
            this.endoper_time = endoper_time;
        }



        public String getInpacu_time() {
            return inpacu_time;
        }

        public void setInpacu_time(String inpacu_time) {
            this.inpacu_time = inpacu_time;
        }

        public String getOperstate() {
            return operstate;
        }

        public void setOperstate(String operstate) {
            this.operstate = operstate;
        }

        public void setDjtime(String djtime) {
            this.djtime = djtime;
        }

        public String getOperxh() {
            return operxh;
        }

        public void setOperxh(String operxh) {
            this.operxh = operxh;
        }

        public String getWard_code() {
            return ward_code;
        }

        public String getOutoper_time() {
            return outoper_time;
        }

        public void setOutoper_time(String outoper_time) {
            this.outoper_time = outoper_time;
        }

        public String getOutpacu_time() {
            return outpacu_time;
        }

        public void setOutpacu_time(String outpacu_time) {
            this.outpacu_time = outpacu_time;
        }

        public String getOper_roomno() {
            return oper_roomno;
        }

        public void setOper_roomno(String oper_roomno) {
            this.oper_roomno = oper_roomno;
        }

        public String getSequence_no() {
            return sequence_no;
        }

        public void setSequence_no(String sequence_no) {
            this.sequence_no = sequence_no;
        }

        public String getSurgeon_name() {
            return surgeon_name;
        }

        public void setSurgeon_name(String surgeon_name) {
            this.surgeon_name = surgeon_name;
        }

        public String getSurgeon_code() {
            return surgeon_code;
        }

        public void setSurgeon_code(String surgeon_code) {
            this.surgeon_code = surgeon_code;
        }
    }
}
