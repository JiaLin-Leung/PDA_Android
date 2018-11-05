package com.pda.pda_android.db.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/10/30 11:32
 * 功能：患者检验详情字段（数据表字段对应）
 * */
@Entity
public class AssayDetailBean implements Serializable{

    /**
     * "patient_no": "ZY170000416155",
     * 		"xmmc": "血球SYSMXC",
     * 		"itemno": "0101017",
     * 		"itemname": "血红蛋白",
     * 		"jg": "67",
     * 		"jg1": null,
     * 		"jg2": null,
     * 		"jgflag": "L",
     * 		"unit": "g/L",
     * 		"ranges": "130--175",
     * 		"sqdate": "2018-05-17 17:02:00",
     * 		"jydate": "2018-05-18 07:57:45",
     * 		"bgdate": "2018-05-18 08:10:28",
     * 		"jcys_name": null,
     * 		"jcys_code": "1282",
     * 		"bgys_code": "3791",
     * 		"bgys_name": null,
     * 		"sqxh": "4850649"
     */
    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    @Index(name = "patient_no") //添加索引，别名 patient_no
    private String patient_no;
    private String xmmc;
    private String itemno;
    private String itemname;
    private String jg;
    private String jg1;
    private String jg2;
    private String jgflag;
    private String unit;
    private String ranges;
    private String sqdate;
    private String jydate;
    private String bgdate;
    private String jcys_name;
    private String jcys_code;
    private String bgys_code;
    private String bgys_name;
    private String sqxh;
    @Generated(hash = 678850095)
    public AssayDetailBean(Long id, String patient_no, String xmmc, String itemno,
            String itemname, String jg, String jg1, String jg2, String jgflag,
            String unit, String ranges, String sqdate, String jydate, String bgdate,
            String jcys_name, String jcys_code, String bgys_code, String bgys_name,
            String sqxh) {
        this.id = id;
        this.patient_no = patient_no;
        this.xmmc = xmmc;
        this.itemno = itemno;
        this.itemname = itemname;
        this.jg = jg;
        this.jg1 = jg1;
        this.jg2 = jg2;
        this.jgflag = jgflag;
        this.unit = unit;
        this.ranges = ranges;
        this.sqdate = sqdate;
        this.jydate = jydate;
        this.bgdate = bgdate;
        this.jcys_name = jcys_name;
        this.jcys_code = jcys_code;
        this.bgys_code = bgys_code;
        this.bgys_name = bgys_name;
        this.sqxh = sqxh;
    }
    @Generated(hash = 318602787)
    public AssayDetailBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPatient_no() {
        return this.patient_no;
    }
    public void setPatient_no(String patient_no) {
        this.patient_no = patient_no;
    }
    public String getXmmc() {
        return this.xmmc;
    }
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }
    public String getItemno() {
        return this.itemno;
    }
    public void setItemno(String itemno) {
        this.itemno = itemno;
    }
    public String getItemname() {
        return this.itemname;
    }
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    public String getJg() {
        return this.jg;
    }
    public void setJg(String jg) {
        this.jg = jg;
    }
    public String getJg1() {
        return this.jg1;
    }
    public void setJg1(String jg1) {
        this.jg1 = jg1;
    }
    public String getJg2() {
        return this.jg2;
    }
    public void setJg2(String jg2) {
        this.jg2 = jg2;
    }
    public String getJgflag() {
        return this.jgflag;
    }
    public void setJgflag(String jgflag) {
        this.jgflag = jgflag;
    }
    public String getUnit() {
        return this.unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getRanges() {
        return this.ranges;
    }
    public void setRanges(String ranges) {
        this.ranges = ranges;
    }
    public String getSqdate() {
        return this.sqdate;
    }
    public void setSqdate(String sqdate) {
        this.sqdate = sqdate;
    }
    public String getJydate() {
        return this.jydate;
    }
    public void setJydate(String jydate) {
        this.jydate = jydate;
    }
    public String getBgdate() {
        return this.bgdate;
    }
    public void setBgdate(String bgdate) {
        this.bgdate = bgdate;
    }
    public String getJcys_name() {
        return this.jcys_name;
    }
    public void setJcys_name(String jcys_name) {
        this.jcys_name = jcys_name;
    }
    public String getJcys_code() {
        return this.jcys_code;
    }
    public void setJcys_code(String jcys_code) {
        this.jcys_code = jcys_code;
    }
    public String getBgys_code() {
        return this.bgys_code;
    }
    public void setBgys_code(String bgys_code) {
        this.bgys_code = bgys_code;
    }
    public String getBgys_name() {
        return this.bgys_name;
    }
    public void setBgys_name(String bgys_name) {
        this.bgys_name = bgys_name;
    }
    public String getSqxh() {
        return this.sqxh;
    }
    public void setSqxh(String sqxh) {
        this.sqxh = sqxh;
    }

}
