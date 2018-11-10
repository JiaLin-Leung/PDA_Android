package com.pda.pda_android.activity.apps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.UsersListActivity;
import com.pda.pda_android.activity.apps.detail.SsxxInfomationActivity;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.bean.ScanUserBean;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.dbutil.UserDaoOpe;

import java.util.List;


/**
 * 梁佳霖创建于：2018/10/29 10:16
 * 功能：手术信息
 */
public class SSXXActivity extends BaseActivity {

    private TextView tv_top_title;
    private String title;   //顶部title
    private ImageView user_all;
    private SsxxBroadcastReceiver ssxxBroadcastReceiver;
    private IntentFilter intentFilter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxx;
    }

    @Override
    public void initView() {
        intentFilter = new IntentFilter(ContentUrl.ACTION);   // 设置广播接收器的信息过滤器，
        ssxxBroadcastReceiver = new SsxxBroadcastReceiver();
        registerReceiver(ssxxBroadcastReceiver, intentFilter);
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
    /**
     * 接收PDA扫描的广播
     */
    class SsxxBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getStringExtra("data");
            Gson gson = new Gson();
            ScanUserBean scanUserBean = gson.fromJson(name,ScanUserBean.class);
            List<UserBean> userBeans =  UserDaoOpe.queryRecord_no(SSXXActivity.this,scanUserBean.getRecord_no());

            UserBean userBean = userBeans.get(0);
            Intent intent2 = new Intent(SSXXActivity.this,SsxxInfomationActivity.class);
            intent2.putExtra("userBean",userBean);
            startActivity(intent2);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(ssxxBroadcastReceiver);
    }
}
