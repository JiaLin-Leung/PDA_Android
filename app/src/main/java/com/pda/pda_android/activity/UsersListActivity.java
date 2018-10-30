package com.pda.pda_android.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pda.pda_android.R;
import com.pda.pda_android.adapter.UserAdapter;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.bean.UserBean;
import com.pda.pda_android.db.dbutil.UserDaoOpe;

import java.util.List;

/**
 * 梁佳霖创建于：2018/10/29 11:52
 * 功能：用户列表
 * 进度：目前可以读取数据库并且展示数据库数据
 */
public class UsersListActivity extends BaseActivity {

    private ListView users_listview;
    private List<UserBean> user_list;
    private static String from;
    private UserAdapter adapter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_users_list;
    }

    @Override
    public void initView() {
        users_listview = findViewById(R.id.users_listview);

    }

    @Override
    public void initData() {
//        UserDaoOpe.deleteAllData(UsersListActivity.this);
        user_list = UserDaoOpe.queryAll(UsersListActivity.this);
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
