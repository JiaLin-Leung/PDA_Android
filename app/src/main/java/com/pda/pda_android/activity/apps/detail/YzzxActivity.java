package com.pda.pda_android.activity.apps.detail;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.fragment.jcjy.JcFragment;
import com.pda.pda_android.fragment.jcjy.JyFragment;
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
                Util.setIndicatorWidth(tablayout,100);
            }
        });
        users_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    List<Fragment> fragmentList = new ArrayList<>();
    String[] titles = {"输液", "注射","口服","处置","其他"};
    private class TabAdapter extends FragmentPagerAdapter {


        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new YzzxsyFragment());
            fragmentList.add(new YzzxzsFragment());
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
}
