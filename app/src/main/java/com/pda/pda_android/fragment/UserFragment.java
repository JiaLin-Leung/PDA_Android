package com.pda.pda_android.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;

import androidx.annotation.Nullable;

/**
 * 梁佳霖创建于：2018/10/11 14:26
 * 功能：
 */
public class UserFragment extends BaseFragment {
    public static UserFragment newInstance(String s) {
        UserFragment userFragment = new UserFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ContentUrl.ARGS, s);
        userFragment.setArguments(bundle);
        return userFragment;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(View view) {
        TextView textView = view.findViewById(R.id.fragment_text_view);
        textView.setText("哈哈哈哈");
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_user_content;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.showLog("生命周期-----"+"user onResume");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtils.showLog("user现在的现隐形-----"+hidden);
    }
}
