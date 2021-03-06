package com.pda.pda_android.fragment.wjbqs;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.adapter.wjbqs.WjbqsDetailAdapter;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.bean.FlagBean;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.bean.WjbqsBean;
import com.pda.pda_android.utils.Util;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.Fragment;
import okhttp3.Call;
import okhttp3.Response;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * 无菌包签收手动签收
 */

public class WjbqssdFragment extends BaseFragment {
    private RefreshLayout refreshLayout;
    private StickyListHeadersListView stickyListHeadersListView;
    public  WjbqsDetailAdapter mainAdapter;
    private List<WjbqsBean.WjbqsBeanListBean> wjbqsBeanListBeans = new ArrayList<>();
    private WjbqsBean wjbqsBean;

    private ImageView no_data;

    public void initData() {

    }
    public void PostData(String start_time,String end_time){
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("page", 1+""); //将姓名参数添加到数据包
        if (!Util.isEmpty(start_time)){
            params.put("start_date", start_time);
        }
        if (!Util.isEmpty(end_time)){
            params.put("end_date", end_time);
        }
        OkHttpManager.getInstance().postRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.getNotSignedList, new LoadCallBack<String>(getActivity()) {
            @Override
            protected void onEror(okhttp3.Call call, int statusCode, Exception e) {
                showCenterToastCenter("网络不可用，请检查网络");
            }
            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                Gson gson = new Gson();
                if (s.contains("\"response\": \"ok\"")){
                    wjbqsBean = gson.fromJson(s,WjbqsBean.class);
                    wjbqsBeanListBeans = wjbqsBean.getData();
                    if (wjbqsBeanListBeans.size()==0){
                        no_data.setVisibility(View.VISIBLE);
                    }
                    mainAdapter = new WjbqsDetailAdapter(getActivity(),wjbqsBeanListBeans);
                    stickyListHeadersListView.setAdapter(mainAdapter);
                }else {
                    LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                    showCenterToastCenter(loginBeanFail.getMessage());
                }

            }
        },params);
    }
    @Override
    public void initView(View view) {
        refreshLayout=view.findViewById(R.id.refreshLayout1);
        stickyListHeadersListView=view.findViewById(R.id.wsjqs_sd_list);
        no_data=view.findViewById(R.id.no_data);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(1500,true);
            }
        });
        //设置 Header 为 ClassicsHeader
        refreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        stickyListHeadersListView.setStickyHeaderTopOffset(1);
        //设置头部改变的监听
        stickyListHeadersListView.setOnStickyHeaderChangedListener(new StickyListHeadersListView.OnStickyHeaderChangedListener() {
            @Override
            public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
                header.findViewById(R.id.item_sd_shaixuan).setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_wjbqssd;
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
           PostData("","");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FlagBean flag) {
        if (flag.getFlag().equals("WJBQSSD")){
            PostData(flag.getStart_time(),flag.getEnd_time());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
