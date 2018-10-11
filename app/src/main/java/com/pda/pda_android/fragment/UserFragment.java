package com.pda.pda_android.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;

import androidx.annotation.Nullable;

/**
 * 梁佳霖创建于：2018/10/11 14:26
 * 功能：
 */
public class UserFragment extends Fragment {
    public static UserFragment newInstance(String s) {
        UserFragment userFragment = new UserFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ContentUrl.ARGS, s);
        userFragment.setArguments(bundle);
        return userFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_content, container, false);
        Bundle bundle = getArguments();
        LogUtils.showLog("生命周期-----"+"user onCreateView");
//        String s = bundle.getString(ContentUrl.ARGS);
//        TextView textView = (TextView) view.findViewById(R.id.fragment_text_view);
//        textView.setText(s);
        return view;
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
