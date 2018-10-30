package com.pda.pda_android.activity.apps.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.UserBean;

import java.io.Serializable;

/**
 * 梁佳霖创建于：2018/10/30 15:28
 * 功能：手术信息二级页面
 */
public class SSXXInfomationActivity extends BaseActivity {
    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxxinfomation;
    }

    @Override
    public void initView() {
        UserBean userBean = (UserBean) getIntent().getSerializableExtra("userBean");
        LogUtils.showLog("5555555",userBean.toString());
    }

    @Override
    public void initData() {

    }
}
