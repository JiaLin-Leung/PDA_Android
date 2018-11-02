package com.pda.pda_android.db.Entry;

import com.pda.pda_android.db.converter.SsxxBeanListBean_Converter;

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
public class SsxxBean implements Serializable {
    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    private String date;
    private String record_no;
    @Convert(columnType = String.class, converter = SsxxBeanListBean_Converter.class)
    private List<SsxxBeanListBean> list;
    @Generated(hash = 1337485018)
    public SsxxBean(Long id, String date, String record_no, List<SsxxBeanListBean> list) {
        this.id = id;
        this.date = date;
        this.record_no = record_no;
        this.list = list;
    }
    @Generated(hash = 312124334)
    public SsxxBean() {
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
    public String getRecord_no() {
        return this.record_no;
    }
    public void setRecord_no(String record_no) {
        this.record_no = record_no;
    }
    public List<SsxxBeanListBean> getList() {
        return this.list;
    }
    public void setList(List<SsxxBeanListBean> list) {
        this.list = list;
    }
}
