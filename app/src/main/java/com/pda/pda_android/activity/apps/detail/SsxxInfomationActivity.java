package com.pda.pda_android.activity.apps.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.adapter.ssxx.SsxxDetailAdapter;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.FlagBean;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.db.Entry.CheckBean;
import com.pda.pda_android.db.Entry.SsxxBean;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.dbutil.SsxxBeanOpe;
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

import okhttp3.Call;
import okhttp3.Response;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


/**
 * 梁佳霖创建于：2018/10/30 15:28
 * 功能：手术信息二级页面
 */
public class SsxxInfomationActivity extends BaseActivity {

    private StickyListHeadersListView stickyListHeadersListView;
    private RefreshLayout refreshLayout;
    private  String patient_no;
    private SsxxDetailAdapter adapter;
    private UserBean userBean;
    private String record_no;
    private ImageView no_data;
    private TextView user_info;
    private List<com.pda.pda_android.bean.SsxxBean.DataBean> list;
    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxxinfomation;
    }

    @Override
    public void initView() {
        stickyListHeadersListView =  findViewById(R.id.ssxx_list_ssxx);
        refreshLayout = findViewById(R.id.refreshLayout1_ssxx);
        no_data = findViewById(R.id.no_data);
        user_info=findViewById(R.id.user_info);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(1500,true);
            }
        });
        //设置 Header 为 ClassicsHeader
        refreshLayout.setRefreshHeader(new ClassicsHeader(SsxxInfomationActivity.this));
        //默认滑动一段距离   适配筛选图标显示隐藏
        stickyListHeadersListView.setStickyHeaderTopOffset(1);
        //设置头部改变的监听
        stickyListHeadersListView.setOnStickyHeaderChangedListener(new StickyListHeadersListView.OnStickyHeaderChangedListener() {
            @Override
            public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
                header.findViewById(R.id.item_shaixuan).setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public void initData() {
        userBean = (UserBean) getIntent().getSerializableExtra("userBean");
        record_no = userBean.getRecord_no();
        patient_no=userBean.getPatient_no();
        PostData("","");
    }

    public void PostData(String start_time,String end_times){
        Map<String, String> params = new HashMap<>();
        params.put("patient_no", "ZY010000505789"); //住院号
        params.put("record_no", "0000505789"); //病历号
        OkHttpManager.getInstance().postRequest(SsxxInfomationActivity.this, ContentUrl.TestUrl_local + ContentUrl.getUsersSsxx, new LoadCallBack<String>(SsxxInfomationActivity.this) {

            @Override
            protected void onEror(Call call, int statusCode, Exception e) {
                super.onEror(call, statusCode, e);
                showCenterToastCenter("请求失败，请稍后重试");
            }

            @Override
            protected void onSuccess(Call call, Response response, String s)  {
                Gson gson = new Gson();
                if (s.contains("\"response\": \"ok\"")){
                    LogUtils.showLog(s.toString());
                    com.pda.pda_android.bean.SsxxBean ssxxBean = gson.fromJson(s,com.pda.pda_android.bean.SsxxBean.class);
                    list = ssxxBean.getData();
                    if (list.size() == 0){
                        no_data.setVisibility(View.VISIBLE);
                    }else{
                        String name=userBean.getBed_no()+"  "+userBean.getPatient_name();
                        user_info.setText(name);
                        adapter = new SsxxDetailAdapter(SsxxInfomationActivity.this,list,name);
                        stickyListHeadersListView.setAdapter(adapter);}
                }else {
                    LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                    showCenterToastCenter(loginBeanFail.getMessage());
                }
            }
        },params);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FlagBean flag) {
        if (flag.getFlag().equals("SSXX")){
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
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
