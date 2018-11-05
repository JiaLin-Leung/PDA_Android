package com.pda.pda_android.activity.apps.detail.jcjydetail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;

/**
 * 检查结果详情页
 */
public class JcDetailActivity extends BaseActivity {
    private TextView tv_top_title;
    private ImageView iv_top_back;
    private TextView jc_content;
    private TextView zd_content;
    private TextView bg_content;

    @Override
    public int setLayoutId() {
        return R.layout.activity_jc_detail;
    }

    @Override
    public void initView() {
        tv_top_title=findViewById(R.id.tv_top_title);
        iv_top_back=findViewById(R.id.iv_top_back);
        jc_content=findViewById(R.id.jc_content);
        zd_content=findViewById(R.id.zd_content);
        bg_content=findViewById(R.id.bg_content);
    }

    @Override
    public void initData() {

    }
}
