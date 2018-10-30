package com.pda.pda_android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.google.gson.Gson;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.UserBean;
import com.pda.pda_android.bean.UsersListBean;
import com.pda.pda_android.db.dbutil.UserDaoOpe;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * 梁佳霖创建于：2018/10/18 17:54
 * 功能：获取用户列表的服务
 */
public class UsersListService extends Service {
    private boolean pushthread = false;
    private static Context context;

    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.showLog("UsersListService", "onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.showLog("UsersListService", "onStartCommand");
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
                        Thread.sleep(3000);  //正式使用3--5分钟，目前是3秒钟
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
        String url = ContentUrl.TestUrl_local+ContentUrl.getUsersList;
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                getHttp();
            }

            @Override
            public void onResponse(Call call, String s) {
                UserDaoOpe.deleteAllData(context);
                Gson gson = new Gson();
                UsersListBean usersListBeanList = gson.fromJson(s,UsersListBean.class);
                List<UserBean> userBeans = usersListBeanList.getData();
                int a = usersListBeanList.getData().size();
                UserDaoOpe.insertData(context,userBeans);
                Long bbb = 123123L;
                for (int i = 0;i < a;i++){
                    userBeans.get(i).setId(bbb+i+100);
                    UserDaoOpe.insertData(context,userBeans.get(i));
                }

            }
        });
    }

    @Override
    public void onDestroy() {
        pushthread = false;
        LogUtils.showLog("UsersListService", "onDestroy");
        super.onDestroy();
    }

    //启动服务和定时器
    public static void getConnet(Context mContext) {
        try {
            context = mContext;
            Intent intent = new Intent(mContext, UsersListService.class);
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
        Intent intent = new Intent(mContext, UsersListService.class);
        PendingIntent pIntent = PendingIntent.getService(mContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) mContext
                .getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pIntent);
    }
}
