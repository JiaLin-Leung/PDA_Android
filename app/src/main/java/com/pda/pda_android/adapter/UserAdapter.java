package com.pda.pda_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.db.Entry.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 梁佳霖创建于：2018/10/29 17:33
 * 功能：用户信息适配器
 */
public class UserAdapter extends BaseAdapter implements Filterable {

    private LayoutInflater mInflater;
    public ArrayList<UserBean> user_list;
    /**
     * 过滤器上的锁可以同步复制原始数据。
     */
    private final Object mLock = new Object();
    private ArrayFilter mFilter;
    //对象数组的备份，当调用ArrayFilter的时候初始化和使用。此时，对象数组只包含已经过滤的数据。
    private ArrayList<UserBean> mOriginalValues;

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

    @Override
    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new ArrayFilter();
        }
        return mFilter;
    }
    /**
     * 一个带有首字母约束的数组过滤器，每一项不是以该首字母开头的都会被移除该list。
     */
    private class ArrayFilter extends Filter {
        //执行刷选
        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();//过滤的结果
            //原始数据备份为空时，上锁，同步复制原始数据
            if (mOriginalValues == null) {
                synchronized (mLock) {
                    mOriginalValues = new ArrayList<>(user_list);
                }
            }
            //当首字母为空时
            if (prefix == null || prefix.length() == 0) {
                ArrayList<UserBean> list;
                synchronized (mLock) {//同步复制一个原始备份数据
                    list = new ArrayList<>(mOriginalValues);
                }
                results.values = list;
                results.count = list.size();//此时返回的results就是原始的数据，不进行过滤
            } else {
                String prefixString = prefix.toString().toLowerCase();//转化为小写
                ArrayList<UserBean> values;
                synchronized (mLock) {//同步复制一个原始备份数据
                    values = new ArrayList<>(mOriginalValues);
                }
                final int count = values.size();
                final ArrayList<UserBean> newValues = new ArrayList<>();

                for (int i = 0; i < count; i++) {
                    final UserBean value = values.get(i);
                    final String valueText = value.getBed_no().toString().toLowerCase()+ value.getPatient_name().toString().toLowerCase();//DataBean对象的name属性作为过滤的参数
                    // First match against the whole, non-splitted value
                    if (valueText.startsWith(prefixString) || valueText.indexOf(prefixString.toString()) != -1) {//第一个字符是否匹配
                        newValues.add(value);//将这个item加入到数组对象中
                    } else {//处理首字符是空格
                        final String[] words = valueText.split(" ");
                        final int wordCount = words.length;

                        // Start at index 0, in case valueText starts with space(s)
                        for (int k = 0; k < wordCount; k++) {
                            if (words[k].startsWith(prefixString)) {//一旦找到匹配的就break，跳出for循环
                                newValues.add(value);
                                break;
                            }
                        }
                    }
                }
                results.values = newValues;//此时的results就是过滤后的List<User>数组
                results.count = newValues.size();
            }
            return results;
        }

        //刷选结果
        @Override
        protected void publishResults(CharSequence prefix, FilterResults results) {
            //noinspection unchecked
            user_list = (ArrayList<UserBean>) results.values;//此时，Adapter数据源就是过滤后的Results
            if (results.count > 0) {
                notifyDataSetChanged();//这个相当于从mDatas中删除了一些数据，只是数据的变化，故使用notifyDataSetChanged()
            } else {
                /**
                 * 数据容器变化 ----> notifyDataSetInValidated
                 容器中的数据变化  ---->  notifyDataSetChanged
                 */
                notifyDataSetInvalidated();//当results.count<=0时，此时数据源就是重新new出来的，说明原始的数据源已经失效了
            }
        }
    }
}