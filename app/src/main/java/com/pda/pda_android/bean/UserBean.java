package com.pda.pda_android.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/10/30 11:32
 * 功能：
 */
@Entity
public class UserBean {
    @Id(autoincrement = true)
    private Long id;
    private String record_no;
    private String patient_no;
    private String patient_name;
    private String bed_no;
    private String sex;
    private String tend;
    private String age;
    @Generated(hash = 38138115)
    public UserBean(Long id, String record_no, String patient_no,
            String patient_name, String bed_no, String sex, String tend,
            String age) {
        this.id = id;
        this.record_no = record_no;
        this.patient_no = patient_no;
        this.patient_name = patient_name;
        this.bed_no = bed_no;
        this.sex = sex;
        this.tend = tend;
        this.age = age;
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
                '}';
    }
}
