package com.pda.pda_android.fragment.jcjy;

import freemarker.template.utility.StringUtil;
import okhttp3.Call;
import okhttp3.Response;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

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
import com.pda.pda_android.adapter.wjbqs.WjbqsEndDetailAdapter;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.FlagBean;
import com.pda.pda_android.bean.JcBean;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.bean.WjbEndBean;
import com.pda.pda_android.db.Entry.CheckBean;
import com.pda.pda_android.db.dbutil.CheckBeanOpe;
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

/**
 * 检查
 */
public class JcFragment extends BaseFragment {

    private StickyListHeadersListView stickyListHeadersListView;
    private JcDetailAdapter mainAdapter;
    //下拉控件
    private RefreshLayout refreshLayout;
    //    private  List<CheckBean> checkBeanList=new ArrayList<>();
    //床位 患者名字
    private  String cw,name;
    private ImageView no_data;
    private JcBean jcBean;
    private List<JcBean.DataBean> list;
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
//        checkBeanList = CheckBeanOpe.queryRecord_no(getActivity(),cw);
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
        postdata("","");
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
                header.findViewById(R.id.jc_shaixuan).setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * @param start_time 起始时间
     * @param end_time 结束时间
     */
    public void postdata(String start_time,String end_time){
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("record_no", cw); //病历号
        if (!Util.isEmpty(start_time)){
            params.put("start_date", start_time);
        }
        if (!Util.isEmpty(end_time)){
            params.put("end_date", end_time);
        }
        OkHttpManager.getInstance().postRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.getUsersCheckList, new LoadCallBack<String>(getActivity()) {
            @Override
            protected void onEror(okhttp3.Call call, int statusCode, Exception e) {
                showCenterToastCenter("网络不可用，请检查网络");
            }
            @Override
            protected void onSuccess(Call call, Response response, String s)  {
                Gson gson = new Gson();
                if (s.contains("\"response\": \"ok\"")){
                    LogUtils.showLog(s.toString());
                    jcBean = gson.fromJson(s,JcBean.class);
                    list = jcBean.getData();
                    if (list.size() == 0){
                        no_data.setVisibility(View.VISIBLE);
                    }else
                        no_data.setVisibility(View.GONE);
                    mainAdapter = new JcDetailAdapter(getActivity(),list,name);
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

    }
    @Override
    public int getlayout() {
        return R.layout.fragment_jc;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FlagBean flag) {
        if (flag.getFlag().equals("jc")){
            postdata(flag.getStart_time(),"");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }
}
