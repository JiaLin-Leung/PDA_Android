package com.pda.pda_android.activity.apps.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.adapter.ssxx.SsxxDetailAdapter;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.bean.SsxxDetailBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 梁佳霖创建于：2018/10/31 09:33
 * 功能：手术信息详情页面
 */
public class SsxxInfomationDetailActivity extends BaseActivity {

    private ImageView iv_top_back;
    private TextView username_badnum,ops_num,ops_staue,bxbh,ops_name,ops_dj,ops_bm,docter,
            yy_time,dj_time,end_time,sq_code,out_ops_time,inpacu_time,outpacu_time,operdiag_after,
            mzys_name,mzfs,xhhs_code,sequence_no,oper_roomno,tv_top_sure,ops_time;
    private String name,id;
    private SsxxDetailBean ssxxBeanListBean;

    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxxinfomationdetail;
    }

    @Override
    public void initView() {
        id =  getIntent().getStringExtra("id");
        name=getIntent().getStringExtra("name");
        iv_top_back = findViewById(R.id.iv_top_back);
        username_badnum = findViewById(R.id.tv_top_title);
        tv_top_sure=findViewById(R.id.tv_top_sure);
        ops_num=findViewById(R.id.ops_num);
        ops_staue=findViewById(R.id.ops_staue);
        bxbh=findViewById(R.id.bxbh);
        ops_name=findViewById(R.id.ops_name);
        ops_dj=findViewById(R.id.ops_dj);
        ops_bm=findViewById(R.id.ops_bm);
        docter=findViewById(R.id.docter);
        yy_time=findViewById(R.id.yy_time);
        dj_time=findViewById(R.id.dj_time);
        end_time=findViewById(R.id.end_time);
        sq_code=findViewById(R.id.sq_code);
        out_ops_time=findViewById(R.id.out_ops_time);
        inpacu_time=findViewById(R.id.inpacu_time);
        outpacu_time=findViewById(R.id.outpacu_time);
        mzfs=findViewById(R.id.mzfs);
        mzys_name=findViewById(R.id.mzys_name);
        operdiag_after=findViewById(R.id.operdiag_after);
        xhhs_code=findViewById(R.id.xhhs_code);
        sequence_no=findViewById(R.id.sequence_no);
        oper_roomno=findViewById(R.id.oper_roomno);
        ops_time=findViewById(R.id.ops_time);
        tv_top_sure.setVisibility(View.GONE);
        iv_top_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SsxxInfomationDetailActivity.this.finish();
            }
        });
        username_badnum.setText(name);

    }

    @Override
    public void initData() {
        postdata();
    }

    public void postdata(){
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("oper_id", id);
        OkHttpManager.getInstance().postRequest(this, ContentUrl.TestUrl_local + ContentUrl.getUsersSsxxDetail, new LoadCallBack<String>(this) {

            @Override
            protected void onEror(Call call, int statusCode, Exception e) {
                super.onEror(call, statusCode, e);
                showCenterToastCenter("请求失败，请稍后重试");
            }

            @Override
            protected void onSuccess(Call call, Response response, String s)  {
                Gson gson = new Gson();
                if (s.contains("\"response\": \"ok\"")){
                    LogUtils.showLog(s.toString());
                    ssxxBeanListBean=gson.fromJson(s.toString(),SsxxDetailBean.class);
                    if (null!=ssxxBeanListBean.getData().getOperxh()){
                        ops_num.setText(ssxxBeanListBean.getData().getOperxh());
                    }
                    if (null!=ssxxBeanListBean.getData().getOper_code()){
                        ops_bm.setText(ssxxBeanListBean.getData().getOper_code());
                    }
                    if (null!=ssxxBeanListBean.getData().getOperscale()){
                        ops_dj.setText(ssxxBeanListBean.getData().getOperscale());
                    }
                    if (null!=ssxxBeanListBean.getData().getOper_name()){
                        ops_name.setText(ssxxBeanListBean.getData().getOper_name());
                    }
                    if (null!=ssxxBeanListBean.getData().getOperstate()){
                        ops_staue.setText(ssxxBeanListBean.getData().getOperstate());
                    }
                    if (null!=ssxxBeanListBean.getData().getWard_code()){
                        bxbh.setText(ssxxBeanListBean.getData().getWard_code());
                    }
                    if (null!=ssxxBeanListBean.getData().getSurgeon_name()){
                        docter.setText(ssxxBeanListBean.getData().getSurgeon_name());
                    }
                    if (null!=ssxxBeanListBean.getData().getYytime()){
                        yy_time.setText(ssxxBeanListBean.getData().getYytime());
                    }
                    if (null!=ssxxBeanListBean.getData().getDjtime()){
                        dj_time.setText(ssxxBeanListBean.getData().getDjtime());
                    }
                    if (null!=ssxxBeanListBean.getData().getEndoper_time()){
                        end_time.setText(ssxxBeanListBean.getData().getEndoper_time());
                    }
                    if (null!=ssxxBeanListBean.getData().getHisappform()){
                        sq_code.setText(ssxxBeanListBean.getData().getHisappform());
                    }
                    if (null!=ssxxBeanListBean.getData().getOutoper_time()){
                        out_ops_time.setText(ssxxBeanListBean.getData().getOutoper_time());
                    }
                    if (null!=ssxxBeanListBean.getData().getInpacu_time()){
                        inpacu_time.setText(ssxxBeanListBean.getData().getInpacu_time());
                    }
                    if (null!=ssxxBeanListBean.getData().getOutpacu_time()){
                        outpacu_time.setText(ssxxBeanListBean.getData().getOutpacu_time());
                    }
                    if (null!=ssxxBeanListBean.getData().getMzfs()){
                        mzfs.setText(ssxxBeanListBean.getData().getMzfs());
                    }
                    if (null!=ssxxBeanListBean.getData().getMzys_name()){
                        mzys_name.setText(ssxxBeanListBean.getData().getMzys_name());
                    }
                    if (null!=ssxxBeanListBean.getData().getOperdiag_after()){
                        operdiag_after.setText(ssxxBeanListBean.getData().getOperdiag_after());
                    }
                    if (null!=ssxxBeanListBean.getData().getXhhs_name()){
                        xhhs_code.setText(ssxxBeanListBean.getData().getXhhs_name());
                    }
                    if (null!=ssxxBeanListBean.getData().getSequence_no()){
                        sequence_no.setText(ssxxBeanListBean.getData().getSequence_no());
                    }
                    if (null!=ssxxBeanListBean.getData().getOper_roomno()){
                        oper_roomno.setText(ssxxBeanListBean.getData().getOper_roomno());
                    }
                    if (null!=ssxxBeanListBean.getData().getInoper_time()){
                        ops_time.setText(ssxxBeanListBean.getData().getInoper_time());
                    }
                }else {
                    LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                    showCenterToastCenter(loginBeanFail.getMessage());
                }
            }
        },params);
    }
}
