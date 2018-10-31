package com.pda.pda_android.activity.apps;



import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.fragment.JcFragment;
import com.pda.pda_android.fragment.JyFragment;
import com.pda.pda_android.utils.Util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class JcjyListActivity extends BaseActivity {
    TabLayout tablayout;
    ViewPager viewpager;
    TextView teacher_details_users;
    @Override
    public int setLayoutId() {
        return R.layout.activity_jcjy_list;
    }

    /**
     * 设置下划线宽度
     * @param tabLayout
     * @param margin
     */
    public void setIndicatorWidth(@NonNull final TabLayout tabLayout, final int margin) {
    tabLayout.post(new Runnable() {
        @Override
        public void run() {
            try {
                // 拿到tabLayout的slidingTabIndicator属性
                Field slidingTabIndicatorField = tabLayout.getClass().getDeclaredField("slidingTabIndicator");
                slidingTabIndicatorField.setAccessible(true);
                LinearLayout mTabStrip = (LinearLayout) slidingTabIndicatorField.get(tabLayout);
                for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                    View tabView = mTabStrip.getChildAt(i);
                    //拿到tabView的mTextView属性
                    Field textViewField = tabView.getClass().getDeclaredField("textView");
                    textViewField.setAccessible(true);
                    TextView mTextView = (TextView) textViewField.get(tabView);
                    tabView.setPadding(0, 0, 0, 0);
                    // 因为想要的效果是字多宽线就多宽，所以测量mTextView的宽度
                    int width = mTextView.getWidth();
                    if (width == 0) {
                        mTextView.measure(0, 0);
                        width = mTextView.getMeasuredWidth();
                    }
                    // 设置tab左右间距,注意这里不能使用Padding,因为源码中线的宽度是根据tabView的宽度来设置的
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                    params.width = width;
                    params.leftMargin = margin;
                    params.rightMargin = margin;
                    tabView.setLayoutParams(params);
                    tabView.invalidate();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    });
}

    @Override
    public void initView() {
        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        teacher_details_users=findViewById(R.id.teacher_details_users);
        tablayout.post(new Runnable() {
            @Override
            public void run() {
                //设置tablayout下标线
                setIndicatorWidth(tablayout,100);
            }
        });
        //getChildFragmentManager() 防止内层Fragment数据丢失
        viewpager.setAdapter(new TabAdapter(fragmentManager));
        tablayout.setupWithViewPager(viewpager);
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        UserBean userBean = (UserBean) getIntent().getSerializableExtra("userBean");
        teacher_details_users.setText(userBean.getBed_no()+"  "+userBean.getPatient_name());

    }
    List<Fragment> fragmentList = new ArrayList<>();

    String[] titles = {"检查", "检验"};

    private class TabAdapter extends FragmentPagerAdapter {


        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new JcFragment());
            fragmentList.add(new JyFragment());
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
