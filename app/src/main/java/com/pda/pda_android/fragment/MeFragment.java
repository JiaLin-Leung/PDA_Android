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
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.utils.Util;

/**
 * 梁佳霖创建于：2018/10/17 15:07
 * 功能：
 */
public class MeFragment extends BaseFragment {
    /**
     * 版本号
     */
    private TextView ver_code;
    /**
     * 护士病区
     */
    private LinearLayout layoutChangeBingqu;
    /**
     * 更改密码
     */
    private LinearLayout layout_password;
    /**
     * 检测更新
     */
    private LinearLayout layoutCheckVersion;
    /**
     * 退出按钮
     */
    private Button btnQuit;

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
        layoutChangeBingqu = view.findViewById(R.id.layoutChangeBingqu);
        layout_password = view.findViewById(R.id.layout_password);
        layoutCheckVersion = view.findViewById(R.id.layout_check_version);
        btnQuit = view.findViewById(R.id.btn_quit);
        layoutChangeBingqu.setOnClickListener(this);
        layout_password.setOnClickListener(this);
        layoutCheckVersion.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        ver_code.setText("当前版本号" + Util.getLocalVersionName(getActivity()));
    }

    @Override
    public int getlayout() {
        return R.layout.fragment_me_content;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.layoutChangeBingqu:
                //切换病区
                LogUtils.showLog("111111111","layoutChangeBingqu");
                break;
            case R.id.layout_password:
                //更改密码
                LogUtils.showLog("111111111","layout_password");
                break;
            case R.id.layout_check_version:
                showVersionDialog(getActivity(),null,1);
                break;
        }
    }
}
