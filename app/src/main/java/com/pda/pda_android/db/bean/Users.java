package com.pda.pda_android.db.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/24 15:04
 * 功能：
 */
public class Users implements Serializable {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
