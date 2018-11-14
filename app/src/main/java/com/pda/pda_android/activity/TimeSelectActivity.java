package com.pda.pda_android.activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.bean.FlagBean;
import com.pda.pda_android.utils.Util;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author：DBJ
 * @data: 2018/11/13 19:47
 * @Description:时间筛选
 */

public class TimeSelectActivity extends BaseActivity {
    private LinearLayout time_ln;
    private LinearLayout range_ln;
    private LinearLayout ll_top_sure,ll_top_back;
    private TextView time_text,start_time,end_time;
    private RadioGroup rg;
    private String flag;
    private  TimePickerView pvTime;
    private int index=1;     //1 时间   2  范围
    @Override
    public int setLayoutId() {
        return R.layout.activity_time_select;
    }

    @Override
    public void initView() {
        rg=findViewById(R.id.rg);
        ll_top_back=findViewById(R.id.ll_top_back);
        ll_top_sure=findViewById(R.id.ll_top_sure);
        time_ln=findViewById(R.id.time_ln);
        range_ln=findViewById(R.id.range_ln);
        time_text=findViewById(R.id.time_text);
        start_time=findViewById(R.id.start_time);
        end_time=findViewById(R.id.end_time);
    }

    @Override
    public void initData() {
        if (null!=getIntent()){
            flag=getIntent().getStringExtra("flag");
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_time:
                        index=1;
                        range_ln.setVisibility(View.GONE);
                        time_ln.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_range:
                        index=2;
                        range_ln.setVisibility(View.VISIBLE);
                        time_ln.setVisibility(View.GONE);
                        break;
                }
            }
        });
        ll_top_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ll_top_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index==1){
                    if (Util.isEmpty(time_text.getText().toString())){
                        showCenterToastCenter("请选择时间");
                        return;
                    }
                } else if (index==2){
                    if (Util.isEmpty(start_time.getText().toString())||Util.isEmpty(end_time.getText().toString())){
                        showCenterToastCenter("请选择时间");
                        return;
                    }
                }
                FlagBean flagBean=new FlagBean();
                if (flag.equals("JC")){
                    flagBean.setFlag("JC");
                    if (index==1){
                        flagBean.setEnd_time("");
                        flagBean.setStart_time(time_text.getText().toString());
                    }else if (index==2){
                        flagBean.setEnd_time(end_time.getText().toString());
                        flagBean.setStart_time(start_time.getText().toString());
                    }
                    EventBus.getDefault().post(flagBean);
                    finish();
                }else if (flag.equals("WJBQSEND")){
                    flagBean.setFlag("WJBQSEND");
                    if (index==1){
                        flagBean.setEnd_time("");
                        flagBean.setStart_time(time_text.getText().toString());
                    }else if (index==2){
                        flagBean.setEnd_time(end_time.getText().toString());
                        flagBean.setStart_time(start_time.getText().toString());
                    }
                    EventBus.getDefault().post(flagBean);
                    finish();
                }else if (flag.equals("JY")){
                    flagBean.setFlag("JY");
                    if (index==1){
                        flagBean.setEnd_time("");
                        flagBean.setStart_time(time_text.getText().toString());
                    }else if (index==2){
                        flagBean.setEnd_time(end_time.getText().toString());
                        flagBean.setStart_time(start_time.getText().toString());
                    }
                    EventBus.getDefault().post(flagBean);
                    finish();
                }else if (flag.equals("WJBQSSD")){
                    flagBean.setFlag("WJBQSSD");
                    if (index==1){
                        flagBean.setEnd_time("");
                        flagBean.setStart_time(time_text.getText().toString());
                    }else if (index==2){
                        flagBean.setEnd_time(end_time.getText().toString());
                        flagBean.setStart_time(start_time.getText().toString());
                    }
                    EventBus.getDefault().post(flagBean);
                    finish();
                }else if (flag.equals("SSXX")){
                    flagBean.setFlag("SSXX");
                    if (index==1){
                        flagBean.setEnd_time("");
                        flagBean.setStart_time(time_text.getText().toString());
                    }else if (index==2){
                        flagBean.setEnd_time(end_time.getText().toString());
                        flagBean.setStart_time(start_time.getText().toString());
                    }
                    EventBus.getDefault().post(flagBean);
                    finish();
                }
            }
        });
        Time_Onclick();
    }

    private void Time_Onclick() {
        time_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTimePop(time_text);
                pvTime.show();
            }
        });
        start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTimePop(start_time);
                pvTime.show();
            }
        });
        end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTimePop(end_time);
                pvTime.show();
            }
        });
    }
    public void ShowTimePop(final TextView view){
        //时间选择器
//        Calendar startDate = Calendar.getInstance();
//        Calendar endDate = Calendar.getInstance();

        //正确设置方式 原因：注意事项有说明
//        startDate.set(2018,0,1);
//        endDate.set(2018,11,13);

        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                view.setText(getTime(date));
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
//                .setRangDate(startDate,endDate)
                .build();
        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);
            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
            }
        }
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
