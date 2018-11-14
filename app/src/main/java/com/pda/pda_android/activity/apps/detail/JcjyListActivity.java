package com.pda.pda_android.activity.apps.detail;



import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.UsersListActivity;
import com.pda.pda_android.activity.apps.JcjyActivity;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.SpUtils;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.dao.UserBeanDao;
import com.pda.pda_android.db.dbutil.UserDaoOpe;
import com.pda.pda_android.fragment.jcjy.JcFragment;
import com.pda.pda_android.fragment.jcjy.JyFragment;
import com.pda.pda_android.utils.Util;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * 检查检验
 */
public class JcjyListActivity extends BaseActivity {
    private TabLayout tablayout;
    private ViewPager viewpager;
    private TextView user_info;
    private ImageView users_all,user_name_up,user_name_down,title_back;
    private String cw,name,Patient_no;
    private List<UserBean> user_list;
    private UserBean userBean_positon;
    private int position;
    private FragmentManager fragmentManager;

    @Override
    public int setLayoutId() {
        return R.layout.activity_jcjy_list;
    }


    @Override
    public void initView() {
        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);
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
        //getChildFragmentManager() 防止内层Fragment数据丢失
        viewpager.setAdapter(new TabAdapter(fragmentManager));
        tablayout.setupWithViewPager(viewpager);

        position = getIntent().getIntExtra("position",0);
        user_list = UserDaoOpe.queryAll(JcjyListActivity.this);
        String type = getIntent().getStringExtra("type");
        if (!TextUtils.isEmpty(type) && type.equals("1")){//说明从首页进来的，已经设置过患者
            String user_record_no = SpUtils.getInstance(JcjyListActivity.this).getString("user_record_no","");
            List<UserBean> userBeans = UserDaoOpe.queryRecord_no(JcjyListActivity.this,user_record_no);
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
        users_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users_all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UsersListActivity.go_UsersListActivity(JcjyListActivity.this,"JCJY");
                        JcjyListActivity.this.finish();
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
    public String  getcw(){
        return  userBean_positon.getRecord_no();
    }
    public String  getname(){
        return  userBean_positon.getBed_no()+"  "+userBean_positon.getPatient_name();
    }
    public String  getPatient_no(){
        return  userBean_positon.getPatient_no();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.user_name_up://上一个患者
                if (position == 0){//如果是第一个患者直接跳过
                    showCenterToastCenter("已经是第一个患者！");
                }else{
                    position = position - 1;
                    userBean_positon = user_list.get(position);
                    viewpager.setAdapter(new TabAdapter(fragmentManager));
                    user_info.setText(userBean_positon.getBed_no()+"  "+userBean_positon.getPatient_name());
                }
                break;
            case R.id.user_name_down://下一个患者
                if (position != user_list.size()-1){
                    position = position + 1;
                    userBean_positon = user_list.get(position);
                    viewpager.setAdapter(new TabAdapter(fragmentManager));
                    user_info.setText(userBean_positon.getBed_no()+"  "+userBean_positon.getPatient_name());
                }else{
                    showCenterToastCenter("已经是最后一个患者！");
                }
                break;
        }
    }
}
