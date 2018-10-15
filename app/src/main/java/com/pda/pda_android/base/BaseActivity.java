package com.pda.pda_android.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pda.pda_android.R;

/**
 * 梁佳霖创建于：2018/10/8 13:48
 * 功能：Activity基类
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {

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

    @Override
    public void onClick(View view) {

    }
    /**
     * 设置标题,不包含右边完成按钮
     *
     * @param title 标题的文本
     */
    public void setTitle(String title) {
        TextView baseTitle = findViewById(R.id.teacher_details);
        baseTitle.setText(title);
        initBack();
    }

    /**
     * 设置标题,不包含右边完成按钮
     * @param title1 中间标题
     * @param title2 右边标题
     */
    public void setTitleWithFinish(String title1,String title2) {
        TextView baseTitle = findViewById(R.id.teacher_details);
        TextView tv_finish = findViewById(R.id.tv_finish);
        tv_finish.setVisibility(View.VISIBLE);
        baseTitle.setText(title1);
        tv_finish.setText(title2);
        initBack();
    }



    private void initBack() {
        ImageView ivBack = findViewById(R.id.activity_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
