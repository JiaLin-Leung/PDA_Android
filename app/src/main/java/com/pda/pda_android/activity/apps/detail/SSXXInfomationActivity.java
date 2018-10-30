package com.pda.pda_android.activity.apps.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.adapter.SsxxAdapter;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.SsxxUserInfoBean;
import com.pda.pda_android.db.Entry.UserBean;

import java.util.LinkedList;
import java.util.List;


/**
 * 梁佳霖创建于：2018/10/30 15:28
 * 功能：手术信息二级页面
 */
public class SSXXInfomationActivity extends BaseActivity {

    private ImageView title_back;
    private ImageView user_name_up;
    private ImageView users_all;
    private ImageView user_name_down;
    private TextView user_info;
    private TextView time;
    private TextView num;
    private LinearLayout shaixuan;
    private ListView ssxxinfoamtion_listview;
    private List<SsxxUserInfoBean> ssxxUserInfoBeanList;

    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxxinfomation;
    }

    @Override
    public void initView() {
        UserBean userBean = (UserBean) getIntent().getSerializableExtra("userBean");
        title_back = findViewById(R.id.title_back);
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SSXXInfomationActivity.this.finish();
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
                SSXXInfomationActivity.this.finish();
            }
        });
        user_info = findViewById(R.id.user_info);
        user_info.setText(userBean.getBed_no()+"  "+userBean.getPatient_name());
        time = findViewById(R.id.time);
        num = findViewById(R.id.num);
        shaixuan = findViewById(R.id.shaixuan);
        ssxxinfoamtion_listview = findViewById(R.id.ssxxinfoamtion_listview);
        ssxxUserInfoBeanList = new LinkedList<>();
        for (int a = 0;a<10;a++){
            SsxxUserInfoBean ssxxUserInfoBean = new SsxxUserInfoBean(null,"切除包皮","陈奕迅","2018-5-4 14:14:44","黄家驹的手术信息");
            ssxxUserInfoBeanList.add(ssxxUserInfoBean);
        }
        ssxxinfoamtion_listview.setAdapter(new SsxxAdapter(SSXXInfomationActivity.this,ssxxUserInfoBeanList));
    }

    @Override
    public void initData() {

    }
}
