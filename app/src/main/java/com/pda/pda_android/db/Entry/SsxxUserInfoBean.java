package com.pda.pda_android.db.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/10/30 18:44
 * 功能：手术信息二级页面
 */
@Entity
public class SsxxUserInfoBean implements Serializable {

    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    private String shoushu_name;
    private String shoushu_docter;
    private String shoushu_time;
    private String shoushu_user;
    @Generated(hash = 1025702888)
    public SsxxUserInfoBean(Long id, String shoushu_name, String shoushu_docter,
            String shoushu_time, String shoushu_user) {
        this.id = id;
        this.shoushu_name = shoushu_name;
        this.shoushu_docter = shoushu_docter;
        this.shoushu_time = shoushu_time;
        this.shoushu_user = shoushu_user;
    }
    @Generated(hash = 1015137361)
    public SsxxUserInfoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getShoushu_name() {
        return this.shoushu_name;
    }
    public void setShoushu_name(String shoushu_name) {
        this.shoushu_name = shoushu_name;
    }
    public String getShoushu_docter() {
        return this.shoushu_docter;
    }
    public void setShoushu_docter(String shoushu_docter) {
        this.shoushu_docter = shoushu_docter;
    }
    public String getShoushu_time() {
        return this.shoushu_time;
    }
    public void setShoushu_time(String shoushu_time) {
        this.shoushu_time = shoushu_time;
    }
    public String getShoushu_user() {
        return this.shoushu_user;
    }
    public void setShoushu_user(String shoushu_user) {
        this.shoushu_user = shoushu_user;
    }
}
