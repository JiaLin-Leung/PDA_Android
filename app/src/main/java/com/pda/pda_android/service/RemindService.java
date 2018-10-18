package com.pda.pda_android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Base64;

import com.pda.pda_android.activity.LoginActivity;
import com.pda.pda_android.activity.MainActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 梁佳霖创建于：2018/10/18 17:54
 * 功能：接收提醒的服务
 */
public class RemindService extends Service {
    private boolean pushthread = false;
    public RemindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.showLog("RemindService", "onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.showLog("RemindService", "onStartCommand");
        if (intent.getStringExtra("flags").equals("3")) {
            //判断当系统版本大于20，即超过Android5.0时，我们采用线程循环的方式请求。
            //当小于5.0时的系统则采用定时唤醒服务的方式执行循环
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentapiVersion > 20) {
                getPushThread();
            } else {
                getHttp();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    //循环请求的线程
    public void getPushThread() {
        pushthread = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (pushthread) {
                    try {
                        Thread.sleep(3000);
                        getHttp();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    //请求网络获取数据
    private void getHttp() {
        String url = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getNewsContent&id=1";
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                getHttp();
            }

            @Override
            public void onResponse(Call call, String s) {
                LogUtils.showLog("11111111",s);
            }
        });
    }
    //请求网络获取数据
//    private void getHttp() {
//        String accountTxtBase64 = Base64.encodeToString("15136170717".getBytes(), Base64.DEFAULT);
//        String passwTxtTxtBase64 = Base64.encodeToString("111111".getBytes(), Base64.DEFAULT);
//        Map<String, String> params = new HashMap<>(); //提交数据包
//        params.put("phone",accountTxtBase64 ); //将姓名参数添加到数据包
//        params.put("password", passwTxtTxtBase64); //将密码参数添加到数据包
//        params.put("user_type", 1 + ""); //用户类型: 1-学生, 3-教师
//        OkHttpManager.getInstance().postRequest(, ContentUrl.testUrl + ContentUrl.stu_login, new LoadCallBack<String>(LoginActivity.this) {
//            @Override
//            protected void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            protected void onSuccess(Call call, Response response, String s) throws IOException {
//                LogUtils.showLog("信息信息信息信息",s);
//                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        },params);
//    }

    @Override
    public void onDestroy() {
        pushthread = false;
        LogUtils.showLog("RemindService", "onDestroy");
        super.onDestroy();
    }

    //启动服务和定时器
    public static void getConnet(Context mContext) {
        try {
            Intent intent = new Intent(mContext, RemindService.class);
            intent.putExtra("flags", "3");
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentapiVersion > 20) {
                //一般的启动服务的方式
                mContext.startService(intent);
            } else {
                //定时唤醒服务的启动方式
                PendingIntent pIntent = PendingIntent.getService(mContext, 0,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) mContext
                        .getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis(), 3000, pIntent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //停止由AlarmManager启动的循环
    public static void stop(Context mContext) {
        Intent intent = new Intent(mContext, RemindService.class);
        PendingIntent pIntent = PendingIntent.getService(mContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) mContext
                .getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pIntent);
    }
}
