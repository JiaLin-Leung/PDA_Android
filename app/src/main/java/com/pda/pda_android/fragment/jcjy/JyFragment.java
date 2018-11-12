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
import com.pda.pda_android.bean.JcBean;
import com.pda.pda_android.bean.JyBean;
import com.pda.pda_android.db.Entry.AssayBean;
import com.pda.pda_android.db.dbutil.AssayBeanOpe;
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
 * 检验
 */
public class JyFragment extends BaseFragment {
    private StickyListHeadersListView stickyListHeadersListView;
    private JyDetailAdapter mainAdapter;
    //下拉控件
    private RefreshLayout refreshLayout;
    //住院号  名字
    private  String Patient_no,name;
    private List<AssayBean> assayBeans;
    private ImageView no_data;
    private JyBean jyBean;
    private List<JyBean.DataBean> beanList;
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
//        assayBeans=  AssayBeanOpe.queryPATIENT_NO(getActivity(),Patient_no);
//        LogUtils.showLog("jy_shuju",assayBeans.toString());
//        if (assayBeans.size() == 0){
//            no_data.setVisibility(View.VISIBLE);
//        }else{
//            mainAdapter = new JyDetailAdapter(getActivity(),assayBeans,name);
//        }
//         设置头部的点击事件
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

//        stickyListHeadersListView.setAdapter(mainAdapter);
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_jy;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Patient_no = ((JcjyListActivity) context).getPatient_no();
        name = ((JcjyListActivity) context).getname();
    }
    public void postdata(){
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("patient_no", Patient_no); //住院号
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
                    jyBean = gson.fromJson(s,JyBean.class);
                    showCenterToastCenter(jyBean.getMessage());
                }
            }
        },params);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            postdata();
        }
    }
}
