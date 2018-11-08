package com.pda.pda_android.db.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/11/1 11:12
 * 功能：因网络问题缓存到本地数据库的对象
 */
@Entity
public class PostCacheBean implements Serializable {
    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    private String url; //未提交的接口地址
    private String error_code; //错误代码
    private String parameter;//参数（json类型）
    private String code; //护士编号
    private String data; //时间
    @Generated(hash = 66979831)
    public PostCacheBean(Long id, String url, String error_code, String parameter,
            String code, String data) {
        this.id = id;
        this.url = url;
        this.error_code = error_code;
        this.parameter = parameter;
        this.code = code;
        this.data = data;
    }
    @Generated(hash = 1499963798)
    public PostCacheBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getError_code() {
        return this.error_code;
    }
    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
    public String getParameter() {
        return this.parameter;
    }
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PostCacheBean{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", error_code='" + error_code + '\'' +
                ", parameter='" + parameter + '\'' +
                ", code='" + code + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
