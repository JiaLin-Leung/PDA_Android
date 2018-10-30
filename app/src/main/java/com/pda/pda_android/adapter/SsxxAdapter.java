package com.pda.pda_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.db.Entry.SsxxUserInfoBean;
import com.pda.pda_android.db.Entry.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/30 18:42
 * 功能：手术信息适配器
 */
public class SsxxAdapter  extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<SsxxUserInfoBean> user_list;

    public SsxxAdapter(Context context, List<SsxxUserInfoBean> user_list)
    {
        this.user_list = user_list;
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
        SsxxAdapter.ViewHolder holder = null;
        // 判断是否缓存
        if (convertView == null)
        {
            holder = new SsxxAdapter.ViewHolder();
            convertView = mInflater.inflate(R.layout.item_sxxinfamation, null);
            holder.shoushu_user = (TextView) convertView.findViewById(R.id.shoushu_user);
            holder.shoushu_name = (TextView) convertView.findViewById(R.id.shoushu_name);
            holder.shoushu_docter = (TextView) convertView.findViewById(R.id.shoushu_docter);
            holder.shoushu_time = (TextView) convertView.findViewById(R.id.shoushu_time);
            convertView.setTag(holder);
        }
        else
        {
            holder = (SsxxAdapter.ViewHolder) convertView.getTag();
        }

        holder.shoushu_user.setText(user_list.get(position).getShoushu_user());
        holder.shoushu_name.setText(user_list.get(position).getShoushu_name());
        holder.shoushu_docter.setText(user_list.get(position).getShoushu_docter());
        holder.shoushu_time.setText(user_list.get(position).getShoushu_time());

        return convertView;
    }
    public final class ViewHolder{
        public TextView shoushu_user;
        public TextView shoushu_name;
        public TextView shoushu_docter;
        public TextView shoushu_time;
    }
}
