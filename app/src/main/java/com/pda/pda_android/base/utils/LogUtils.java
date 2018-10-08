package com.pda.pda_android.base.utils;

import android.util.Log;

public class LogUtils {
    /**
     * 控制日志开关
     */
    private static boolean logSwitch = true;
       /**
        * @Author: DBJ
        * @Date: 2018/6/8 11:16
        * @Description:  Toast提示工具类
        *
        */
    public static void showLog(String message, String information){
        if (logSwitch){
            Log.e(message,information);
        }
    }
    public static void showLog(String information){
        if (!information.isEmpty())
            if (logSwitch){
                Log.e("dbj",information);
            }
    }
}
