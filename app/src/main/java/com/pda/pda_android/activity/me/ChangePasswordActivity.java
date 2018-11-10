package com.pda.pda_android.activity.me;

import android.view.View;
import android.widget.ImageView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;

/**
 * 梁佳霖创建于：2018/10/18 15:00
 * 功能：修改密码页面
 */
public class ChangePasswordActivity extends BaseActivity {

    private ImageView pass_back;

    @Override
    public int setLayoutId() {
        return R.layout.activity_password;
    }

    @Override
    public void initView() {
        pass_back = findViewById(R.id.pass_back);
        pass_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePasswordActivity.this.finish();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}
