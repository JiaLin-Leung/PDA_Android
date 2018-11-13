package com.pda.pda_android.activity.me;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.activity.LoginActivity;
import com.pda.pda_android.base.AppManager;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.base.utils.SpUtils;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.bean.Nursebean;
import com.pda.pda_android.utils.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 梁佳霖创建于：2018/10/18 15:00
 * 功能：修改密码页面
 */
public class ChangePasswordActivity extends BaseActivity {

    private ImageView pass_back;
    private EditText et_newword;
    private EditText sure_newword;
    private Button bt_confirm_password;
    private ImageView iv_clear_newword;
    private ImageView iv_clear_surepasw;

    @Override
    public int setLayoutId() {
        return R.layout.activity_password;
    }

    @Override
    public void initView() {
        pass_back = findViewById(R.id.pass_back);
        et_newword = findViewById(R.id.et_newword);
        sure_newword = findViewById(R.id.sure_newword);
        iv_clear_surepasw = findViewById(R.id.iv_clear_surepasw);
        iv_clear_newword = findViewById(R.id.iv_clear_newword);
        bt_confirm_password = findViewById(R.id.bt_confirm_password);
        initTextChanged();
        pass_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePasswordActivity.this.finish();
            }
        });
    }

    private void initTextChanged() {
        //密码框监听
        sure_newword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    iv_clear_surepasw.setVisibility(View.VISIBLE);
                } else {
                    iv_clear_surepasw.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                Util.bt_isselecter(bt_confirm_password, et_newword, sure_newword);
            }
        });
        //账号框输入监听
        et_newword.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.length() != 0) {
                    iv_clear_newword.setVisibility(View.VISIBLE);
                } else {
                    iv_clear_newword.setVisibility(View.GONE);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                Util.bt_isselecter(bt_confirm_password, et_newword, sure_newword);
            }
        });
        iv_clear_surepasw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sure_newword.setText("");
            }
        });
        iv_clear_newword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_newword.setText("");
            }
        });
    }

    @Override
    public void initData() {
        bt_confirm_password.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (et_newword.getText().toString().equals(sure_newword.getText().toString())){
                    Map<String, String> params = new HashMap<>(); //提交数据包
                    params.put("password", et_newword.getText().toString()); //确认新密码
                    OkHttpManager.getInstance().postRequest(ChangePasswordActivity.this, ContentUrl.TestUrl_local +
                            ContentUrl.setPass, new LoadCallBack<String>(ChangePasswordActivity.this) {
                        @Override
                        protected void onEror(Call call, int statusCode, Exception e) {
                            super.onEror(call, statusCode, e);
                            showCenterToastCenter("网络不可用，请检查网络");
                        }

                        @Override
                        protected void onSuccess(Call call, Response response, String s) throws IOException {
                            Gson gson = new Gson();
                            if (s.contains("\"response\": \"ok\"")){
                                showCenterToastCenter("修改成功！");
                                AppManager.getAppManager().finishAllActivity();
                                Intent intent = new Intent();
                                intent.setClass(ChangePasswordActivity.this,LoginActivity.class);
                                startActivity(intent);
                                SpUtils.getInstance(ChangePasswordActivity.this).clear(ChangePasswordActivity.this);
                            }else{
                                LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                                showCenterToastCenter(loginBeanFail.getMessage());
                            }
                        }
                    },params);
                }else{
                    Toast.makeText(ChangePasswordActivity.this,"两次输入密码不一致！",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}
