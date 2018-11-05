package com.pda.pda_android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import com.google.gson.Gson;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.AssayDetailListBean;
import com.pda.pda_android.db.Entry.AssayDetailBean;
import com.pda.pda_android.db.dbutil.AssayDetailDaoOpe;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 梁佳霖创建于：2018/10/18 17:54
 * 功能：获取用户检验的服务
 */
public class UsersAssayDetailListService extends Service {
    private boolean pushthread = false;
    private static Context context;


    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.showLog("UsersAssayDetailListService", "onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.showLog("UsersAssayDetailListService", "onStartCommand");
        if (intent.getStringExtra("flags").equals("3")) {
            //判断当系统版本大于20，即超过Android5.0时，我们采用线程循环的方式请求。
            //当小于5.0时的系统则采用定时唤醒服务的方式执行循环
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentapiVersion > 20) {
                getPushThread();
            } else {
                handler.sendEmptyMessage(DOINTERNET);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    //循环请求的线程
    public void getPushThread() {
        pushthread = true;
        handler.sendEmptyMessage(DOINTERNET);
    }

    public static final int DOINTERNET = 1111; //发送网络请求
    public static final int DOINTERNETAGEN = 2222; //发送网络请求

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case DOINTERNET:
                    getHttp();
                    handler.sendEmptyMessageDelayed(DOINTERNETAGEN,1000 * 60 * 3);
                    break;
                case DOINTERNETAGEN:
                    getHttp();
                    handler.sendEmptyMessageDelayed(DOINTERNET,1000 * 60 * 3);
                    break;
            }
            super.handleMessage(msg);
        }
    };

        //请求网络获取数据
    private void getHttp() {

        OkHttpManager.getInstance().getRequest(context, ContentUrl.TestUrl_local + ContentUrl.getUsersAssayListDetail,
                new LoadCallBack<String>(context,false) {
                    @Override
                    protected void onFailure(Call call, IOException e) {
                        handler.removeMessages(DOINTERNET);
                    }

                    @Override
                    protected void onSuccess(Call call, Response response, String s) throws IOException {
                        if (s.contains("\"response\": \"ok\"")) {
                            LogUtils.showLog(ContentUrl.getUsersAssayListDetail+"----患者检验列表详情同步数据", s);
                            AssayDetailDaoOpe.deleteAllData(context);
                            Gson gson = new Gson();
                            AssayDetailListBean usersCheckListBean = gson.fromJson(s, AssayDetailListBean.class);
                            List<AssayDetailBean> userCheckBeans = usersCheckListBean.getData();
                            AssayDetailDaoOpe.insertData(context, userCheckBeans);
                        }else{
                            handler.removeMessages(DOINTERNET);
                        }
                    }
                });
    }


    @Override
    public void onDestroy() {
        pushthread = false;
        LogUtils.showLog("UsersAssayDetailListService", "onDestroy");
        super.onDestroy();
    }

    //启动服务和定时器
    public static void getConnet(Context mContext) {
        try {
            context = mContext;
            Intent intent = new Intent(mContext, UsersAssayDetailListService.class);
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
        Intent intent = new Intent(mContext, UsersAssayDetailListService.class);
        PendingIntent pIntent = PendingIntent.getService(mContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) mContext
                .getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pIntent);
    }
}
