package com.pda.pda_android.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;

/**
 * 梁佳霖创建于：2018/10/29 11:52
 * 功能：用户列表
 */
public class UsersListActivity extends BaseActivity {

    private ListView users_listview;

    @Override
    public int setLayoutId() {
        return R.layout.activity_users_list;
    }

    @Override
    public void initView() {
        users_listview = findViewById(R.id.users_listview);
    }

    @Override
    public void initData() {

    }

    public static void go_UsersListActivity(Context context){
        Intent intent = new Intent(context,UsersListActivity.class);
        context.startActivity(intent);
    }
}
