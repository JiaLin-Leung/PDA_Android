package com.pda.pda_android.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pda.pda_android.R;

/**
 * 梁佳霖创建于：2018/10/15 15:54
 * 功能：
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getlayout(), container, false);
        initView(view);
        initData();
        return view;
    }

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化控件
     * @param view
     */
    public abstract void initView(View view);

    /**
     * 设置页面xml
     * @return
     */
    public abstract int getlayout();


    @Override
    public void onClick(View view) {

    }
}
