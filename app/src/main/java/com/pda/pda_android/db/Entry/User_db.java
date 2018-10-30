package com.pda.pda_android.db.Entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 梁佳霖创建于：2018/10/30 10:12
 * 功能：
 */
@Entity
public class User_db {

    @Id
    private Long id;
    private String user_name;
    private String age;
    private String sex;
    private String huli_level;
    private String bad_num;
    private String user_id;
    @Generated(hash = 1092430318)
    public User_db(Long id, String user_name, String age, String sex,
            String huli_level, String bad_num, String user_id) {
        this.id = id;
        this.user_name = user_name;
        this.age = age;
        this.sex = sex;
        this.huli_level = huli_level;
        this.bad_num = bad_num;
        this.user_id = user_id;
    }
    @Generated(hash = 1293876602)
    public User_db() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUser_name() {
        return this.user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getHuli_level() {
        return this.huli_level;
    }
    public void setHuli_level(String huli_level) {
        this.huli_level = huli_level;
    }
    public String getBad_num() {
        return this.bad_num;
    }
    public void setBad_num(String bad_num) {
        this.bad_num = bad_num;
    }
    public String getUser_id() {
        return this.user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User_db{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", huli_level='" + huli_level + '\'' +
                ", bad_num='" + bad_num + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
