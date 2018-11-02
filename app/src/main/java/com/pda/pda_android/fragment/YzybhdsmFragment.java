package com.pda.pda_android.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pda.pda_android.R;
import androidx.fragment.app.Fragment;

/**
 * 医嘱药包核对扫码确认
 */
public class YzybhdsmFragment extends Fragment {
    private LinearLayout select_hz;
    private ImageView yzhz_code,yzpt_code;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_yzybhdsm, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        select_hz=view.findViewById(R.id.select_hz);
        yzhz_code=view.findViewById(R.id.yzhz_code);
        yzpt_code=view.findViewById(R.id.yzpt_code);
    }

}
