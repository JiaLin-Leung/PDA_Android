package com.pda.pda_android.db.Entry;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/11/1 11:15
 * 功能：
 */
public class AssayBeanListBean implements Serializable {

    /**
     "patient_no": "ZY040000469876",
     "ward_code": "7063",
     "sqxm": "血常规",
     "xmmc": "血球SYSMXC",
     "jggl": "临检血液",
     "sqdate": "2018-05-17 17:00:00",
     "jydate": "2018-05-18 07:55:13",
     "bgdate": "2018-05-18 08:09:11",
     "sqxh": "4850626"
     */

    private String patient_no;
    private String ward_code;
    private String sqxm;
    private String xmmc;
    private String jggl;
    private String sqdate;
    private String jydate;
    private String bgdate;
    private String sqxh;

    @Override
    public String toString() {
        return "AssayBeanListBean{" +
                "patient_no='" + patient_no + '\'' +
                ", ward_code='" + ward_code + '\'' +
                ", sqxm='" + sqxm + '\'' +
                ", xmmc='" + xmmc + '\'' +
                ", jggl='" + jggl + '\'' +
                ", sqdate='" + sqdate + '\'' +
                ", jydate='" + jydate + '\'' +
                ", bgdate='" + bgdate + '\'' +
                ", sqxh='" + sqxh + '\'' +
                '}';
    }

    public String getPatient_no() {
        return patient_no;
    }

    public void setPatient_no(String patient_no) {
        this.patient_no = patient_no;
    }

    public String getWard_code() {
        return ward_code;
    }

    public void setWard_code(String ward_code) {
        this.ward_code = ward_code;
    }

    public String getSqxm() {
        return sqxm;
    }

    public void setSqxm(String sqxm) {
        this.sqxm = sqxm;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getJggl() {
        return jggl;
    }

    public void setJggl(String jggl) {
        this.jggl = jggl;
    }

    public String getSqdate() {
        return sqdate;
    }

    public void setSqdate(String sqdate) {
        this.sqdate = sqdate;
    }

    public String getJydate() {
        return jydate;
    }

    public void setJydate(String jydate) {
        this.jydate = jydate;
    }

    public String getBgdate() {
        return bgdate;
    }

    public void setBgdate(String bgdate) {
        this.bgdate = bgdate;
    }

    public String getSqxh() {
        return sqxh;
    }

    public void setSqxh(String sqxh) {
        this.sqxh = sqxh;
    }
}
