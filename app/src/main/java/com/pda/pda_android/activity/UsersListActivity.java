package com.pda.pda_android.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.detail.JcjyListActivity;
import com.pda.pda_android.activity.apps.detail.SsxxInfomationActivity;
import com.pda.pda_android.activity.apps.detail.WjbqsInfomationActivity;
import com.pda.pda_android.activity.apps.detail.YzybhdDetailActivity;
import com.pda.pda_android.adapter.UserAdapter;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.db.Entry.UserBean;
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
    private EditText et_search;
    private ImageView iv_clear;
    @Override
    public int setLayoutId() {
        return R.layout.activity_users_list;
    }

    @Override
    public void initView() {
        users_listview = findViewById(R.id.users_listview);
        et_search=findViewById(R.id.et_search);
        iv_clear=findViewById(R.id.iv_clear);
    }

    @Override
    public void initData() {
        user_list = UserDaoOpe.queryAll(UsersListActivity.this);
        adapter = new UserAdapter(UsersListActivity.this,user_list);
        users_listview.setAdapter(adapter);
        users_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LogUtils.showLog("跳转标记",from);
                if (from.equals("JCJY")){ //检查检验过来的
                    UserBean userBean = adapter.user_list.get(i);
                    Intent intent = new Intent(UsersListActivity.this,JcjyListActivity.class);
                    intent.putExtra("userBean",userBean);
                    startActivity(intent);
                }else if(from.equals("SSXX")){//手术信息过来的
                    UserBean userBean = adapter.user_list.get(i);
                    Intent intent = new Intent(UsersListActivity.this,SsxxInfomationActivity.class);
                    intent.putExtra("userBean",userBean);
                    startActivity(intent);
                }else if(from.equals("WJBQS")){//无菌包签收过来的
                    UserBean userBean = adapter.user_list.get(i);
                    Intent intent = new Intent(UsersListActivity.this,WjbqsInfomationActivity.class);
                    intent.putExtra("userBean",userBean);
                    startActivity(intent);
                }else if(from.equals("YZYBHD")){//医嘱药包核对过来的
                    UserBean userBean = adapter.user_list.get(i);
                    Intent intent = new Intent(UsersListActivity.this,YzybhdDetailActivity.class);
                    intent.putExtra("userBean",userBean);
                    startActivity(intent);
                }
            }
        });
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());
            }
        });
        iv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_search.setText("");
            }
        });
    }

    /**
     * 静态方法页面跳转
     * @param context 上下文
     * @param from_activity 从哪里来的，用于后面用户列表跳转判断
     */
    public static void go_UsersListActivity(Context context,String from_activity){
        from = from_activity;
        Intent intent = new Intent(context,UsersListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        et_search.setText("");
    }
}
