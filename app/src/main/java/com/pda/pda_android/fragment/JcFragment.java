package com.pda.pda_android.fragment;

import androidx.fragment.app.Fragment;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.pda.pda_android.R;
import com.pda.pda_android.activity.MainActivity;
import com.pda.pda_android.activity.UsersListActivity;
import com.pda.pda_android.adapter.JcDetailAdapter;
import com.pda.pda_android.adapter.JyDetailAdapter;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.Bodybean;
import com.pda.pda_android.db.Entry.CheckBean;
import com.pda.pda_android.db.dbutil.CheckBeanOpe;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;


public class JcFragment extends BaseFragment {

    private StickyListHeadersListView stickyListHeadersListView;
    private JcDetailAdapter mainAdapter;
    private List<Bodybean> bodyList;
    //下拉控件
    private RefreshLayout refreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_jc, container, false);
        //初始化
        stickyListHeadersListView =  view.findViewById(R.id.jc_list);
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


//        List<CheckBean>list = CheckBeanOpe.queryAll(getActivity());
//
//        LogUtils.showLog("3333333",list.size()+"");
        //设置内容的数据
        bodyList = new ArrayList<>();
        List<Bodybean.Body> list;
        for (int i = 0; i < 3; i++) {
            Bodybean bodybean=new Bodybean();
            bodybean.setTitle("题目"+i);
            list=new ArrayList<>();
            if (i==1){
                for (int j=0;j<5;j++){
                    Bodybean.Body body= new Bodybean.Body();
                    body.setName("找小虎"+i);
                    body.setData("2018-6-" + j);
                    body.setProject("项目"+j);
                    body.setShebei("设备"+j);
                    list.add(body);
                }
                bodybean.setBodyList(list);
            }else if (i==2){
                for (int j=0;j<8;j++){
                    Bodybean.Body body=  new Bodybean.Body();
                    body.setName("找小虎"+i);
                    body.setData("2018-6- " + j);
                    body.setProject("项目"+j);
                    body.setShebei("设备"+j);
                    list.add(body);
                }
                bodybean.setBodyList(list);
            }else if (i==3){
                for (int j=0;j<2;j++){
                    Bodybean.Body body=  new Bodybean.Body();
                    body.setName("找小虎"+i);
                    body.setData("2018-6- " + j);
                    body.setProject("项目"+j);
                    body.setShebei("设备"+j);
                    list.add(body);
                }
                bodybean.setBodyList(list);
            }else {
                for (int j=0;j<5;j++){
                    Bodybean.Body body=  new Bodybean.Body();
                    body.setName("找小虎"+i);
                    body.setData("2018-6- " + j);
                    body.setProject("项目"+j);
                    body.setShebei("设备"+j);
                    list.add(body);
                }
                bodybean.setBodyList(list);
            }
            bodyList.add(bodybean);
        }
        mainAdapter = new JcDetailAdapter(getActivity(),bodyList);
//        stickyListHeadersListView.setHasFixedSize(true);

//        mainAdapter.setBodyList(bodyList);

        //设置头部的点击事件
        stickyListHeadersListView.setOnHeaderClickListener(new StickyListHeadersListView.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(StickyListHeadersListView l, View header, int itemPosition, long headerId, boolean currentlySticky) {
                Toast.makeText(getActivity(), "headerId:" + headerId, Toast.LENGTH_SHORT).show();
            }
        });

        //设置内容的点击事件
        stickyListHeadersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "i:" + i, Toast.LENGTH_SHORT).show();
            }
        });
        //默认滑动一段距离   适配筛选图标显示隐藏
        stickyListHeadersListView.setStickyHeaderTopOffset(1);
        //设置头部改变的监听
        stickyListHeadersListView.setOnStickyHeaderChangedListener(new StickyListHeadersListView.OnStickyHeaderChangedListener() {
            @Override
            public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
//                Toast.makeText(getActivity(), "itemPosition:" + itemPosition, Toast.LENGTH_SHORT).show();
                header.findViewById(R.id.item_shaixuan).setVisibility(View.VISIBLE);
            }
        });

        stickyListHeadersListView.setAdapter(mainAdapter);
        return  view;
    }

    @Override
    public void initData() {


    }

    @Override
    public void initView(View view) {

    }

    @Override
    public int getlayout() {
        return R.layout.fragment_jc;
    }

}