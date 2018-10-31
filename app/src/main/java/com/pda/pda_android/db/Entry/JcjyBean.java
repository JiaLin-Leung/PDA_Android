package com.pda.pda_android.db.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/10/31 16:42
 * 功能：检查检验对象
 */
@Entity
public class JcjyBean implements Serializable {

    @Id(autoincrement = true)
    private Long id;
    static final long serialVersionUID = -15515456L;
    private String time_main;
    private String xiangmu;
    private String shebei;
    private String time_shenqing;
    private String time_jiance;
    private String time_baogao;
    private String xiangqing;
    @Generated(hash = 1835089840)
    public JcjyBean(Long id, String time_main, String xiangmu, String shebei,
            String time_shenqing, String time_jiance, String time_baogao,
            String xiangqing) {
        this.id = id;
        this.time_main = time_main;
        this.xiangmu = xiangmu;
        this.shebei = shebei;
        this.time_shenqing = time_shenqing;
        this.time_jiance = time_jiance;
        this.time_baogao = time_baogao;
        this.xiangqing = xiangqing;
    }
    @Generated(hash = 1537123182)
    public JcjyBean() {
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime_main() {
        return this.time_main;
    }
    public void setTime_main(String time_main) {
        this.time_main = time_main;
    }
    public String getXiangmu() {
        return this.xiangmu;
    }
    public void setXiangmu(String xiangmu) {
        this.xiangmu = xiangmu;
    }
    public String getShebei() {
        return this.shebei;
    }
    public void setShebei(String shebei) {
        this.shebei = shebei;
    }
    public String getTime_shenqing() {
        return this.time_shenqing;
    }
    public void setTime_shenqing(String time_shenqing) {
        this.time_shenqing = time_shenqing;
    }
    public String getTime_jiance() {
        return this.time_jiance;
    }
    public void setTime_jiance(String time_jiance) {
        this.time_jiance = time_jiance;
    }
    public String getTime_baogao() {
        return this.time_baogao;
    }
    public void setTime_baogao(String time_baogao) {
        this.time_baogao = time_baogao;
    }
    public String getXiangqing() {
        return this.xiangqing;
    }
    public void setXiangqing(String xiangqing) {
        this.xiangqing = xiangqing;
    }

    @Override
    public String toString() {
        return "JcjyBean{" +
                "id=" + id +
                ", time_main='" + time_main + '\'' +
                ", xiangmu='" + xiangmu + '\'' +
                ", shebei='" + shebei + '\'' +
                ", time_shenqing='" + time_shenqing + '\'' +
                ", time_jiance='" + time_jiance + '\'' +
                ", time_baogao='" + time_baogao + '\'' +
                ", xiangqing='" + xiangqing + '\'' +
                '}';
    }
}
