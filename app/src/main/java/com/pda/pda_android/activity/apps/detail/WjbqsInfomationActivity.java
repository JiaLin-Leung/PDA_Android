package com.pda.pda_android.activity.apps.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.UserBean;

/**
 * 梁佳霖创建于：2018/10/31 11:04
 * 功能：无菌包签收二级页面
 */
public class WjbqsInfomationActivity extends BaseActivity {

    private ImageView title_back;
    private ImageView user_name_up;
    private ImageView users_all;
    private ImageView user_name_down;
    private TextView user_info;
    @Override
    public int setLayoutId() {
        return R.layout.activity_wjbqsinfomation;
    }

    @Override
    public void initView() {
        UserBean userBean = (UserBean) getIntent().getSerializableExtra("userBean");
        title_back = findViewById(R.id.title_back);
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WjbqsInfomationActivity.this.finish();
            }
        });
        user_name_up = findViewById(R.id.user_name_up);
        user_name_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        user_name_down = findViewById(R.id.user_name_down);
        user_name_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        users_all = findViewById(R.id.users_all);
        users_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WjbqsInfomationActivity.this.finish();
            }
        });
        user_info = findViewById(R.id.user_info);
        user_info.setText(userBean.getBed_no()+"  "+userBean.getPatient_name());
    }

    @Override
    public void initData() {

    }
}
