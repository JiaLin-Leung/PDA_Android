package com.pda.pda_android.bean;

import java.io.Serializable;
import java.util.List;

public class JcBean implements Serializable{

    /**
     * response : ok
     * error :
     * data : [{"date":"2018-11-09","list":[{"record_no":"0000506238","appform_no":null,"devicetype":"ECT","item_name":"[全身骨显像]","djdate":"2018-11-09 09:03:43","jcdate":"2018-11-09 11:08:40","bgzt":"1 ","zdyj":null,"bgjy":null,"bgdate":"2018-11-09 11:50:18","bgresult":"1、左后第5-7肋骨质代谢活跃（考虑：创伤）；\r\n    建议：1.请结合临床；2.定期复查\r\n\r\n2、左右眼眶间浓聚影（炎症影响可能）；上段胸椎稀疏影（考虑：放疗后改变）。\r\n    建议：定期复查 "}],"record_no":"0000506238"},{"date":"2018-11-09","list":[{"record_no":"0000505126","appform_no":"181105798363","devicetype":"内窥镜","item_name":"[气管镜检查,气管镜]","djdate":"2018-11-08 15:52:10","jcdate":"2018-11-09 09:54:59","bgzt":"1 ","zdyj":null,"bgjy":null,"bgdate":null,"bgresult":null}],"record_no":"0000505126"},{"date":"2018-11-09","list":[{"record_no":"0000485724","appform_no":"181109804188","devicetype":"CT","item_name":"[胸部,平扫]","djdate":"2018-11-09 08:13:12","jcdate":"2018-11-09 12:20:19","bgzt":"1 ","zdyj":null,"bgjy":null,"bgdate":"2018-11-09 12:48:16","bgresult":"1.右肺上叶近肺门软组织影较前变化不大；并右肺部分不张，较前范围缩小。\r\n2.原右肺结节，显示不清。\r\n  左肺上叶及左肺叶间裂小结节，较前变化不大。\r\n3.纵隔及右肺门多发小淋巴结，较前变化不大。\r\n4.右侧气胸；\r\n  右侧胸腔积液，较前减少。\r\n5.左肺下叶少量炎症，较前新增；\r\n  右肺多发条索，较前减少。\r\n6.所示肝脏散在低密度灶，所示层面较前相仿。"}],"record_no":"0000485724"}]
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
         * date : 2018-11-09
         * list : [{"record_no":"0000506238","appform_no":null,"devicetype":"ECT","item_name":"[全身骨显像]","djdate":"2018-11-09 09:03:43","jcdate":"2018-11-09 11:08:40","bgzt":"1 ","zdyj":null,"bgjy":null,"bgdate":"2018-11-09 11:50:18","bgresult":"1、左后第5-7肋骨质代谢活跃（考虑：创伤）；\r\n    建议：1.请结合临床；2.定期复查\r\n\r\n2、左右眼眶间浓聚影（炎症影响可能）；上段胸椎稀疏影（考虑：放疗后改变）。\r\n    建议：定期复查 "}]
         * record_no : 0000506238
         */

        private String date;
        private String record_no;
        private List<ListBean> list;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getRecord_no() {
            return record_no;
        }

        public void setRecord_no(String record_no) {
            this.record_no = record_no;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * record_no : 0000506238
             * appform_no : null
             * devicetype : ECT
             * item_name : [全身骨显像]
             * djdate : 2018-11-09 09:03:43
             * jcdate : 2018-11-09 11:08:40
             * bgzt : 1
             * zdyj : null
             * bgjy : null
             * bgdate : 2018-11-09 11:50:18
             * bgresult : 1、左后第5-7肋骨质代谢活跃（考虑：创伤）；
             建议：1.请结合临床；2.定期复查

             2、左右眼眶间浓聚影（炎症影响可能）；上段胸椎稀疏影（考虑：放疗后改变）。
             建议：定期复查
             */

            private String record_no;
            private String appform_no;
            private String devicetype;
            private String item_name;
            private String djdate;
            private String jcdate;
            private String bgzt;
            private String zdyj;
            private String bgjy;
            private String bgdate;
            private String bgresult;

            public String getAppform_no() {
                return appform_no;
            }

            public void setAppform_no(String appform_no) {
                this.appform_no = appform_no;
            }

            public String getZdyj() {
                return zdyj;
            }

            public void setZdyj(String zdyj) {
                this.zdyj = zdyj;
            }

            public String getBgjy() {
                return bgjy;
            }

            public void setBgjy(String bgjy) {
                this.bgjy = bgjy;
            }

            public String getRecord_no() {
                return record_no;
            }

            public void setRecord_no(String record_no) {
                this.record_no = record_no;
            }



            public String getDevicetype() {
                return devicetype;
            }

            public void setDevicetype(String devicetype) {
                this.devicetype = devicetype;
            }

            public String getItem_name() {
                return item_name;
            }

            public void setItem_name(String item_name) {
                this.item_name = item_name;
            }

            public String getDjdate() {
                return djdate;
            }

            public void setDjdate(String djdate) {
                this.djdate = djdate;
            }

            public String getJcdate() {
                return jcdate;
            }

            public void setJcdate(String jcdate) {
                this.jcdate = jcdate;
            }

            public String getBgzt() {
                return bgzt;
            }

            public void setBgzt(String bgzt) {
                this.bgzt = bgzt;
            }





            public String getBgdate() {
                return bgdate;
            }

            public void setBgdate(String bgdate) {
                this.bgdate = bgdate;
            }

            public String getBgresult() {
                return bgresult;
            }

            public void setBgresult(String bgresult) {
                this.bgresult = bgresult;
            }
        }
    }
}
