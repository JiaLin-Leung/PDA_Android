package com.pda.pda_android.activity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.bean.User;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/29 11:52
 * 功能：用户列表
 */
public class UsersListActivity extends BaseActivity {

    private ListView users_listview;
    private ArrayList<User> user_list;

    @Override
    public int setLayoutId() {
        return R.layout.activity_users_list;
    }

    @Override
    public void initView() {
        user_list = new ArrayList<>();
        for (int a = 0;a <= 10; a++){
            User u = new User("陈奕迅","44","男","一级护理","12","888");
            user_list.add(u);
        }
        users_listview = findViewById(R.id.users_listview);
        MyAdapter adapter = new MyAdapter(UsersListActivity.this);
        users_listview.setAdapter(adapter);
    }

    /**
     * 用户信息适配器
     */
    private class MyAdapter extends BaseAdapter{

        private LayoutInflater mInflater;

        public MyAdapter(Context context)
        {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return user_list.size();
        }

        @Override
        public Object getItem(int i) {
            return user_list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolder holder = null;
            // 判断是否缓存
            if (convertView == null)
            {
                holder = new ViewHolder();
                // 通过LayoutInflater实例化布局
                convertView = mInflater.inflate(R.layout.item_user, null);
                holder.bad_num = (TextView) convertView.findViewById(R.id.bad_num);
                holder.user_name = (TextView) convertView.findViewById(R.id.user_name);
                holder.user_sex = (TextView) convertView.findViewById(R.id.user_sex);
                holder.user_age = (TextView) convertView.findViewById(R.id.user_age);
                holder.user_hulilevel = (TextView) convertView.findViewById(R.id.user_hulilevel);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.bad_num.setText(user_list.get(position).getBad_num());
            holder.user_name.setText(user_list.get(position).getUser_name());
            holder.user_sex.setText(user_list.get(position).getSex());
            holder.user_age.setText(user_list.get(position).getAge());
            holder.user_hulilevel.setText(user_list.get(position).getHuli_level());

            return convertView;
        }

        public final class ViewHolder{
            public TextView user_name;
            public TextView bad_num;
            public TextView user_sex;
            public TextView user_age;
            public TextView user_hulilevel;
        }
    }

    @Override
    public void initData() {

    }

    public static void go_UsersListActivity(Context context){
        Intent intent = new Intent(context,UsersListActivity.class);
        context.startActivity(intent);
    }
}
