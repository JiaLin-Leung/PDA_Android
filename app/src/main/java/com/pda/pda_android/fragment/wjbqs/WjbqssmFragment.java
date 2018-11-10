package com.pda.pda_android.fragment.wjbqs;


import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pda.pda_android.R;

import androidx.fragment.app.Fragment;

/**
 * 无菌包签收扫码
 */

public class WjbqssmFragment extends Fragment {

    private LinearLayout scan_lin_out;//最外层正常布局
    private LinearLayout scan_response_lin;//最外层扫描时候的布局
    private RelativeLayout scan_response;//里层签收状态图片布局
    private ImageView wjbqs_ok;//签收成功的图片
    private ImageView wjbqs_fail;//签收失败的图片
    private ImageView wjbqs_agen;//重复签收的图片
    private TextView scan_name;//无菌包名字
    private TextView scan_code;//无菌包编号
    private TextView scan_data;//无菌包日期

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wjbqssm, container, false);
        initView(view);
        return view;
    }

    /**
     * 初始化控件
     * @param view
     */
    private void initView(View view) {

        scan_lin_out = view.findViewById(R.id.scan_lin_out);
        scan_response_lin = view.findViewById(R.id.scan_response_lin);
        scan_response = view.findViewById(R.id.scan_response);
        wjbqs_ok = view.findViewById(R.id.wjbqs_ok);
        wjbqs_fail = view.findViewById(R.id.wjbqs_fail);
        wjbqs_agen = view.findViewById(R.id.wjbqs_agen);
        scan_name = view.findViewById(R.id.scan_name);
        scan_code = view.findViewById(R.id.scan_code);
        scan_data = view.findViewById(R.id.scan_data);

    }

}
