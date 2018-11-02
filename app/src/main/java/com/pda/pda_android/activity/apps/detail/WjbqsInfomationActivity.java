package com.pda.pda_android.activity.apps.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.fragment.WjbqsendFragment;
import com.pda.pda_android.fragment.WjbqssdFragment;
import com.pda.pda_android.fragment.WjbqssmFragment;
import com.pda.pda_android.fragment.YzybhdendFragment;
import com.pda.pda_android.fragment.YzybhdsdFragment;
import com.pda.pda_android.fragment.YzybhdsmFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * 梁佳霖创建于：2018/10/31 11:04
 * 功能：无菌包签收二级页面
 */
public class WjbqsInfomationActivity extends BaseActivity {

    private ImageView title_back;
    private ImageView user_name_up;
    private ImageView users_all;
    private ImageView user_name_down;
    private TextView user_info;
    private TabLayout tablayout;
    private ViewPager viewpager;

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
    public int setLayoutId() {
        return R.layout.activity_wjbqsinfomation;
    }

    @Override
    public void initView() {
        UserBean userBean = (UserBean) getIntent().getSerializableExtra("userBean");
        title_back = findViewById(R.id.title_back);
        tablayout = findViewById(R.id.tablayout_wjbqs);
        viewpager = findViewById(R.id.viewpager_wjbqs);
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WjbqsInfomationActivity.this.finish();
            }
        });
        user_name_up = findViewById(R.id.user_name_up);
        user_name_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        user_name_down = findViewById(R.id.user_name_down);
        user_name_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        users_all = findViewById(R.id.users_all);
        users_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WjbqsInfomationActivity.this.finish();
            }
        });
        user_info = findViewById(R.id.user_info);
        user_info.setText(userBean.getBed_no()+"  "+userBean.getPatient_name());
        FragmentManager fragmentManager=getSupportFragmentManager();
        tablayout.post(new Runnable() {
            @Override
            public void run() {
                //设置tablayout下标线
                setIndicatorWidth(tablayout,50);
            }
        });
        //getChildFragmentManager() 防止内层Fragment数据丢失
        viewpager.setAdapter(new TabAdapter(fragmentManager));
        tablayout.setupWithViewPager(viewpager);

    }

    List<Fragment> fragmentList = new ArrayList<>();
    String[] titles = {"扫码签收", "手动签收","已签收"};
    private class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new WjbqssmFragment());
            fragmentList.add(new WjbqssdFragment());
            fragmentList.add(new WjbqsendFragment());
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
