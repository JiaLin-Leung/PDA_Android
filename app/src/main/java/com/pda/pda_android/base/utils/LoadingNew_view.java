package com.pda.pda_android.base.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.pda.pda_android.R;

/**
 * 梁佳霖创建于：2018/10/8 14:12
 * 功能：
 */
public class LoadingNew_view extends ProgressDialog {

    /**
     * 构造函数
     * @param context 上下文
     */
    public LoadingNew_view(Context context) {
        super(context);
    }
    public LoadingNew_view(Context context, int theme) {
        super(context, theme);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }
    /**
     * 开始loading
     */
    @Override
    public void show() {//开启
        super.show();
    }
    /**
     * 初始化加载框
     * @param context 上下文
     */
    private void init(Context context) {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.newloading);//loading的xml文件
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }
    @Override
    /**
     * 关闭loading
     */
    public void dismiss() {//关闭
        super.dismiss();
    }
}
