package com.pda.pda_android.activity.apps.detail.jcjydetail;
import android.widget.ImageView;
import android.widget.TextView;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
/**
 * 检验结果页面
 */
public class JyDetailActivity extends BaseActivity {
    private TextView tv_top_title;
    private ImageView iv_top_back;
    private TextView jc_data;
    private TextView sq_data;
    private TextView bg_data;
    private TextView jy_detail;

    @Override
    public int setLayoutId() {
        return R.layout.activity_jy_detail;
    }

    @Override
    public void initView() {
        tv_top_title=findViewById(R.id.tv_top_title);
        iv_top_back=findViewById(R.id.iv_top_back);
        jc_data=findViewById(R.id.jc_data);
        sq_data=findViewById(R.id.sq_data);
        bg_data=findViewById(R.id.bg_data);
        jy_detail=findViewById(R.id.jy_detail);
    }

    @Override
    public void initData() {

    }
}
