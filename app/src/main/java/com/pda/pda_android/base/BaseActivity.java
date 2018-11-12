package com.pda.pda_android.base;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.LoginActivity;
import com.pda.pda_android.base.utils.SpUtils;


import androidx.appcompat.app.AppCompatActivity;

/**
 * 梁佳霖创建于：2018/10/8 13:48
 * 功能：Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected AppManager appManager = AppManager.getAppManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(setLayoutId());
        appManager.addActivity(this);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 从栈中移除activity
        appManager.finishActivity(this);
    }
    /**
     * 布局文件引入方法
     *
     * @return 布局资源
     */
    public abstract int setLayoutId();

    /**
     * 初始化控件方法
     */
    public abstract void initView();

    /**
     * 初始化数据方法
     */
    public abstract void initData();

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_back_users:
                finish();
                break;
            case R.id.user_list_back:
                finish();
                break;
        }
    }

    /**
     * 修改toast显示到中间位置
     *
     * @param message 需要展示的信息
     */
    public void showCenterToastCenter(String message) {
        LayoutInflater inflater = getLayoutInflater();
        LinearLayout linear = (LinearLayout) inflater.inflate(R.layout.layout_toast, null);
        TextView tvToast = linear.findViewById(R.id.tv_toast);
        tvToast.setText(message);
        Toast toast = new Toast(getApplicationContext());
        toast.setView(linear);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }


    /**
     * 设置标题,不包含右边完成按钮
     *
     * @param title 标题的文本
     */
    public void setTitle(String title) {
        TextView baseTitle = findViewById(R.id.teacher_details_users);
        baseTitle.setText(title);
    }

    /**
     * Toast 公共Toast方法
     *
     * @param message 需要展示的信息
     */
    public void showShortToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
