package com.pda.pda_android.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;


/**
 * Created by LKZ on 2017/9/19.
 */

public class Util {
    private static Context context;
    private static Toast mToast;

    private Util() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Util.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getAPPContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }

    /**
     * View获取Activity的工具
     *
     * @param view view
     * @return Activity
     */
    public static
    @NonNull
    Activity getAttachActivity(View view) {
        Context context = view.getContext();

        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }

        throw new IllegalStateException("View " + view + " is not attached to an Activity");
    }

    /**
     * 判断App是否是Debug版本
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug() {
        String packageName = context.getPackageName();
        if (packageName == null || packageName.trim().length() == 0)
            return false;
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(context.getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * dp转化成px
     *
     * @param dpValue
     * @return
     */
    public static int dp2px(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue,
                Resources.getSystem().getDisplayMetrics());
    }

    /**
     * sp转化成px
     *
     * @param spValue
     * @return
     */
    public static int sp2px(int spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue,
                Resources.getSystem().getDisplayMetrics());
    }

    /**
     * 显示Toast
     *
     * @param content
     */
    public static void showToast(CharSequence content) {
        if (TextUtils.isEmpty(content))
            return;
        if (mToast == null) {
            mToast = Toast.makeText(Util.getAPPContext(), content, Toast.LENGTH_SHORT);
//            TextView tv = mToast.getView().findViewById(android.R.id.message);
//            tv.setTextSize(16);
        } else {
            mToast.setText(content);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 取消Toast
     */
    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }

    /**
     * @return 版本名
     */
    public static String getVersionName() {
        try {
            PackageManager manager = Util.getAPPContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(Util.getAPPContext().getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "找不到版本号";
        }
    }

    /**
     * @return 版本号
     */
    public static int getVersionCode() {
        try {
            PackageManager manager = Util.getAPPContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(Util.getAPPContext().getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取App名
     *
     * @return
     */
    public static String getAppName() {
        String applicationName = "JYW_";
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = Util.getAPPContext().getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(Util.getAPPContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        applicationName =
                (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }


    /**
     * 设置文字大小和颜色
     *
     * @param content
     * @param color
     * @param size
     * @return
     */
    public static SpannableStringBuilder setTextSizeAndColor(String content, int color, int size) {
        if (TextUtils.isEmpty(content))
            return new SpannableStringBuilder("");
        SpannableStringBuilder builder = new SpannableStringBuilder(content);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(getAPPContext().getResources().getColor(color));
        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(sp2px(size));
        builder.setSpan(colorSpan, 0, content.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(sizeSpan, 0, content.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }

    private static long mLastClickTime = 0;

    /**
     * 判断是否是多次点击
     *
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - mLastClickTime;
        if (0 < timeD && timeD < 1000) {
            return true;
        }
        mLastClickTime = time;
        return false;
    }

    /**
     * 正则判断是否满足手机格式
     *
     * @param phone
     * @return
     */
    public static boolean isPhoneFormat(String phone) {
        if (TextUtils.isEmpty(phone) || phone.length() != 11)
            return false;
        String regex = "(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 简单的将状态栏变成白底黑字，只适用于6.0以上
     * (如果遇到特殊页面，请再做特殊处理，在自己的activity中将这个覆盖掉即可)
     *
     * @param activity
     */
    public static void setLightStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.WHITE);
        }
    }


    /**
     * 强制隐藏键盘
     *
     * @param context
     */
    public static void hideKeyBoard(View v, Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /**
     * 弹出键盘
     *
     * @param v
     */
    public static void showInputMethodBoard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInputFromInputMethod(v.getWindowToken(), 0);
        imm.showSoftInput(v, InputMethodManager.SHOW_FORCED);
    }


    /**
     * 禁止EditText输入空格
     *
     * @param editText
     */
    public static void setEditTextInhibitInputSpace(int maxLength, EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ")) {
                    return "";
                } else
                    return null;
            }
        };
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength), filter});
    }

    /**
     * 获取手机系统版本号
     *
     * @return
     */
    public static String getAndroidVersion() {
        String version_release = Build.VERSION.RELEASE;
        return version_release;
    }

    /**
     * 获取手机设备名称
     *
     * @param context
     * @return
     */
    public static String getAndroidName(Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return androidId;
    }

    /**
     * 获取设备序列号
     *
     * @param context
     * @return
     */
    public static String getDeviceISN(Context context) {

        String device_model = Build.MODEL;
        return device_model;
    }

    /**
     * 获取设备型号UUID
     *
     * @param context
     * @return
     */
    public static String getDeviceType(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return "";
        }
        String deviceId;
        if (tm != null) {
            deviceId = tm.getDeviceId();
        }else {
            deviceId = "";
        }
        return deviceId;
    }

    /**
     * 获取app当前版本号
     *
     * @param context
     * @return
     */
    public static String getAppVersion(Context context) {
        String version = "";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(),
                    0);
            version = info.versionName;


        } catch (Exception e) {
            e.printStackTrace();

        }
        return version;
    }

    /**
     * 获取app当前版本号
     *
     * @param context
     * @return
     */
    public static String getVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo;
        String versionCode = "";
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionCode = packageInfo.versionCode + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }


    /**
     * 获取app当前版本号
     *
     * @param context
     * @return
     */
    public static int getAppVersionCode(Context context, String packAgeName) {
        int version = 1;
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(packAgeName,
                    0);
            version = info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return version;
    }

    //图片压缩
    public static String compressImage(String filePath, String targetPath,
                                       int quality) {
        Bitmap bm = getSmallBitmap(filePath);// 获取一定尺寸的图片
        int degree = readPictureDegree(filePath);// 获取相片拍摄角度
        if (degree != 0) {// 旋转照片角度，防止头像横着显示
            bm = rotateBitmap(bm, degree);
        }
        File outputFile = new File(targetPath);
        try {
            if (!outputFile.exists()) {
                outputFile.getParentFile().mkdirs();
                // outputFile.createNewFile();
            } else {
                outputFile.delete();
            }
            FileOutputStream out = new FileOutputStream(outputFile);
            bm.compress(Bitmap.CompressFormat.JPEG, quality, out);
            if (out != null) {
                out.close();
            }
        } catch (Exception e) {
        }
        return outputFile.getPath();
    }

    /**
     * 旋转照片
     *
     * @param bitmap
     * @param degress
     * @return
     */
    public static Bitmap rotateBitmap(Bitmap bitmap, int degress) {
        if (bitmap != null) {
            Matrix m = new Matrix();
            m.postRotate(degress);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                    bitmap.getHeight(), m, true);
            return bitmap;
        }
        return bitmap;
    }

    /**
     * 根据路径获得图片信息并按比例压缩，返回bitmap
     */
    public static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;// 只解析图片边沿，获取宽高
        BitmapFactory.decodeFile(filePath, options);
        // 计算缩放比
        options.inSampleSize = calculateInSampleSize(options, 480, 800);
        // 完整解析图片返回bitmap
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    /**
     * 获取照片角度
     *
     * @param path
     * @return
     */
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 计算缩放比
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }


    /**
     * 判断按钮是否可点击
     */
    public static void bt_isselecter(Button bt, EditText et1, EditText et2) {
        if (!TextUtils.isEmpty(et1.getText().toString()) && !TextUtils.isEmpty(et2.getText().toString())) {
            bt.setBackgroundResource(R.drawable.login_bt_seleter);
            bt.setTextColor(context.getResources().getColor(R.color.white));
            bt.setClickable(true);
            bt.setEnabled(true);
        } else {
            bt.setBackgroundResource(R.drawable.login_bt_noseleter);
            bt.setTextColor(context.getResources().getColor(R.color.bt_noseleter_text));
            bt.setClickable(false);
            bt.setEnabled(false);
        }
    }

    /**
     * 判断按钮是否可点击
     */
    public static void bt_isselecter(Button bt, EditText et1) {
        if (!TextUtils.isEmpty(et1.getText().toString())) {
            bt.setBackgroundResource(R.drawable.login_bt_seleter);
            bt.setTextColor(context.getResources().getColor(R.color.white));
            bt.setClickable(true);
            bt.setEnabled(true);
        } else {
            bt.setBackgroundResource(R.drawable.login_bt_noseleter);
            bt.setTextColor(context.getResources().getColor(R.color.bt_noseleter_text));
            bt.setClickable(false);
            bt.setEnabled(false);
        }
    }

    /**
     * 判定输入汉字
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static boolean isChineseChar(char c) {
        try {
            return String.valueOf(c).getBytes("UTF-8").length > 1;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 获得当前时间
    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH：mm：ss");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        return formatter.format(curDate);
    }

    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }
}
