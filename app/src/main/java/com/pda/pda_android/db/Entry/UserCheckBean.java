package com.pda.pda_android.db.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/10/31 18:37
 * 功能：
 */
@Entity
public class UserCheckBean implements Serializable {

    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
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
    @Generated(hash = 821339659)
    public UserCheckBean(Long id, String record_no, String appform_no,
            String devicetype, String item_name, String djdate, String jcdate,
            String bgzt, String zdyj, String bgjy, String bgdate, String bgresult) {
        this.id = id;
        this.record_no = record_no;
        this.appform_no = appform_no;
        this.devicetype = devicetype;
        this.item_name = item_name;
        this.djdate = djdate;
        this.jcdate = jcdate;
        this.bgzt = bgzt;
        this.zdyj = zdyj;
        this.bgjy = bgjy;
        this.bgdate = bgdate;
        this.bgresult = bgresult;
    }
    @Generated(hash = 985671194)
    public UserCheckBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRecord_no() {
        return this.record_no;
    }
    public void setRecord_no(String record_no) {
        this.record_no = record_no;
    }
    public String getAppform_no() {
        return this.appform_no;
    }
    public void setAppform_no(String appform_no) {
        this.appform_no = appform_no;
    }
    public String getDevicetype() {
        return this.devicetype;
    }
    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }
    public String getItem_name() {
        return this.item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public String getDjdate() {
        return this.djdate;
    }
    public void setDjdate(String djdate) {
        this.djdate = djdate;
    }
    public String getJcdate() {
        return this.jcdate;
    }
    public void setJcdate(String jcdate) {
        this.jcdate = jcdate;
    }
    public String getBgzt() {
        return this.bgzt;
    }
    public void setBgzt(String bgzt) {
        this.bgzt = bgzt;
    }
    public String getZdyj() {
        return this.zdyj;
    }
    public void setZdyj(String zdyj) {
        this.zdyj = zdyj;
    }
    public String getBgjy() {
        return this.bgjy;
    }
    public void setBgjy(String bgjy) {
        this.bgjy = bgjy;
    }
    public String getBgdate() {
        return this.bgdate;
    }
    public void setBgdate(String bgdate) {
        this.bgdate = bgdate;
    }
    public String getBgresult() {
        return this.bgresult;
    }
    public void setBgresult(String bgresult) {
        this.bgresult = bgresult;
    }

    @Override
    public String toString() {
        return "UserCheckBean{" +
                "id=" + id +
                ", record_no='" + record_no + '\'' +
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
}
