package com.pda.pda_android.activity.apps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.UsersListActivity;
import com.pda.pda_android.base.BaseActivity;


/**
 * 梁佳霖创建于：2018/10/29 10:16
 * 功能：检查检验模块
 */
public class JcjyActivity extends BaseActivity {

    private TextView tv_top_title;
    private String title;   //顶部title
    private ImageView users_all;

    @Override
    public int setLayoutId() {
        return R.layout.activity_jcjy;
    }

    @Override
    public void initView() {
        title = getIntent().getStringExtra("title");
        users_all = findViewById(R.id.users_all);
        users_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsersListActivity.go_UsersListActivity(JcjyActivity.this,"JCJY");
            }
        });
        setTitle(title);
    }

    @Override
    public void initData() {

    }
}
