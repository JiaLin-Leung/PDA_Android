package com.pda.pda_android.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Vibrator;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.broadcastreceive.MyBroadcastReceiver;
import com.pda.pda_android.fragment.HomeFragment;
import com.pda.pda_android.fragment.MeFragment;
import com.pda.pda_android.fragment.UserFragment;
import com.pda.pda_android.service.RemindService;

/**
 * 梁佳霖创建于：2018/10/10 17:48
 * 功能：承载着fragmentMainactivity
 */
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener{

    private BottomNavigationBar bottom_navigation_bar;
    private HomeFragment mHomeFragment;
    private UserFragment userFragment;
    private MeFragment meFragment;
    private Vibrator vibrator;
    private MyBroadcastReceiver myBroadcastReceiver = null;
    private IntentFilter intentFilter;
    private static String ACTION = "com.scanner.broadcast";//PDA广播标记

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        intentFilter = new IntentFilter(MainActivity.ACTION);   // 设置广播接收器的信息过滤器，
        myBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver, intentFilter);
        RemindService.getConnet(this);
        vibrator = (Vibrator)this.getSystemService(this.VIBRATOR_SERVICE);
        bottom_navigation_bar = findViewById(R.id.bottom_navigation_bar);
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED);
        bottom_navigation_bar.addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, getString(R.string.home_main_string)).setInactiveIconResource(R.drawable.ic_launcher_background).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, getString(R.string.user_main_string)).setInactiveIconResource(R.drawable.ic_launcher_background).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_background, getString(R.string.me_main_string)).setInactiveIconResource(R.drawable.ic_launcher_background).setActiveColorResource(R.color.colorAccent).setInActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();
        bottom_navigation_bar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    @Override
    public void initData() {

    }

    /**
     * set the default fagment
     * <p>
     * the content id should not be same with the parent content id
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        HomeFragment homeFragment = mHomeFragment.newInstance(getString(R.string.item_home));
        transaction.replace(R.id.sub_content, homeFragment).commit();

    }
    @Override
    public void onTabSelected(int position) {
        LogUtils.showLog("点击的条目",position+"");
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
//                vibrator.vibrate(100);
                //点击主页Fragment
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance(getString(R.string.item_home));
                }
                beginTransaction.replace(R.id.sub_content, mHomeFragment);
                break;
            case 1:
//                vibrator.vibrate(100);
                //点击患者Fragment
                if (userFragment == null) {
                    userFragment = UserFragment.newInstance(getString(R.string.item_home));
                }
                beginTransaction.replace(R.id.sub_content, userFragment);
                break;
            case 2:
//                vibrator.vibrate(100);
                //点击患者Fragment
                if (meFragment == null) {
                    meFragment = MeFragment.newInstance(getString(R.string.item_home));
                }
                beginTransaction.replace(R.id.sub_content, meFragment);
                break;
        }
        beginTransaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(myBroadcastReceiver); //页面生命结束之后注销广播
        RemindService.stop(this);
        //停止由服务启动的循环
        Intent intent = new Intent(this, RemindService.class);
        stopService(intent);
        super.onDestroy();
    }

    public static void goMainActivity(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
}
