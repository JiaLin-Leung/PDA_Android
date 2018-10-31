package com.pda.pda_android.db.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/10/30 11:32
 * 功能：用户bean（数据表字段对应）
 * */
@Entity
public class UserBean implements Serializable{
    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    private String record_no;
    private String patient_no;
    private String patient_name;
    private String bed_no;
    private String sex;
    private String tend;
    private String age;
    private String ward_code;
    private String in_date;
    private String doctor;
    private String result;
    private String zrhs_code;
    private String hs_name;
    private String ward_name;
    @Generated(hash = 1178796037)
    public UserBean(Long id, String record_no, String patient_no,
            String patient_name, String bed_no, String sex, String tend, String age,
            String ward_code, String in_date, String doctor, String result,
            String zrhs_code, String hs_name, String ward_name) {
        this.id = id;
        this.record_no = record_no;
        this.patient_no = patient_no;
        this.patient_name = patient_name;
        this.bed_no = bed_no;
        this.sex = sex;
        this.tend = tend;
        this.age = age;
        this.ward_code = ward_code;
        this.in_date = in_date;
        this.doctor = doctor;
        this.result = result;
        this.zrhs_code = zrhs_code;
        this.hs_name = hs_name;
        this.ward_name = ward_name;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
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
    public String getPatient_no() {
        return this.patient_no;
    }
    public void setPatient_no(String patient_no) {
        this.patient_no = patient_no;
    }
    public String getPatient_name() {
        return this.patient_name;
    }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }
    public String getBed_no() {
        return this.bed_no;
    }
    public void setBed_no(String bed_no) {
        this.bed_no = bed_no;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTend() {
        return this.tend;
    }
    public void setTend(String tend) {
        this.tend = tend;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getWard_code() {
        return this.ward_code;
    }
    public void setWard_code(String ward_code) {
        this.ward_code = ward_code;
    }
    public String getIn_date() {
        return this.in_date;
    }
    public void setIn_date(String in_date) {
        this.in_date = in_date;
    }
    public String getDoctor() {
        return this.doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getResult() {
        return this.result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getZrhs_code() {
        return this.zrhs_code;
    }
    public void setZrhs_code(String zrhs_code) {
        this.zrhs_code = zrhs_code;
    }
    public String getHs_name() {
        return this.hs_name;
    }
    public void setHs_name(String hs_name) {
        this.hs_name = hs_name;
    }
    public String getWard_name() {
        return this.ward_name;
    }
    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", record_no='" + record_no + '\'' +
                ", patient_no='" + patient_no + '\'' +
                ", patient_name='" + patient_name + '\'' +
                ", bed_no='" + bed_no + '\'' +
                ", sex='" + sex + '\'' +
                ", tend='" + tend + '\'' +
                ", age='" + age + '\'' +
                ", ward_code='" + ward_code + '\'' +
                ", in_date='" + in_date + '\'' +
                ", doctor='" + doctor + '\'' +
                ", result='" + result + '\'' +
                ", zrhs_code='" + zrhs_code + '\'' +
                ", hs_name='" + hs_name + '\'' +
                ", ward_name='" + ward_name + '\'' +
                '}';
    }
}
