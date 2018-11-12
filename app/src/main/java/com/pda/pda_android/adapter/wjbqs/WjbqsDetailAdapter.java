package com.pda.pda_android.adapter.wjbqs;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pda.pda_android.R;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.base.utils.SpUtils;
import com.pda.pda_android.bean.WjbqsBean;
import com.pda.pda_android.fragment.wjbqs.WjbqssdFragment;

import java.util.List;


import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * 梁佳霖创建于：2018/11/7 13:44
 * 功能：
 */
public class WjbqsDetailAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    public static final int ITEM_SIZE = 10101;
    private Context context;
    private Handler handler;
    public static List<WjbqsBean.WjbqsBeanListBean> bodyList;
    private static int item_siza;
    private WjbqsBodyAdapter wjbqsBodyAdapter;
    public WjbqsDetailAdapter(Context context, List<WjbqsBean.WjbqsBeanListBean> bodyList) {
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

        WjbqsDetailAdapter.BodyHolder bodyHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.wjbqs_list_body, viewGroup, false);
            bodyHolder = new WjbqsDetailAdapter.BodyHolder(view);
            view.setTag(bodyHolder);
        } else {
            bodyHolder = (WjbqsDetailAdapter.BodyHolder) view.getTag();
        }
        bodyHolder.bodyrv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        bodyHolder.bodyrv.setItemAnimator(new DefaultItemAnimator());
        bodyHolder.bodyrv.setHasFixedSize(true);
        bodyHolder.bodyrv.setNestedScrollingEnabled(false);
        //设置数据
        wjbqsBodyAdapter=new WjbqsBodyAdapter(context,bodyList.get(i).getList(),bodyList);
        bodyHolder.bodyrv.setAdapter(wjbqsBodyAdapter);
        return view;
    }

    //绑定头部的数据
    @Override
    public View getHeaderView(final int position, View convertView, ViewGroup parent) {
        WjbqsDetailAdapter.HeadHolder headHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.wjbqs_head, parent, false);
            headHolder = new WjbqsDetailAdapter.HeadHolder(convertView);
            convertView.setTag(headHolder);
        } else {
            headHolder = (WjbqsDetailAdapter.HeadHolder) convertView.getTag();
        }
            //设置数据
            item_siza = bodyList.get(position).getList().size();
            headHolder.headTv.setText(bodyList.get(position).getDate());
            headHolder.item_num_tv.setText("共"+item_siza+"条");
            setItemSize();

            headHolder.item_shaixuan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,bodyList.get(position).getDate(),Toast.LENGTH_SHORT).show();
                }
            });

        return convertView;
    }
        public void setItemSize(){
             handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what){
                        case ITEM_SIZE:
                            int size=bodyList.get(msg.arg1).getList().size();
                            if (size==0){
                                bodyList.remove(msg.arg1);
                            }
                            LogUtils.showLog(msg.arg1+"-----------------");
                            notifyDataSetChanged();
                            break;
                    }
                }
            };
             wjbqsBodyAdapter.setthandle(handler);
        }

    //头部的内部类
    public class HeadHolder {
        private TextView headTv,item_num_tv;
        private LinearLayout item_shaixuan;

        public HeadHolder(View itemHeadView) {
            item_num_tv=  itemHeadView.findViewById(R.id.item_num_tv);
            headTv =  itemHeadView.findViewById(R.id.item_head_tv);
            item_shaixuan=itemHeadView.findViewById(R.id.item_sd_shaixuan);

        }
    }

    //内容的内部类
    class BodyHolder {
        private RecyclerView bodyrv;
        public BodyHolder(View itemBodyView) {
            bodyrv =  itemBodyView.findViewById(R.id.rv);
        }
    }

}
