package com.pda.pda_android.activity.apps.detail.jcjydetail;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.adapter.jcjy.JyDetailAdapter;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.JyBean;
import com.pda.pda_android.bean.JyDetailBean;
import com.pda.pda_android.db.Entry.AssayDetailBean;
import com.pda.pda_android.db.dbutil.AssayDetailDaoOpe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

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
//        assayDetailBeans=AssayDetailDaoOpe.queryAllByPatient_no(JyDetailActivity.this,patient_no);
        postdata();
    }
    public void postdata(){
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("sqxh", patient_no); //检查申请序号
        OkHttpManager.getInstance().postRequest(this, ContentUrl.TestUrl_local + ContentUrl.getUsersAssayListDetail, new LoadCallBack<String>(this) {
            @Override
            protected void onFailure(Call call, IOException e) {
                showShortToast("请求失败，请稍后重试");
            }
            @Override
            protected void onSuccess(Call call, Response response, String s)  {
                Gson gson = new Gson();
                LogUtils.showLog(s.toString());
                JyDetailBean jyDetailBean=gson.fromJson(s.toString(),JyDetailBean.class);
                if (jyDetailBean.getResponse().equals("ok")){
                    jy_data.setText(jyDetailBean.getData().getJcdate());
                    sq_data.setText(jyDetailBean.getData().getSqdate());
                    bg_data.setText(jyDetailBean.getData().getBgdate());
//                    jy_detail.setText(jyDetailBean.getData().get(0).getJg());
                }

            }
        },params);
    }
}
