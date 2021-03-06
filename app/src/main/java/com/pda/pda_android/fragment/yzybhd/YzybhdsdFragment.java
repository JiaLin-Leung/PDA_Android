package com.pda.pda_android.fragment.yzybhd;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.adapter.wjbqs.WjbqsDetailAdapter;
import com.pda.pda_android.adapter.yzybhd.YzybhdDetailAdapter;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.bean.WjbqsBean;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

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
 * 医嘱药包核对手动确认
 */
public class YzybhdsdFragment extends Fragment {
    private RefreshLayout refreshLayout;
    private StickyListHeadersListView stickyListHeadersListView;
    public YzybhdDetailAdapter mainAdapter;
    private List<WjbqsBean.WjbqsBeanListBean> wjbqsBeanListBeans = new ArrayList<>();
    private WjbqsBean wjbqsBean;
    private View view;
    private ImageView no_data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_yzybhdsd, container, false);
        return view;
    }

    public void initData() {
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("page", 1+""); //将姓名参数添加到数据包
        OkHttpManager.getInstance().postRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.getNotSignedList, new LoadCallBack<String>(getActivity()) {
            @Override
            protected void onEror(Call call, int statusCode, Exception e) {
                super.onEror(call, statusCode, e);
            }

            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                Gson gson = new Gson();
                wjbqsBean = gson.fromJson(s,WjbqsBean.class);
                wjbqsBeanListBeans = wjbqsBean.getData();
                if (wjbqsBeanListBeans.size()==0){
                    no_data.setVisibility(View.VISIBLE);
                }
                mainAdapter = new YzybhdDetailAdapter(getActivity(),wjbqsBeanListBeans);
                stickyListHeadersListView.setAdapter(mainAdapter);
            }
        },params);
    }
    private void init(View view) {
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            init(view);
            initData();
        }
    }
}
