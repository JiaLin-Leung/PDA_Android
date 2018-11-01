package com.pda.pda_android.db.Entry;

import com.pda.pda_android.db.converter.CheckBeanListBean_Converter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/11/1 11:12
 * 功能：
 */
@Entity
public class CheckBean implements Serializable {
    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    private String date;
    @Convert(columnType = String.class, converter = CheckBeanListBean_Converter.class)
    private List<CheckBeanListBean> list;
    @Generated(hash = 1507022409)
    public CheckBean(Long id, String date, List<CheckBeanListBean> list) {
        this.id = id;
        this.date = date;
        this.list = list;
    }
    @Generated(hash = 1325780914)
    public CheckBean() {
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
    public List<CheckBeanListBean> getList() {
        return this.list;
    }
    public void setList(List<CheckBeanListBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CheckBean{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", list=" + list +
                '}';
    }
}
