package com.pda.pda_android.db.Entry;

import com.pda.pda_android.db.converter.SsxxBeanListBean_Converter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/11/1 11:12
 * 功能：手术信息数据库
 */
@Entity
public class SsxxBean implements Serializable {
    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    private String date;
    @Convert(columnType = String.class, converter = SsxxBeanListBean_Converter.class)
    private List<SsxxBeanListBean> list;
    @Generated(hash = 1175333220)
    public SsxxBean(Long id, String date, List<SsxxBeanListBean> list) {
        this.id = id;
        this.date = date;
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
    public List<SsxxBeanListBean> getList() {
        return this.list;
    }
    public void setList(List<SsxxBeanListBean> list) {
        this.list = list;
    }
}
