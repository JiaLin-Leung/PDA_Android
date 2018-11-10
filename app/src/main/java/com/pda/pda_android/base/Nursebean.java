package com.pda.pda_android.base;

import java.io.Serializable;
import java.util.List;

/**
 * 梁佳霖创建于：2018/11/10 11:50
 * 功能：护士个人信息
 */
public class Nursebean implements Serializable {

    /**
     * {
     * 	"response": "ok",
     * 	"error": "",
     * 	"data": {
     * 		"code": "000775",
     * 		"name": "李**娜",
     * 		"wards": [{
     * 			"ward_code": "6001",
     * 			"ward_name": "手术室",
     * 			"is_current": 1
     *                }]    * 	},
     * 	"message": "",
     * 	"next": ""
     * }
     */

    public String response;
    public String error;
    public String message;
    public String next;
    public NursebeanDataBean data;

    @Override
    public String toString() {
        return "Nursebean{" +
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

    public NursebeanDataBean getData() {
        return data;
    }

    public void setData(NursebeanDataBean data) {
        this.data = data;
    }

    public class NursebeanDataBean implements Serializable{

        public String code;
        public String name;
        public List<NursebeanDataBeanWardsBean> wards;

        @Override
        public String toString() {
            return "NursebeanDataBean{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", wards=" + wards +
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

        public List<NursebeanDataBeanWardsBean> getWards() {
            return wards;
        }

        public void setWards(List<NursebeanDataBeanWardsBean> wards) {
            this.wards = wards;
        }

        public class NursebeanDataBeanWardsBean implements Serializable{

            private String ward_code;
            private String ward_name;
            private String is_current;

            @Override
            public String toString() {
                return "NursebeanDataBeanWardsBean{" +
                        "ward_code='" + ward_code + '\'' +
                        ", ward_name='" + ward_name + '\'' +
                        ", is_current='" + is_current + '\'' +
                        '}';
            }

            public String getWard_code() {
                return ward_code;
            }

            public void setWard_code(String ward_code) {
                this.ward_code = ward_code;
            }

            public String getWard_name() {
                return ward_name;
            }

            public void setWard_name(String ward_name) {
                this.ward_name = ward_name;
            }

            public String getIs_current() {
                return is_current;
            }

            public void setIs_current(String is_current) {
                this.is_current = is_current;
            }
        }
    }
}
