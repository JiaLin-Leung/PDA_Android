package com.pda.pda_android.activity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.adapter.UserAdapter;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.db.Entry.User_db;
import com.pda.pda_android.db.dbutil.UserDaoOpe;

import java.util.ArrayList;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/29 11:52
 * 功能：用户列表
 */
public class UsersListActivity extends BaseActivity {

    private ListView users_listview;
    private List<User_db> user_list;
    private static String from;
    private UserAdapter adapter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_users_list;
    }

    @Override
    public void initView() {
        user_list = new ArrayList<>();
        for (int a = 0;a <= 10; a++){
            User_db u = new User_db(null,"陈奕迅","44","男","一级护理","12","888");
            user_list.add(u);
        }
        UserDaoOpe.insertData(UsersListActivity.this,user_list);
        List<User_db> aa = UserDaoOpe.queryAll(UsersListActivity.this);
        for (int a = 0;a<aa.size();a++){
            LogUtils.showLog("44444444",aa.get(a).toString());
        }
        users_listview = findViewById(R.id.users_listview);
        adapter = new UserAdapter(UsersListActivity.this,user_list);
        users_listview.setAdapter(adapter);
        users_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (from.equals("JCJY")){ //检查检验过来的

                }else if(from.equals("SSXX")){//手术信息过来的

                }else if(from.equals("WJBQS")){//无菌包签收过来的

                }else if(from.equals("YZYBHD")){//医嘱药包核对过来的

                }
            }
        });
    }

    @Override
    public void initData() {

    }

    /**
     * 静态方法页面跳转
     * @param context 上下文
     * @param from_activity 从哪里来的，用于后面用户列表跳转判断
     */
    public static void go_UsersListActivity(Context context,String from_activity){
        from_activity = from;
        Intent intent = new Intent(context,UsersListActivity.class);
        context.startActivity(intent);
    }
}
