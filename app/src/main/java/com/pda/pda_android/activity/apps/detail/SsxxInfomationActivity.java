package com.pda.pda_android.activity.apps.detail;

import android.view.View;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.adapter.ssxx.SsxxDetailAdapter;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.CheckBean;
import com.pda.pda_android.db.Entry.SsxxBean;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.dbutil.SsxxBeanOpe;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


/**
 * 梁佳霖创建于：2018/10/30 15:28
 * 功能：手术信息二级页面
 */
public class SsxxInfomationActivity extends BaseActivity {

    private StickyListHeadersListView stickyListHeadersListView;
    private RefreshLayout refreshLayout;
    private  String cw;
    private SsxxDetailAdapter adapter;
    private UserBean userBean;
    private String record_no;
    private List<SsxxBean> list;
    private TextView no_data;

    private TextView user_info;
    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxxinfomation;
    }

    @Override
    public void initView() {
        stickyListHeadersListView =  findViewById(R.id.ssxx_list_ssxx);
        refreshLayout = findViewById(R.id.refreshLayout1_ssxx);
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
        list = SsxxBeanOpe.queryRecord_no(SsxxInfomationActivity.this,record_no);
        if (list.size() == 0){
            no_data.setVisibility(View.VISIBLE);
        }else{
            adapter = new SsxxDetailAdapter(SsxxInfomationActivity.this,list,userBean.getPatient_name());
            stickyListHeadersListView.setAdapter(adapter);
        }
        String name=userBean.getBed_no()+"  "+userBean.getPatient_name();
        user_info.setText(name);
        adapter = new SsxxDetailAdapter(SsxxInfomationActivity.this,list,name);
        stickyListHeadersListView.setAdapter(adapter);
    }
}
