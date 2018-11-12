package com.pda.pda_android.base;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.LoginActivity;
import com.pda.pda_android.base.utils.SpUtils;

/**
 * 梁佳霖创建于：2018/10/15 15:54
 * 功能：
 */
public abstract class BaseFragment extends androidx.fragment.app.Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getlayout(), container, false);
        initView(view);
        initData();
        return view;
    }

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化控件
     * @param view
     */
    public abstract void initView(View view);

    /**
     * 设置页面xml
     * @return
     */
    public abstract int getlayout();


    @Override
    public void onClick(View view) {

    }

    /**
     * 升级对话框
     * @param context 上下文
     * @param flag 升级标记1 非强制 2 强制（无法取消）
     * @param o 升级对象
     */
    public void showVersionDialog(final Context context, Object o ,int flag) {
        final AlertDialog dialog = new AlertDialog.Builder(context, R.style.MyDialog).setCancelable(false).create();
        dialog.show();
        Window window = dialog.getWindow();
        assert window != null;
        window.setGravity(Gravity.CENTER);  //此处可以设置dialog显示的位置
        View view = View.inflate(context, R.layout.dialog_version, null);
        window.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        TextView tvContent = view.findViewById(R.id.tv_content);
        TextView tvCancel = view.findViewById(R.id.cancel);
        TextView tvOk = view.findViewById(R.id.ok);
        TextView tv_title = view.findViewById(R.id.tv_title);
        View line = view.findViewById(R.id.line);
        tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (flag == 2) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            tvCancel.setVisibility(View.GONE);
            line.setVisibility(View.GONE);
        }
//        tv_title.setText(checkVersonBean.getData().getTitle());
//        tvContent.setText(checkVersonBean.getData().getContent());
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SpUtils.getInstance(getActivity()).save("currtime", System.currentTimeMillis());
                dialog.dismiss();
            }
        });

//        tvOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
////                Toast.makeText(context,"开始更新",Toast.LENGTH_SHORT).show();
//                progress(checkVersonBean);
//            }
//        });
    }
    /**
     * 注销登录的方法
     */
    public void LogOut(Context context) {
        final AlertDialog dialog = new AlertDialog.Builder(context, R.style.MyDialog).setCancelable(true).create();
        dialog.show();
        Window window = dialog.getWindow();
        assert window != null;
        window.setGravity(Gravity.CENTER);  //此处可以设置dialog显示的位置
        View view = View.inflate(context, R.layout.dialog_quit, null);
        window.setContentView(view);

        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvContent = view.findViewById(R.id.tv_content);
        TextView tvCancel = view.findViewById(R.id.cancel);
        TextView tvOk = view.findViewById(R.id.ok);
        tvTitle.setText("提示");
        tvContent.setText("确定退出登录吗？");
        tvCancel.setText("取消");
        tvOk.setText("确定");
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                AppManager.getAppManager().finishAllActivity();
                Intent intent = new Intent();
                intent.setClass(getActivity(),LoginActivity.class);
                startActivity(intent);
                SpUtils.getInstance(getActivity()).clear(getActivity());
            }
        });
    }
    /**
     * 修改toast显示到中间位置
     *
     * @param message 需要展示的信息
     */
    public void showCenterToastCenter(String message) {
        try{
            LayoutInflater inflater = getLayoutInflater();
            LinearLayout linear = (LinearLayout) inflater.inflate(R.layout.layout_toast, null);
            TextView tvToast = linear.findViewById(R.id.tv_toast);
            tvToast.setText(message);
            Toast toast = new Toast(getActivity());
            toast.setView(linear);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
