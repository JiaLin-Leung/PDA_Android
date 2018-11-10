package com.pda.pda_android.activity.apps.detail.jcjydetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.UsersListActivity;
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
        iv_top_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_top_title.setText(getIntent().getStringExtra("name"));
        if (null!=getIntent().getStringExtra("jc_content")){
            jc_content.setText(getIntent().getStringExtra("jc_content"));
        }
        if (null!=getIntent().getStringExtra("zd_content")){
            zd_content.setText(getIntent().getStringExtra("zd_content"));
        }
        if (null!=getIntent().getStringExtra("bg_content")){
            bg_content.setText(getIntent().getStringExtra("bg_content"));
        }
        bg_content.setMovementMethod(ScrollingMovementMethod.getInstance());
        zd_content.setMovementMethod(ScrollingMovementMethod.getInstance());
        jc_content.setMovementMethod(ScrollingMovementMethod.getInstance());
    }


}
