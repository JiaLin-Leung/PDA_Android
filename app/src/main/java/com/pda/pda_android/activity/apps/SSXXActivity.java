package com.pda.pda_android.activity.apps;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.UsersListActivity;
import com.pda.pda_android.base.BaseActivity;


/**
 * 梁佳霖创建于：2018/10/29 10:16
 * 功能：手术信息
 */
public class SSXXActivity extends BaseActivity {

    private TextView tv_top_title;
    private String title;   //顶部title
    private ImageView user_all;

    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxx;
    }

    @Override
    public void initView() {
        title = getIntent().getStringExtra("title");
        setTitle(title);
        user_all = findViewById(R.id.users_all);
    }

    @Override
    public void initData() {
        user_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsersListActivity.go_UsersListActivity(SSXXActivity.this,"SSXX");
            }
        });
    }
}
