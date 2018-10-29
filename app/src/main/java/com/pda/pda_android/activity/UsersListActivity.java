package com.pda.pda_android.activity;

import android.content.Context;
import android.content.Intent;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;

/**
 * 梁佳霖创建于：2018/10/29 11:52
 * 功能：
 */
public class UsersListActivity extends BaseActivity {
    @Override
    public int setLayoutId() {
        return R.layout.activity_users_list;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    public static void go_UsersListActivity(Context context){
        Intent intent = new Intent(context,UsersListActivity.class);
        context.startActivity(intent);
    }
}
