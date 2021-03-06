package com.pda.pda_android.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.broadcastreceive.MyBroadcastReceiver;
import com.pda.pda_android.fragment.HomeFragment;
import com.pda.pda_android.fragment.MeFragment;
import com.pda.pda_android.fragment.UserFragment;
import com.pda.pda_android.service.PostCacheService;
import com.pda.pda_android.service.RemindService;
import com.pda.pda_android.service.UsersAssayDetailListService;
import com.pda.pda_android.service.UsersAssayListService;
import com.pda.pda_android.service.UsersCheckListService;
import com.pda.pda_android.service.UsersListService;
import com.pda.pda_android.service.UsersSsxxListService;

/**
 * 梁佳霖创建于：2018/10/10 17:48
 * 功能：承载着fragmentMainactivity
 */
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener{

    private static final int FINISHMYSELF = 12221;
    private BottomNavigationBar bottom_navigation_bar;
    private HomeFragment mHomeFragment;
    private UserFragment userFragment;
    private MeFragment meFragment;
    private Vibrator vibrator;

    private long firstTime=0;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        startService();
        vibrator = (Vibrator)this.getSystemService(this.VIBRATOR_SERVICE);
        bottom_navigation_bar = findViewById(R.id.bottom_navigation_bar);
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED);
        bottom_navigation_bar.addItem(new BottomNavigationItem(R.mipmap.first_sele, getString(R.string.home_main_string)).setInactiveIconResource(R.mipmap.first_nosele).setActiveColorResource(R.color.text_lan).setInActiveColorResource(R.color.text_huise))
                .addItem(new BottomNavigationItem(R.mipmap.huanze_sele, getString(R.string.user_main_string)).setInactiveIconResource(R.mipmap.huanze_nosele).setActiveColorResource(R.color.text_lan).setInActiveColorResource(R.color.text_huise))
                .addItem(new BottomNavigationItem(R.mipmap.me_sele, getString(R.string.me_main_string)).setInactiveIconResource(R.mipmap.me_nosele).setActiveColorResource(R.color.text_lan).setInActiveColorResource(R.color.text_huise))
                .setFirstSelectedPosition(0)
                .initialise();
        bottom_navigation_bar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case FINISHMYSELF:
                    MainActivity.this.finish();
                break;
            }
        }
    };


    /**
     * 打开APP就启动服务，开始从服务器请求数据
     */
    private void startService() {
        UsersListService.getConnet(this);
//        UsersCheckListService.getConnet(this);
//        UsersSsxxListService.getConnet(this);
//        UsersAssayListService.getConnet(this);
//        UsersAssayDetailListService.getConnet(this);
        PostCacheService.getConnet(this);
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
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        HomeFragment homeFragment = mHomeFragment.newInstance(getString(R.string.item_home));
        transaction.replace(R.id.sub_content, homeFragment).commit();

    }
    @Override
    public void onTabSelected(int position) {
        LogUtils.showLog("点击的条目",position+"");
        androidx.fragment.app.FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();

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
                //点击我的Fragment
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
