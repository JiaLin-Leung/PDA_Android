package com.pda.pda_android.broadcastreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.pda.pda_android.base.utils.LogUtils;

/**
 * 梁佳霖创建于：2018/10/22 19:00
 * 功能：获取PDA发送的广播
 * 备注：PDA的信息全部在data字段里面
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("data");
        LogUtils.showLog("111111",name);
        Toast.makeText(context, "动态注册广播接收器接收到的广播信息", Toast.LENGTH_SHORT).show();
    }
}
