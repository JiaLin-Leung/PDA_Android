package com.pda.pda_android.fragment.jcjy;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.detail.JcjyListActivity;
import com.pda.pda_android.adapter.jcjy.JcDetailAdapter;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.db.Entry.CheckBean;
import com.pda.pda_android.db.dbutil.CheckBeanOpe;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 检查
 */

public class JcFragment extends BaseFragment {

    private StickyListHeadersListView stickyListHeadersListView;
    private JcDetailAdapter mainAdapter;
    //下拉控件
    private RefreshLayout refreshLayout;
    private  List<CheckBean> checkBeanList=new ArrayList<>();
    //床位 患者名字
    private  String cw,name;
    private TextView no_data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_jc, container, false);
        //初始化
        stickyListHeadersListView =  view.findViewById(R.id.jc_list);
        no_data = view.findViewById(R.id.no_data);
        refreshLayout = view.findViewById(R.id.refreshLayout1);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(1500,true);
            }
        });
        //设置 Header 为 ClassicsHeader
        refreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        checkBeanList = CheckBeanOpe.queryRecord_no(getActivity(),cw);

        initData();
        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        cw = ((JcjyListActivity) context).getcw();
        name = ((JcjyListActivity) context).getname();
    }

    @Override
    public void initData() {
        if (checkBeanList.size() == 0){
            no_data.setVisibility(View.VISIBLE);
        }else
            mainAdapter = new JcDetailAdapter(getActivity(),checkBeanList,name);
        //设置头部的点击事件
//        stickyListHeadersListView.setOnHeaderClickListener(new StickyListHeadersListView.OnHeaderClickListener() {
//            @Override
//            public void onHeaderClick(StickyListHeadersListView l, View header, int itemPosition, long headerId, boolean currentlySticky) {
//                Toast.makeText(getActivity(), "headerId:" + headerId, Toast.LENGTH_SHORT).show();
//            }
//        });

         //设置内容的点击事件
//        stickyListHeadersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getActivity(), "i:" + i, Toast.LENGTH_SHORT).show();
//            }
//        });
        //默认滑动一段距离   适配筛选图标显示隐藏
        stickyListHeadersListView.setStickyHeaderTopOffset(1);
        //设置头部改变的监听
        stickyListHeadersListView.setOnStickyHeaderChangedListener(new StickyListHeadersListView.OnStickyHeaderChangedListener() {
            @Override
            public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
                header.findViewById(R.id.item_shaixuan).setVisibility(View.VISIBLE);
            }
        });

        stickyListHeadersListView.setAdapter(mainAdapter);
    }

    @Override
    public void initView(View view) {
    }
    @Override
    public int getlayout() {
        return R.layout.fragment_jc;
    }
}
