package com.pda.pda_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.db.Entry.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/29 17:33
 * 功能：用户信息适配器
 */
public class UserAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<UserBean> user_list;

    public UserAdapter(Context context, List<UserBean> user_list)
    {
        this.user_list = (ArrayList<UserBean>) user_list;
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

        holder.bad_num.setText(user_list.get(position).getBed_no());
        holder.user_name.setText(user_list.get(position).getPatient_name());
        holder.user_sex.setText(user_list.get(position).getSex());
        holder.user_age.setText(user_list.get(position).getAge());
        holder.user_hulilevel.setText(user_list.get(position).getTend());

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