package com.pda.pda_android.activity.apps.detail.jcjydetail;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.AssayDetailBean;
import com.pda.pda_android.db.dbutil.AssayDetailDaoOpe;

import java.util.ArrayList;
import java.util.List;

/**
 * 检验结果页面
 */
public class JyDetailActivity extends BaseActivity {
    private TextView tv_top_title;
    private ImageView iv_top_back;
    private TextView jy_data;
    private TextView sq_data;
    private TextView bg_data;
    private TextView jy_detail;
    private  String patient_no,names;
    private List<AssayDetailBean> assayDetailBeans=new ArrayList<>();
    @Override
    public int setLayoutId() {
        return R.layout.activity_jy_detail;
    }

    @Override
    public void initView() {
        tv_top_title=findViewById(R.id.tv_top_title);
        iv_top_back=findViewById(R.id.iv_top_back);
        jy_data=findViewById(R.id.jy_data);
        sq_data=findViewById(R.id.sq_data);
        bg_data=findViewById(R.id.bg_data);
        jy_detail=findViewById(R.id.jy_detail);
        patient_no=getIntent().getStringExtra("Patient_no");
        names=getIntent().getStringExtra("name");
    }

    @Override
    public void initData() {
        iv_top_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_top_title.setText(names);
        assayDetailBeans=AssayDetailDaoOpe.queryAllByPatient_no(JyDetailActivity.this,patient_no);
        jy_data.setText(assayDetailBeans.get(0).getJydate());
        sq_data.setText(assayDetailBeans.get(0).getSqdate());
        bg_data.setText(assayDetailBeans.get(0).getBgdate());
    }

}
