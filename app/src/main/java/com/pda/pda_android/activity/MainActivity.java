package com.pda.pda_android.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.broadcastreceive.MyBroadcastReceiver;
import com.pda.pda_android.db.Entry.UserCheckBean;
import com.pda.pda_android.db.dbutil.UserCheckDaoOpe;
import com.pda.pda_android.fragment.HomeFragment;
import com.pda.pda_android.fragment.MeFragment;
import com.pda.pda_android.fragment.UserFragment;
import com.pda.pda_android.service.RemindService;
import com.pda.pda_android.service.UsersCheckListService;
import com.pda.pda_android.service.UsersListService;

import java.util.List;

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
    private long firstTime=0;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        intentFilter = new IntentFilter(MainActivity.ACTION);   // 设置广播接收器的信息过滤器，
        myBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver, intentFilter);
        startService();
        vibrator = (Vibrator)this.getSystemService(this.VIBRATOR_SERVICE);
        bottom_navigation_bar = findViewById(R.id.bottom_navigation_bar);
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED);
        bottom_navigation_bar.addItem(new BottomNavigationItem(R.drawable.first_sele, getString(R.string.home_main_string)).setInactiveIconResource(R.drawable.first_nosele).setActiveColorResource(R.color.text_lan).setInActiveColorResource(R.color.text_huise))
                .addItem(new BottomNavigationItem(R.drawable.huanze_sele, getString(R.string.user_main_string)).setInactiveIconResource(R.drawable.huanze_nosele).setActiveColorResource(R.color.text_lan).setInActiveColorResource(R.color.text_huise))
                .addItem(new BottomNavigationItem(R.drawable.me_sele, getString(R.string.me_main_string)).setInactiveIconResource(R.drawable.me_nosele).setActiveColorResource(R.color.text_lan).setInActiveColorResource(R.color.text_huise))
                .setFirstSelectedPosition(0)
                .initialise();
        bottom_navigation_bar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * 打开APP就启动服务，开始从服务器请求数据
     */
    private void startService() {
        UsersListService.getConnet(this);
        UsersCheckListService.getConnet(this);
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
        UsersListService.stop(this);
        //停止由服务启动的循环
        Intent intent = new Intent(this, RemindService.class);
        Intent intent2 = new Intent(this, UsersListService.class);
        stopService(intent);
        stopService(intent2);
        super.onDestroy();
    }

    public static void goMainActivity(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){
            if (System.currentTimeMillis()-firstTime>2000){
                Toast.makeText(MainActivity.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                firstTime=System.currentTimeMillis();
            }else{
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
