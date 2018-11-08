package com.pda.pda_android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pda.pda_android.activity.LoginActivity;
import com.pda.pda_android.activity.MainActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.base.utils.SpUtils;
import com.pda.pda_android.bean.LoginBean;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.db.Entry.PostCacheBean;
import com.pda.pda_android.db.Entry.SsxxBean;
import com.pda.pda_android.db.Entry.SsxxListBean;
import com.pda.pda_android.db.dbutil.PostCacheDaoOpe;
import com.pda.pda_android.db.dbutil.SsxxBeanOpe;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 梁佳霖创建于：2018/10/18 17:54
 * 功能：获取用户手术信息的服务
 */
public class PostCacheService extends Service {
    private boolean pushthread = false;
    private static Context context;
    private PostCacheBean postCacheBean;

    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.showLog("提交缓存服务开启！", "onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.showLog("PostCacheService", "onStartCommand");
        if (intent != null) {
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
                    serchCache();
                    handler.sendEmptyMessageDelayed(DOINTERNETAGEN,1000 * 3);
                    break;
                case DOINTERNETAGEN:
                    serchCache();
                    handler.sendEmptyMessageDelayed(DOINTERNET,1000 * 3);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    /**
     * 查询本地是否有缓存待提交的数据
     */
    private void serchCache() {

        List<PostCacheBean> postCacheBeanList = PostCacheDaoOpe.queryAll(context);
        LogUtils.showLog("缓存数据有----"+postCacheBeanList.size()+"条");
        for (int a = 0;a<postCacheBeanList.size();a++){
            postCacheBean = postCacheBeanList.get(a);
            HashMap<String, String> hashMap=JSON.parseObject(postCacheBean.getParameter(), HashMap.class);
            getHttp(postCacheBeanList.get(a).getUrl(),hashMap);
        }
    }

    //请求网络获取数据
    private void getHttp(String url,Map params) {

        OkHttpManager.getInstance().postRequest(context, url, new LoadCallBack<String>(context,false) {
            @Override
            protected void onFailure(Call call, IOException e) {

            }
            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                if (s.contains("\"response\": \"ok\"")){
                    PostCacheDaoOpe.deleteByKeyData(context,postCacheBean.getId());
                }
            }
        },params);
    }


    @Override
    public void onDestroy() {
        pushthread = false;
        LogUtils.showLog("PostCacheService", "onDestroy");
        super.onDestroy();
    }

    //启动服务和定时器
    public static void getConnet(Context mContext) {
        try {
            context = mContext;
            Intent intent = new Intent(mContext, PostCacheService.class);
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
        Intent intent = new Intent(mContext, PostCacheService.class);
        PendingIntent pIntent = PendingIntent.getService(mContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) mContext
                .getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pIntent);
    }
}
