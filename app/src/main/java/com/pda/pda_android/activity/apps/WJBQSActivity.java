package com.pda.pda_android.activity.apps;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;


/**
 * 梁佳霖创建于：2018/10/29 10:16
 * 功能：无菌包签收
 */
public class WJBQSActivity extends BaseActivity {

    private TextView tv_top_title;
    private String title;   //顶部title

    @Override
    public int setLayoutId() {
        return R.layout.activity_wjbqs;
    }

    @Override
    public void initView() {
        title = getIntent().getStringExtra("title");
        setTitle(title);
    }

    @Override
    public void initData() {

    }
}
