package com.pda.pda_android.db.Entry;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/11/1 11:15
 * 功能：手术信息
 */
public class SsxxBeanListBean implements Serializable {

    /**
     * 			"xhhs_code": null,
     * 			"xhhs_name": null,
     * 			"operdiag": "食管下段癌",
     * 			"operdiag_after": "食管下段癌",
     * 			"hisappform": null,
     * 			"mzfs": "局麻",
     * 			"mzys_code": null,
     * 			"mzys_name": null,
     * 			"operscale": null,
     * 			"operstate": "术后",
     * 			"djtime": "2018-05-17 15:08:00",
     * 			"operxh": null,
     * 			"record_no": "0000485289",
     * 			"patient_no": "ZY010000485289",
     * 			"ward_code": "2063",
     * 			"ward_name": null,
     * 			"operid": "1",
     * 			"oper_name": "经腔插管消化道造影+经鼻腔食管瘘胃空肠营养管置入术",
     * 			"oper_code": null,
     * 			"yytime": "2018-05-17 15:10:00",
     * 			"inoper_time": "2018-05-17 15:10:00",
     * 			"endoper_time": "2018-05-17 15:55:00",
     * 			"outoper_time": "2018-05-17 16:00:00",
     * 			"inpacu_time": null,
     * 			"outpacu_time": null,
     * 			"oper_roomno": "DSA2",
     * 			"sequence_no": "6",
     * 			"surgeon_name": "陈呈世",
     * 			"surgeon_code"
     */

    private String xhhs_code;
    private String xhhs_name;
    private String operdiag;
    private String operdiag_after;
    private String hisappform;
    private String mzfs;
    private String mzys_code;
    private String mzys_name;
    private String operscale;
    private String operstate;
    private String djtime;
    private String operxh;
    private String record_no;
    private String patient_no;
    private String ward_code;
    private String ward_name;
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

    @Override
    public String toString() {
        return "SsxxBeanListBean{" +
                "xhhs_code='" + xhhs_code + '\'' +
                ", xhhs_name='" + xhhs_name + '\'' +
                ", operdiag='" + operdiag + '\'' +
                ", operdiag_after='" + operdiag_after + '\'' +
                ", hisappform='" + hisappform + '\'' +
                ", mzfs='" + mzfs + '\'' +
                ", mzys_code='" + mzys_code + '\'' +
                ", mzys_name='" + mzys_name + '\'' +
                ", operscale='" + operscale + '\'' +
                ", operstate='" + operstate + '\'' +
                ", djtime='" + djtime + '\'' +
                ", operxh='" + operxh + '\'' +
                ", record_no='" + record_no + '\'' +
                ", patient_no='" + patient_no + '\'' +
                ", ward_code='" + ward_code + '\'' +
                ", ward_name='" + ward_name + '\'' +
                ", operid='" + operid + '\'' +
                ", oper_name='" + oper_name + '\'' +
                ", oper_code='" + oper_code + '\'' +
                ", yytime='" + yytime + '\'' +
                ", inoper_time='" + inoper_time + '\'' +
                ", endoper_time='" + endoper_time + '\'' +
                ", outoper_time='" + outoper_time + '\'' +
                ", inpacu_time='" + inpacu_time + '\'' +
                ", outpacu_time='" + outpacu_time + '\'' +
                ", oper_roomno='" + oper_roomno + '\'' +
                ", sequence_no='" + sequence_no + '\'' +
                ", surgeon_name='" + surgeon_name + '\'' +
                ", surgeon_code='" + surgeon_code + '\'' +
                '}';
    }

    public String getXhhs_code() {
        return xhhs_code;
    }

    public void setXhhs_code(String xhhs_code) {
        this.xhhs_code = xhhs_code;
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

    public String getMzys_code() {
        return mzys_code;
    }

    public void setMzys_code(String mzys_code) {
        this.mzys_code = mzys_code;
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

    public String getOperstate() {
        return operstate;
    }

    public void setOperstate(String operstate) {
        this.operstate = operstate;
    }

    public String getDjtime() {
        return djtime;
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

    public String getRecord_no() {
        return record_no;
    }

    public void setRecord_no(String record_no) {
        this.record_no = record_no;
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

    public String getWard_name() {
        return ward_name;
    }

    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
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

    public String getOutoper_time() {
        return outoper_time;
    }

    public void setOutoper_time(String outoper_time) {
        this.outoper_time = outoper_time;
    }

    public String getInpacu_time() {
        return inpacu_time;
    }

    public void setInpacu_time(String inpacu_time) {
        this.inpacu_time = inpacu_time;
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