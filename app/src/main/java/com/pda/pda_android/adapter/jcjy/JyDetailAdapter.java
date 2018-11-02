package com.pda.pda_android.adapter.jcjy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;
import com.pda.pda_android.bean.Bodybean;

import java.util.List;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by mac on 16-8-16.
 */
public class JyDetailAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private Context context;
    private List<String> headList;
    private List<Bodybean> bodyList;

    public JyDetailAdapter(Context context, List<Bodybean> bodyList) {
        this.context = context;
        this.bodyList=bodyList;
    }

    public void setHeadList(List<String> headList) {
        this.headList = headList;
        notifyDataSetChanged();
    }

    public void setBodyList(List<Bodybean> bodyList) {
        this.bodyList = bodyList;
        notifyDataSetChanged();
    }

    //设置数据的个数
    @Override
    public int getCount() {
        return bodyList.size();
    }

    //设置item的条数
    @Override
    public Object getItem(int i) {
        return bodyList.get(i).getBodyList().size();
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

        BodyHolder bodyHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.jy_list_body, viewGroup, false);
            bodyHolder = new BodyHolder(view);
            view.setTag(bodyHolder);
        } else {
            bodyHolder = (BodyHolder) view.getTag();
        }
        bodyHolder.bodyrv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        bodyHolder.bodyrv.setItemAnimator(new DefaultItemAnimator());
        bodyHolder.bodyrv.setHasFixedSize(true);
        bodyHolder.bodyrv.setNestedScrollingEnabled(false);
        //设置数据
        bodyHolder.bodyrv.setAdapter(new JyBodyAdapter(context,bodyList.get(i).getBodyList()));

        return view;
    }

    //绑定头部的数据
    @Override
    public View getHeaderView(final int position, View convertView, ViewGroup parent) {

        HeadHolder headHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.jy_head, parent, false);
            headHolder = new HeadHolder(convertView);
            convertView.setTag(headHolder);
        } else {
            headHolder = (HeadHolder) convertView.getTag();
        }
        //设置数据
        headHolder.headTv.setText(bodyList.get(position).getTitle());
        headHolder.item_num_tv.setText("总共"+bodyList.get(position).getBodyList().size()+"条");
        headHolder.item_shaixuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,bodyList.get(position).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }


    //头部的内部类
    class HeadHolder {
        private TextView headTv,item_num_tv;
        private LinearLayout item_shaixuan;
        public HeadHolder(View itemHeadView) {
            item_num_tv=  itemHeadView.findViewById(R.id.item_num_tv);
            headTv =  itemHeadView.findViewById(R.id.item_head_tv);
            item_shaixuan=itemHeadView.findViewById(R.id.item_shaixuan);
        }
    }

    //内容的内部类
    class BodyHolder {
        private RecyclerView bodyrv;
        public BodyHolder(View itemBodyView) {
            bodyrv = (RecyclerView) itemBodyView.findViewById(R.id.rv);
        }
    }

}
