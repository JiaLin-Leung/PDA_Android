package com.pda.pda_android.db.Entry;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/11/1 11:15
 * 功能：
 */
public class CheckBeanListBean implements Serializable {

    /**
     * 	"record_no": "0000485870",
     * 			"appform_no": "180515588607",
     * 			"devicetype": "CT",
     * 			"item_name": "[盆腔,平扫+多期增强][上腹,平扫+多期增强][胸部,平扫][下腹部,平扫+多期增强]",
     * 			"djdate": "2018-05-15 10:38:15",
     * 			"jcdate": "2018-05-17 20:35:44",
     * 			"bgzt": "1 ",
     * 			"zdyj": null,
     * 			"bgjy": null,
     * 			"bgdate": "2018-05-18 10:39:03",
     * 			"bgresult"
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

    @Override
    public String toString() {
        return "CheckBeanListBean{" +
                "record_no='" + record_no + '\'' +
                ", appform_no='" + appform_no + '\'' +
                ", devicetype='" + devicetype + '\'' +
                ", item_name='" + item_name + '\'' +
                ", djdate='" + djdate + '\'' +
                ", jcdate='" + jcdate + '\'' +
                ", bgzt='" + bgzt + '\'' +
                ", zdyj='" + zdyj + '\'' +
                ", bgjy='" + bgjy + '\'' +
                ", bgdate='" + bgdate + '\'' +
                ", bgresult='" + bgresult + '\'' +
                '}';
    }

    public String getRecord_no() {
        return record_no;
    }

    public void setRecord_no(String record_no) {
        this.record_no = record_no;
    }

    public String getAppform_no() {
        return appform_no;
    }

    public void setAppform_no(String appform_no) {
        this.appform_no = appform_no;
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
