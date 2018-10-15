package com.pda.pda_android.activity;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;

/**
 * 梁佳霖创建于：2018/10/15 15:56
 * 功能：
 */
public class AllAppActivity extends BaseActivity {
    @Override
    public int setLayoutId() {
        return R.layout.activity_allapp;
    }

    @Override
    public void initView() {
        setTitleWithFinish("全部应用","完成！");
    }

    @Override
    public void initData() {

    }
}
