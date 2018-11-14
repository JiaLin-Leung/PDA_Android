package com.pda.pda_android.fragment.yzzx;

import android.view.View;
import android.widget.ImageView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseFragment;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * @author：DBJ
 * @data: 2018/11/14 11:50
 * @Description:医嘱执行处置
 */
public class YzzxczFragment extends BaseFragment {

    private StickyListHeadersListView stickyListHeadersListView;

    //下拉控件
    private RefreshLayout refreshLayout;

    private ImageView no_data;


    @Override
    public void initData() {
        PostData("","");
        //默认滑动一段距离   适配筛选图标显示隐藏
        stickyListHeadersListView.setStickyHeaderTopOffset(1);
        //设置头部改变的监听
        stickyListHeadersListView.setOnStickyHeaderChangedListener(new StickyListHeadersListView.OnStickyHeaderChangedListener() {
            @Override
            public void onStickyHeaderChanged(StickyListHeadersListView l, View header, int itemPosition, long headerId) {
//                header.findViewById(R.id.jc_shaixuan).setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * @param start_time 起始时间
     * @param end_time 结束时间
     */

    public void PostData(String start_time,String end_time){

    }
    @Override
    public void initView(View view) {
        //初始化
        stickyListHeadersListView =  view.findViewById(R.id.yzzxcz_list);
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
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_yzzxcz;
    }

}
