package com.pda.pda_android.fragment.wjbqs;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.adapter.wjbqs.WjbqsDetailAdapter;
import com.pda.pda_android.adapter.wjbqs.WjbqsEndDetailAdapter;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.FlagBean;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.bean.WjbEndBean;
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

import static com.pda.pda_android.adapter.wjbqs.WjbqsDetailAdapter.ITEM_SIZE;

/**
 * 无菌包签收已确认
 */

public class WjbqsendFragment extends BaseFragment {
    private RefreshLayout refreshLayout;
    private StickyListHeadersListView stickyListHeadersListView;
    private WjbqsEndDetailAdapter mainAdapter;
    private List<WjbEndBean.DataBean> wjbqsBeanListBeans = new ArrayList<>();
    private WjbEndBean wjbEndBean;
    private ImageView no_data;
    @Override
    public void initData() {

    }
    public void PostData(String start_time,String end_time ){
        Map<String, String> params = new HashMap<>(); //提交数据包
        if (!Util.isEmpty(start_time)){
            params.put("start_date", start_time);
        }
        if (!Util.isEmpty(end_time)){
            params.put("end_date", end_time);
        }
        OkHttpManager.getInstance().postRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.sign_list, new LoadCallBack<String>(getActivity()) {
            @Override
            protected void onEror(okhttp3.Call call, int statusCode, Exception e) {
                showCenterToastCenter("网络不可用，请检查网络");
            }
            @Override
            protected void onSuccess(Call call, Response response, String s)  {
                Gson gson = new Gson();
                if (s.contains("\"response\": \"ok\"")){
                    wjbEndBean = gson.fromJson(s,WjbEndBean.class);
                    wjbqsBeanListBeans = wjbEndBean.getData();
                    if (wjbqsBeanListBeans.size()==0){
                        no_data.setVisibility(View.VISIBLE);
                    }
                    mainAdapter = new WjbqsEndDetailAdapter(getActivity(),wjbqsBeanListBeans);
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
        stickyListHeadersListView=view.findViewById(R.id.wsjqs_end_list);
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
                header.findViewById(R.id.item_end_shaixuan).setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_wjbqsend;
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
        if (flag.getFlag().equals("WJBQSEND")){
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
