package com.pda.pda_android.activity.apps.detail;



import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.fragment.yzybhd.YzybhdendFragment;
import com.pda.pda_android.fragment.yzybhd.YzybhdsdFragment;
import com.pda.pda_android.fragment.yzybhd.YzybhdsmFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * 医嘱药包核对
 */

public class YzybhdDetailActivity extends BaseActivity {
    private TabLayout tablayout;
    private ViewPager viewpager;
    private TextView user_info;
    private ImageView users_all,user_name_up,user_name_down,title_back;
    @Override
    public int setLayoutId() {
        return R.layout.activity_yzybhd_list;
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
        tablayout = findViewById(R.id.tablayout_yzybhd);
        viewpager = findViewById(R.id.viewpager_yzybhd);
        TextView tv_top_title = findViewById(R.id.tv_top_title);
        tv_top_title.setText("医嘱药包核对");
        title_back = findViewById(R.id.iv_top_back);
        FragmentManager fragmentManager=getSupportFragmentManager();
        user_info=findViewById(R.id.user_info);
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
//        UserBean userBean = (UserBean) getIntent().getSerializableExtra("userBean");
//        user_info.setText(userBean.getBed_no()+"  "+userBean.getPatient_name());
//        users_all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    List<Fragment> fragmentList = new ArrayList<>();

    String[] titles = {"扫码核对", "手动核对","已核对"};

    private class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new YzybhdsmFragment());
            fragmentList.add(new YzybhdsdFragment());
            fragmentList.add(new YzybhdendFragment());
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
