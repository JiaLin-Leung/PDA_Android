package com.pda.pda_android.activity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;
import com.pda.pda_android.base.utils.SpUtils;
import com.pda.pda_android.bean.LoginBean;
import com.pda.pda_android.bean.LoginBeanFail;
import com.pda.pda_android.utils.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    private EditText ed_username;
    private EditText ed_password;
    private Button loginButton;
    private String username;
    private String password;
    private OkHttpManager okHttpManager;
    private Gson gson;
    private ImageView iv_clear_phone;
    private ImageView iv_clear_pasw;
    private long firstTime=0;

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        ed_username = findViewById(R.id.login_account);
        ed_password = findViewById(R.id.login_pasw);
        loginButton = findViewById(R.id.login_btn);
        iv_clear_phone = findViewById(R.id.iv_clear_phone);
        iv_clear_pasw = findViewById(R.id.iv_clear_pasw);
        Util.bt_isselecter(loginButton, ed_username, ed_password);
        initTextChanged();
    }

    @Override
    public void initData() {
        okHttpManager = OkHttpManager.getInstance();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.login_btn:
                username = ed_username.getText().toString();
                password = ed_password.getText().toString();
                login(username,password);
                break;
        }
    }

    /**
     * 登录方法
     */
    private void login(String username,String password) {

        gson = new Gson();
        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("code", username); //将姓名参数添加到数据包
        params.put("password", password); //将密码参数添加到数据包
        OkHttpManager.getInstance().postRequest(LoginActivity.this, ContentUrl.TestUrl_local + ContentUrl.login, new LoadCallBack<String>(LoginActivity.this) {
            @Override
            protected void onEror(okhttp3.Call call, int statusCode, Exception e) {
                showCenterToastCenter("网络不可用，请检查网络");
            }
            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                if (s.contains("\"response\": \"ok\"")){
                    SpUtils.save("is_frist",1); //进入首页存储标记
                    LoginBean loginBean = gson.fromJson(s,LoginBean.class);
                    SpUtils.save("nis_token",loginBean.getData().getNis_token());
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    LoginActivity.this.finish();
                    showCenterToastCenter("登录成功！");
                }else{
                    LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                    showCenterToastCenter(loginBeanFail.getMessage());
                }
            }
        },params);
    }

    public static void goLoginAcvtivity(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }

    private void initTextChanged() {
        //密码框监听
        ed_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    iv_clear_pasw.setVisibility(View.VISIBLE);
                } else {
                    iv_clear_pasw.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                Util.bt_isselecter(loginButton, ed_username, ed_password);
            }
        });
        //账号框输入监听
        ed_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.length() != 0) {
                    iv_clear_phone.setVisibility(View.VISIBLE);
                } else {
                    iv_clear_phone.setVisibility(View.GONE);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                Util.bt_isselecter(loginButton, ed_username, ed_password);
            }
        });
        iv_clear_pasw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_password.setText("");
            }
        });
        iv_clear_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_username.setText("");
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== android.view.KeyEvent.KEYCODE_BACK && event.getAction()== android.view.KeyEvent.ACTION_DOWN){
            if (System.currentTimeMillis()-firstTime>2000){
                Toast.makeText(LoginActivity.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                firstTime=System.currentTimeMillis();
            }else{
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
