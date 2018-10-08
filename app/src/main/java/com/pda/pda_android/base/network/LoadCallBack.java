package com.pda.pda_android.base.network;

import android.content.Context;

import com.pda.pda_android.R;
import com.pda.pda_android.base.utils.LoadingNew_view;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 梁佳霖创建于：2018/10/8 14:10
 * 功能：
 */
public abstract class LoadCallBack<T> extends BaseCallBack<T> {

    private Context context;
    private boolean showDialog = true;
    private LoadingNew_view dialog;
    public LoadCallBack(Context context) {
        this.context=context;
        dialog=new LoadingNew_view(context, R.style.CustomDialog);
        showDialog();
    }

    public LoadCallBack(Context context,boolean showDialog) {
        this.context = context;
        this.showDialog = showDialog;
        dialog=new LoadingNew_view(context, R.style.CustomDialog);
        if (showDialog) {
            showDialog();
        }
    }
    //显示进度条
    private void showDialog() {
        if (dialog!=null){
            dialog.show();
        }
    }

    private void hideDialog() {
        if (dialog != null) {
            //隐藏进度条
            dialog.dismiss();
        }
    }



    @Override
    protected void OnRequestBefore(Request request) {
        if (showDialog){
            showDialog();
        }
    }

    @Override
    protected void onResponse(Response response) {
        hideDialog();
    }

    @Override
    protected void onEror(Call call, int statusCode, Exception e) {

    }

    @Override
    protected void inProgress(int progress, long total, int id) {

    }

}
