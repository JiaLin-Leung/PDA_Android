package com.pda.pda_android.fragment.jcjy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.detail.JcjyListActivity;
import com.pda.pda_android.adapter.jcjy.JyDetailAdapter;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.db.Entry.AssayBean;
import com.pda.pda_android.db.dbutil.AssayBeanOpe;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * 检验
 */
public class JyFragment extends Fragment {
    private StickyListHeadersListView stickyListHeadersListView;
    private JyDetailAdapter mainAdapter;
    //下拉控件
    private RefreshLayout refreshLayout;
    //住院号  名字
    private  String Patient_no,name;
    private List<AssayBean> assayBeans;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_jy, container, false);
        //初始化
        stickyListHeadersListView =  view.findViewById(R.id.jy_list);
        refreshLayout = view.findViewById(R.id.refreshLayout_jy);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(1500,true);
            }
        });
        //设置 Header 为 ClassicsHeader
        refreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        assayBeans=  AssayBeanOpe.queryPATIENT_NO(getActivity(),Patient_no);
        LogUtils.showLog("jy_shuju",assayBeans.toString());
        mainAdapter = new JyDetailAdapter(getActivity(),assayBeans,name);

//        //设置头部的点击事件
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
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Patient_no = ((JcjyListActivity) context).getPatient_no();
        name = ((JcjyListActivity) context).getname();
    }
}
