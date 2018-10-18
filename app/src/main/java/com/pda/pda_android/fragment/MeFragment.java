package com.pda.pda_android.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseFragment;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.utils.Util;

/**
 * 梁佳霖创建于：2018/10/17 15:07
 * 功能：
 */
public class MeFragment extends BaseFragment {
    private TextView ver_code;
    private TextView tvChangeHeadFrame;
    private LinearLayout layoutAddChild;

    public static MeFragment newInstance(String s) {
        MeFragment meFragment = new MeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ContentUrl.ARGS, s);
        meFragment.setArguments(bundle);
        return meFragment;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(View view) {
        ver_code = view.findViewById(R.id.ver_code);
        tvChangeHeadFrame = view.findViewById(R.id.tv_change_head_frame);
        LinearLayout layoutChangeName = view.findViewById(R.id.layout_change_name);
        LinearLayout layoutChangePassword = view.findViewById(R.id.layout_change_password);
        layoutAddChild = view.findViewById(R.id.layout_add_child);
        LinearLayout layoutFeedback = view.findViewById(R.id.layout_feedback);
        LinearLayout layoutCheckVersion = view.findViewById(R.id.layout_check_version);
        Button btnQuit = view.findViewById(R.id.btn_quit);
        tvChangeHeadFrame.setOnClickListener(this);
        layoutChangeName.setOnClickListener(this);
        layoutChangePassword.setOnClickListener(this);
        layoutAddChild.setOnClickListener(this);
        layoutFeedback.setOnClickListener(this);
        layoutCheckVersion.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        ver_code.setText("当前版本号" + Util.getLocalVersionName(getActivity()));
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_me_content;
    }
}
