package com.pda.pda_android.fragment.wjbqs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pda.pda_android.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import androidx.fragment.app.Fragment;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * 无菌包签收已确认
 */

public class WjbqssdFragment extends Fragment {
    private RefreshLayout refreshLayout;
    private StickyListHeadersListView stickyListHeadersListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_wjbqssd, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        refreshLayout=view.findViewById(R.id.refreshLayout1);
        stickyListHeadersListView=view.findViewById(R.id.wsjqs_sd_list);
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

}
