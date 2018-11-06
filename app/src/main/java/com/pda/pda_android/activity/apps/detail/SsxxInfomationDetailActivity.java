package com.pda.pda_android.activity.apps.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.db.Entry.SsxxBeanListBean;

/**
 * 梁佳霖创建于：2018/10/31 09:33
 * 功能：手术信息详情页面
 */
public class SsxxInfomationDetailActivity extends BaseActivity {

    private SsxxBeanListBean ssxxBeanListBean;
    private ImageView iv_top_back;
    private TextView username_badnum,ops_num,ops_staue,bxbh,ops_name,ops_dj,ops_bm,docter,
            yy_time,dj_time,end_time,sq_code,out_ops_time,inpacu_time,outpacu_time,operdiag_after,
            mzys_name,mzfs,xhhs_code,sequence_no,oper_roomno,tv_top_sure;
    private String name;
    @Override
    public int setLayoutId() {
        return R.layout.activity_ssxxinfomationdetail;
    }

    @Override
    public void initView() {
        ssxxBeanListBean = (SsxxBeanListBean) getIntent().getSerializableExtra("SsxxBeanListBean");
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
        ops_num.setText(ssxxBeanListBean.getOperxh());
        ops_bm.setText(ssxxBeanListBean.getOper_code());
        ops_dj.setText(ssxxBeanListBean.getOperscale());
        ops_name.setText(ssxxBeanListBean.getOper_name());
        ops_staue.setText(ssxxBeanListBean.getOperstate());
        bxbh.setText(ssxxBeanListBean.getWard_code());
        docter.setText(ssxxBeanListBean.getSurgeon_name());
        yy_time.setText(ssxxBeanListBean.getYytime());
        dj_time.setText(ssxxBeanListBean.getDjtime());
        end_time.setText(ssxxBeanListBean.getEndoper_time());
        sq_code.setText("");
        out_ops_time.setText(ssxxBeanListBean.getOutoper_time());
        inpacu_time.setText(ssxxBeanListBean.getInpacu_time());
        outpacu_time.setText(ssxxBeanListBean.getOutpacu_time());
        mzfs.setText(ssxxBeanListBean.getMzfs());
        mzys_name.setText(ssxxBeanListBean.getMzys_name());
        operdiag_after.setText(ssxxBeanListBean.getOperdiag_after());
        xhhs_code.setText(ssxxBeanListBean.getXhhs_name());
        sequence_no.setText(ssxxBeanListBean.getSequence_no());
        oper_roomno.setText(ssxxBeanListBean.getOper_roomno());
    }
}
