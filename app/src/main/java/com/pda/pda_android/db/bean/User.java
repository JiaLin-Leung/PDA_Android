package com.pda.pda_android.db.bean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/10/24 11:40
 * 功能：
 */
public class User implements Serializable{

    private String id;
    private String username;
    private String password;

    public User(String id,String username,String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
