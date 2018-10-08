package com.pda.pda_android.Base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * 梁佳霖创建于：2018/10/8 13:48
 * 功能：Activity基类
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(setLayoutId());
        initView();
        initData();
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
}
