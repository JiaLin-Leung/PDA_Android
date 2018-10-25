package com.pda.pda_android.activity.welcome;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.SpUtils;

/**
 * 梁佳霖创建于：2018/10/25 14:56
 * 功能：请求基础数据，创建手机本地数据库，数据表
 * 逻辑：首次安装进来：1，创建数据库和数据表  2，到登录页面登录成功之后开启服务进行数据轮询请求和上次未提交成功数据的提交操作  3，在服务中进行数据写入本地数据库操作
 * 非第一次安装：1，开启服务进行数据轮询请求和上次未提交成功数据的提交操作  2，在服务中进行数据写入本地数据库操作
 */
public class WelcomeActivity extends BaseActivity {

    private SpUtils spManager;

    /**
     * 是否是第一次登录的标记
     */
    private int is_frist;

    @Override
    public int setLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        spManager = SpUtils.getInstance(WelcomeActivity.this);
        is_frist = spManager.getInt("is_frist",0);
    }

    @Override
    public void initData() {
        if(is_frist == 0){ //第一次安装进来
            
        }else{ //不是第一次进来的

        }
    }
}
