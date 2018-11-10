package com.pda.pda_android.activity.apps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.MainActivity;
import com.pda.pda_android.activity.UsersListActivity;
import com.pda.pda_android.activity.apps.detail.JcjyListActivity;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.ScanUserBean;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.dbutil.UserDaoOpe;

import java.util.List;


/**
 * 梁佳霖创建于：2018/10/29 10:16
 * 功能：检查检验模块
 */
public class JcjyActivity extends BaseActivity {

    private TextView tv_top_title;
    private String title;   //顶部title
    private ImageView users_all;
    private JcjyBroadcastReceiver myBroadcastReceiver;
    private IntentFilter intentFilter;
    @Override
    public int setLayoutId() {
        return R.layout.activity_jcjy;
    }

    @Override
    public void initView() {
        intentFilter = new IntentFilter(ContentUrl.ACTION);   // 设置广播接收器的信息过滤器，
        myBroadcastReceiver = new JcjyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver, intentFilter);
        title = getIntent().getStringExtra("title");
        users_all = findViewById(R.id.users_all);
        users_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsersListActivity.go_UsersListActivity(JcjyActivity.this,"JCJY");
            }
        });
        setTitle(title);
    }

    @Override
    public void initData() {

    }

    /**
     * 接收PDA扫描的广播
     */
    class JcjyBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getStringExtra("data");
            Gson gson = new Gson();
            ScanUserBean scanUserBean = gson.fromJson(name,ScanUserBean.class);
            List<UserBean> userBeans =  UserDaoOpe.queryRecord_no(JcjyActivity.this,scanUserBean.getRecord_no());

            UserBean userBean = userBeans.get(0);
            Intent intent2 = new Intent(JcjyActivity.this,JcjyListActivity.class);
            intent2.putExtra("userBean",userBean);
            startActivity(intent2);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
    }
}
