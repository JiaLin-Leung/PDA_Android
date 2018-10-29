package com.pda.pda_android.activity.apps.bean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/10/29 16:11
 * 功能：用户列表的用户对象
 */
public class User implements Serializable {

    public User(String user_name, String age, String sex, String huli_level, String bad_num, String user_id) {
        this.user_name = user_name;
        this.age = age;
        this.sex = sex;
        this.huli_level = huli_level;
        this.bad_num = bad_num;
        this.user_id = user_id;
    }

    private String user_name;
    private String age;
    private String sex;
    private String huli_level;
    private String bad_num;
    private String user_id;

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", huli_level='" + huli_level + '\'' +
                ", bad_num='" + bad_num + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHuli_level() {
        return huli_level;
    }

    public void setHuli_level(String huli_level) {
        this.huli_level = huli_level;
    }

    public String getBad_num() {
        return bad_num;
    }

    public void setBad_num(String bad_num) {
        this.bad_num = bad_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
