package com.pda.pda_android.adapter.wjbqs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.WjbEndBean;
import com.pda.pda_android.bean.WjbqsBean;

import java.util.List;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * 梁佳霖创建于：2018/11/7 13:44
 * 功能：
 */
public class WjbqsEndDetailAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    private Context context;
    private List<WjbEndBean.DataBean> bodyList;

    public WjbqsEndDetailAdapter(Context context, List<WjbEndBean.DataBean> bodyList) {
        this.context = context;
        this.bodyList=bodyList;
    }

    //设置数据的个数
    @Override
    public int getCount() {
        return bodyList.size();
    }

    //设置item的条数
    @Override
    public Object getItem(int i) {
        return bodyList.get(i).getList().size();
    }

    //获得相应数据集合中特定位置的数据项
    @Override
    public long getItemId(int i) {
        return i;
    }

    //获得头部相应数据集合中特定位置的数据项
    @Override
    public long getHeaderId(int position) {
        return position;
    }

    //绑定内容的数据
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        WjbqsEndDetailAdapter.BodyHolder bodyHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.wjbqs_end_list_body, viewGroup, false);
            bodyHolder = new WjbqsEndDetailAdapter.BodyHolder(view);
            view.setTag(bodyHolder);
        } else {
            bodyHolder = (WjbqsEndDetailAdapter.BodyHolder) view.getTag();
        }
        bodyHolder.bodyrv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        bodyHolder.bodyrv.setItemAnimator(new DefaultItemAnimator());
        bodyHolder.bodyrv.setHasFixedSize(true);
        bodyHolder.bodyrv.setNestedScrollingEnabled(false);
        //设置数据
        bodyHolder.bodyrv.setAdapter(new WjbqsEndBodyAdapter(context,bodyList.get(i).getList()));

        return view;
    }

    //绑定头部的数据
    @Override
    public View getHeaderView(final int position, View convertView, ViewGroup parent) {

        WjbqsEndDetailAdapter.HeadHolder headHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.wjbqs_end_head, parent, false);
            headHolder = new WjbqsEndDetailAdapter.HeadHolder(convertView);
            convertView.setTag(headHolder);
        } else {
            headHolder = (WjbqsEndDetailAdapter.HeadHolder) convertView.getTag();
        }
        //设置数据
        headHolder.headTv.setText(bodyList.get(position).getDate());
        headHolder.item_num_tv.setText("共"+bodyList.get(position).getList().size()+"条");
        headHolder.item_end_shaixuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }


    //头部的内部类
    public class HeadHolder {
        private TextView headTv,item_num_tv;
        private LinearLayout item_end_shaixuan;
        public HeadHolder(View itemHeadView) {
            item_num_tv=  itemHeadView.findViewById(R.id.item_num_tv);
            headTv =  itemHeadView.findViewById(R.id.item_head_tv);
            item_end_shaixuan =  itemHeadView.findViewById(R.id.item_end_shaixuan);
        }
    }

    //内容的内部类
    class BodyHolder {
        private RecyclerView bodyrv;
        public BodyHolder(View itemBodyView) {
            bodyrv = itemBodyView.findViewById(R.id.rv);
        }
    }

}
