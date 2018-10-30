package com.pda.pda_android.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        loginButton = findViewById(R.id.loginButton);
    }

    @Override
    public void initData() {
        okHttpManager = OkHttpManager.getInstance();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.loginButton:
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
            protected void onFailure(Call call, IOException e) {

            }
            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                if (s.contains("\"response\": \"ok\"")){
                    SpUtils.save("is_frist",1); //进入首页存储标记
                    LoginBean loginBean = gson.fromJson(s,LoginBean.class);
                    SpUtils.save("nis_token",loginBean.getData().getNis_token());
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_LONG).show();
                }else{
                    LoginBeanFail loginBeanFail = gson.fromJson(s,LoginBeanFail.class);
                    Toast.makeText(LoginActivity.this,loginBeanFail.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        },params);
    }

    public static void goLoginAcvtivity(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}
