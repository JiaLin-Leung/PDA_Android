package com.pda.pda_android.activity.apps.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.SsxxUserInfoBean;

/**
 * 梁佳霖创建于：2018/10/31 09:33
 * 功能：手术信息详情页面
 */
public class SsxxInfomationDetailActivity extends BaseActivity {

    private SsxxUserInfoBean ssxxUserInfoBean;
    private ImageView iv_top_back;
    private TextView username_badnum;

    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxxinfomationdetail;
    }

    @Override
    public void initView() {
        ssxxUserInfoBean = (SsxxUserInfoBean) getIntent().getSerializableExtra("ssxxUserInfoBean");
        iv_top_back = findViewById(R.id.iv_top_back);
        iv_top_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SsxxInfomationDetailActivity.this.finish();
            }
        });
        username_badnum = findViewById(R.id.tv_top_title);
    }

    @Override
    public void initData() {

    }
}
