package com.pda.pda_android.fragment.jcjy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.detail.JcjyListActivity;
import com.pda.pda_android.adapter.jcjy.JcDetailAdapter;
import com.pda.pda_android.adapter.jcjy.JyDetailAdapter;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.FlagBean;
import com.pda.pda_android.bean.JcBean;
import com.pda.pda_android.bean.JyBean;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.db.Entry.AssayBean;
import com.pda.pda_android.db.dbutil.AssayBeanOpe;
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
 * 检验
 */
public class JyFragment extends BaseFragment {
    private StickyListHeadersListView stickyListHeadersListView;
    private JyDetailAdapter mainAdapter;
    //下拉控件
    private RefreshLayout refreshLayout;
    //住院号  名字
    private  String Patient_no,name;
    private ImageView no_data;
    private JyBean jyBean;
    private List<JyBean.DataBean> beanList;
    @Override
    public int getlayout() {
        return R.layout.fragment_jy;
    }
    @Override
    public void initData() {
    }

    @Override
    public void initView(View view) {
        stickyListHeadersListView =  view.findViewById(R.id.jy_list);
        refreshLayout = view.findViewById(R.id.refreshLayout_jy);
        no_data = view.findViewById(R.id.no_data);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(1500,true);
            }
        });
        //设置 Header 为 ClassicsHeader
        refreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));

    }


    public void PostData(String start_time,String end_time){
        Patient_no = ((JcjyListActivity) getActivity()).getPatient_no();
        name = ((JcjyListActivity) getActivity()).getname();
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("patient_no", Patient_no); //住院号
        if (!Util.isEmpty(start_time)){
            params.put("start_date", start_time);
        }
        if (!Util.isEmpty(end_time)){
            params.put("end_date", end_time);
        }
        OkHttpManager.getInstance().postRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.getUsersAssayList, new LoadCallBack<String>(getActivity()) {
            @Override
            protected void onEror(okhttp3.Call call, int statusCode, Exception e) {
                showCenterToastCenter("网络不可用，请检查网络");
            }
            @Override
            protected void onSuccess(Call call, Response response, String s)  {
                Gson gson = new Gson();
                LogUtils.showLog(s.toString());
                if (s.contains("\"response\": \"ok\"")){
                    jyBean = gson.fromJson(s,JyBean.class);
                    beanList = jyBean.getData();
                    if (beanList.size() == 0){
                        no_data.setVisibility(View.VISIBLE);
                    }else
                        no_data.setVisibility(View.GONE);
                    mainAdapter = new JyDetailAdapter(getActivity(),beanList,name);
                    stickyListHeadersListView.setAdapter(mainAdapter);
                    //默认滑动一段距离   适配筛选图标显示隐藏
                    stickyListHeadersListView.setStickyHeaderTopOffset(1);
                    //设置头部改变的监听
                    stickyListHeadersListView.setOnStickyHeaderChangedListener(new StickyListHeadersListView.OnStickyHeaderChangedListener() {
                        @Override
                        public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
                            header.findViewById(R.id.jy_shaixuan).setVisibility(View.VISIBLE);
                        }
                    });
                }else {
                    LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                    showCenterToastCenter(loginBeanFail.getMessage());
                }
            }
        },params);
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
        if (flag.getFlag().equals("JY")){
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
