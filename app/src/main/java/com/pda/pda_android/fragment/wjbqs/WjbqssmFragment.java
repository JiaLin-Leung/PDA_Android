package com.pda.pda_android.fragment.wjbqs;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.apps.detail.JcjyListActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.bean.ScanUserBean;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.bean.ScanWjbqsBean;
import com.pda.pda_android.bean.WjbqsFailBean;
import com.pda.pda_android.bean.WjbqsOkBean;
import com.pda.pda_android.db.Entry.UserBean;
import com.pda.pda_android.db.dbutil.UserDaoOpe;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.Fragment;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 无菌包签收扫码
 */

public class WjbqssmFragment extends Fragment {

    private static final int RETURNTONORMAL_FAIL =  10101;
    private static final int RETURNTONORMAL_OK =  10102;
    private LinearLayout scan_lin_out;//最外层正常布局
    private LinearLayout scan_response_lin;//最外层扫描时候的布局
    private RelativeLayout scan_response;//里层签收状态图片布局
    private LinearLayout response_infomatino;//里层签收状态图片布局
    private ImageView wjbqs_ok;//签收成功的图片
    private ImageView wjbqs_fail;//签收失败的图片
    private ImageView wjbqs_agen;//重复签收的图片
    private TextView scan_name;//无菌包名字
    private TextView scan_code;//无菌包编号
    private TextView scan_data;//无菌包日期
    private IntentFilter intentFilter;
    private WjbqsBroadcastReceiver wjbqsBroadcastReceiver;
    private Gson gson;
    private WjbqsFailBean wjbqsFailBean;
    private WjbqsOkBean wjbqsOkBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wjbqssm, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        gson = new Gson();
        intentFilter = new IntentFilter(ContentUrl.ACTION);   // 设置广播接收器的信息过滤器，
        wjbqsBroadcastReceiver = new WjbqsBroadcastReceiver();
        getActivity().registerReceiver(wjbqsBroadcastReceiver, intentFilter);
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
        response_infomatino = view.findViewById(R.id.response_infomatino);

    }

    /**
     * 接收PDA扫描的广播
     */
    class WjbqsBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getStringExtra("data");
            Gson gson = new Gson();
            ScanWjbqsBean scanWjbqsBean = gson.fromJson(name,ScanWjbqsBean.class);
            if (scanWjbqsBean != null && !TextUtils.isEmpty(scanWjbqsBean.getBarcode())){
                postDataToServer(scanWjbqsBean.getBarcode());
            }else{
                Toast.makeText(getActivity(),"缺少参数code！",Toast.LENGTH_LONG).show();
            }
        }
    }


    /**
     * 扫描签收
     * @param code 无菌包code值
     */
    private void postDataToServer(String code) {

        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("barcode", code); //将code参数添加到数据包
        OkHttpManager.getInstance().postRequest(getActivity(), ContentUrl.TestUrl_local + ContentUrl.postScanWjbqs, new LoadCallBack<String>(getActivity()) {
            @Override
            protected void onFailure(Call call, IOException e) {

            }

            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                if (s.contains("\"response\": \"ok\"")){ //说明签收签收成功
                    wjbqsOkBean = gson.fromJson(s,WjbqsOkBean.class);
                    if (wjbqsOkBean != null && !TextUtils.isEmpty(wjbqsOkBean.getData().getCode())
                                && !TextUtils.isEmpty(wjbqsOkBean.getData().getName())
                            && !TextUtils.isEmpty(wjbqsOkBean.getData().getSend_date())){
                        scan_lin_out.setVisibility(View.GONE);
                        scan_response_lin.setVisibility(View.VISIBLE);
                        response_infomatino.setVisibility(View.VISIBLE);
                        wjbqs_ok.setVisibility(View.VISIBLE);
                        scan_name.setText(wjbqsOkBean.getData().getName());
                        scan_code.setText(wjbqsOkBean.getData().getCode());
                        scan_data.setText(wjbqsOkBean.getData().getSend_date());
                        handler.sendEmptyMessageDelayed(RETURNTONORMAL_OK,2000);
                    }
                }else{
                    wjbqsFailBean = gson.fromJson(s,WjbqsFailBean.class);
                    if (wjbqsFailBean != null && !TextUtils.isEmpty(wjbqsFailBean.getData().getType())){
                        switch (wjbqsFailBean.getData().getType()){
                            case 1+"": //说明是物品不存在，并且签收失败，最外层布局隐藏，显示签收布局
                                scan_lin_out.setVisibility(View.GONE);
                                scan_response_lin.setVisibility(View.VISIBLE);
                                wjbqs_fail.setVisibility(View.VISIBLE);
                                response_infomatino.setVisibility(View.GONE);
                                handler.sendEmptyMessageDelayed(RETURNTONORMAL_FAIL,2000);
                                break;
                            case 2+"": //说明该物品已签收，并且签收失败
                                scan_lin_out.setVisibility(View.GONE);
                                scan_response_lin.setVisibility(View.VISIBLE);
                                wjbqs_agen.setVisibility(View.VISIBLE);
                                response_infomatino.setVisibility(View.GONE);
                                handler.sendEmptyMessageDelayed(RETURNTONORMAL_FAIL,2000);
                                break;
                            case 3+"": //说明该物品不属于当前科室，并且签收失败
                                scan_lin_out.setVisibility(View.GONE);
                                scan_response_lin.setVisibility(View.VISIBLE);
                                wjbqs_fail.setVisibility(View.VISIBLE);
                                response_infomatino.setVisibility(View.GONE);
                                handler.sendEmptyMessageDelayed(RETURNTONORMAL_FAIL,2000);
                                break;
                        }
                    }
                }
            }
        },params);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case RETURNTONORMAL_FAIL:
                        scan_lin_out.setVisibility(View.VISIBLE);
                        scan_response_lin.setVisibility(View.GONE);
                        wjbqs_agen.setVisibility(View.GONE);
                        response_infomatino.setVisibility(View.VISIBLE);
                    break;
                case RETURNTONORMAL_OK:
                    scan_lin_out.setVisibility(View.VISIBLE);
                    scan_response_lin.setVisibility(View.GONE);
                    response_infomatino.setVisibility(View.GONE);
                    wjbqs_ok.setVisibility(View.GONE);
                    break;
                default:
                        scan_lin_out.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(wjbqsBroadcastReceiver);
    }
}
