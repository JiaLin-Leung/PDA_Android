package com.pda.pda_android.activity.apps.detail;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.UsersListActivity;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.SpUtils;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.dbutil.UserDaoOpe;
import com.pda.pda_android.fragment.jcjy.JcFragment;
import com.pda.pda_android.fragment.jcjy.JyFragment;
import com.pda.pda_android.fragment.yzzx.YzzxczFragment;
import com.pda.pda_android.fragment.yzzx.YzzxkfFragment;
import com.pda.pda_android.fragment.yzzx.YzzxqtFragment;
import com.pda.pda_android.fragment.yzzx.YzzxsyFragment;
import com.pda.pda_android.fragment.yzzx.YzzxzsFragment;
import com.pda.pda_android.utils.Util;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class YzzxActivity extends BaseActivity {
    private TabLayout tablayout;
    private ViewPager viewpager;
    private TextView user_info;
    private ImageView users_all,user_name_up,user_name_down,title_back;
    private FragmentManager fragmentManager;
    private String cw,name,Patient_no;
    private List<UserBean> user_list;
    private UserBean userBean_positon;
    private int position;
    @Override
    public int setLayoutId() {
        return R.layout.activity_yzzx;
    }

    @Override
    public void initView() {
        tablayout = findViewById(R.id.tablayout_yzzx);
        viewpager = findViewById(R.id.viewpager_yzzx);
        users_all=findViewById(R.id.users_all);
        user_name_down=findViewById(R.id.user_name_down);
        user_name_up=findViewById(R.id.user_name_up);
        title_back = findViewById(R.id.title_back);
        fragmentManager=getSupportFragmentManager();
        user_info=findViewById(R.id.user_info);
        tablayout.post(new Runnable() {
            @Override
            public void run() {
                //设置tablayout下标线
                Util.setIndicatorWidth(tablayout,10);
            }
        });
        viewpager.setAdapter(new TabAdapter(fragmentManager));
        tablayout.setupWithViewPager(viewpager);
        users_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users_all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UsersListActivity.go_UsersListActivity(YzzxActivity.this,"YZZX");
                        YzzxActivity.this.finish();
                    }
                });
            }
        });
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        position = getIntent().getIntExtra("position",0);
        user_list = UserDaoOpe.queryAll(YzzxActivity.this);
        String type = getIntent().getStringExtra("type");
        if (!TextUtils.isEmpty(type) && type.equals("1")){//说明从首页进来的，已经设置过患者
            String user_record_no = SpUtils.getInstance(YzzxActivity.this).getString("user_record_no","");
            List<UserBean> userBeans = UserDaoOpe.queryRecord_no(YzzxActivity.this,user_record_no);
            userBean_positon = userBeans.get(0);
            position = user_list.indexOf(userBean_positon);
        }else{//说明从患者列表过来的，没有设置过患者
            position = getIntent().getIntExtra("position",0);
            userBean_positon = user_list.get(position);
        }
        cw=userBean_positon.getRecord_no();
        name=userBean_positon.getBed_no()+"  "+userBean_positon.getPatient_name();
        Patient_no=userBean_positon.getPatient_no();
        user_info.setText(userBean_positon.getBed_no()+"  "+userBean_positon.getPatient_name());
    }
    List<Fragment> fragmentList = new ArrayList<>();
    String[] titles = {"输液", "注射","口服","处置","其他"};
    private class TabAdapter extends FragmentPagerAdapter {

        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new YzzxsyFragment());
            fragmentList.add(new YzzxzsFragment());
            fragmentList.add(new YzzxkfFragment());
            fragmentList.add(new YzzxczFragment());
            fragmentList.add(new YzzxqtFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

    }
    @Override
    public void initData() {
    }
//    public View getTabItemView(int position) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_layout_item, null);
//        TextView textView = (TextView) view.findViewById(R.id.textview);
//        textView.setText(mPageTitleList.get(position));
//
//        View target = view.findViewById(R.id.badgeview_target);
//
//        BadgeView badgeView = new BadgeView(mContext);
//        badgeView.setTargetView(target);
//        badgeView.setBadgeMargin(0, 6, 10, 0);
//        badgeView.setTextSize(10);
//        badgeView.setText(formatBadgeNumber(mBadgeCountList.get(position)));
//
//        return view;
//    }
//
//    public static String formatBadgeNumber(int value) {
//        if (value <= 0) {
//            return null;
//        }
//
//        if (value < 100) {
//            // equivalent to String#valueOf(int);
//            return Integer.toString(value);
//        }
//
//        // my own policy
//        return "99+";
//    }
}
