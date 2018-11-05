package com.pda.pda_android.db.Entry;

import com.pda.pda_android.db.converter.AssayBeanListBean_Converter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.List;

/**
 * 梁佳霖创建于：2018/11/1 11:12
 * 功能：
 */
@Entity
public class AssayBean implements Serializable {
    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    private String date;
    private String patient_no;
    @Convert(columnType = String.class, converter = AssayBeanListBean_Converter.class)
    private List<AssayBeanListBean> list;
    @Generated(hash = 1589304488)
    public AssayBean(Long id, String date, String patient_no, List<AssayBeanListBean> list) {
        this.id = id;
        this.date = date;
        this.patient_no = patient_no;
        this.list = list;
    }
    @Generated(hash = 2485670)
    public AssayBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPatient_no() {
        return this.patient_no;
    }
    public void setPatient_no(String patient_no) {
        this.patient_no = patient_no;
    }
    public List<AssayBeanListBean> getList() {
        return this.list;
    }
    public void setList(List<AssayBeanListBean> list) {
        this.list = list;
    }
}
