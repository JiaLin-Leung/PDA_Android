package com.pda.pda_android.activity;

import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pda.pda_android.R;
import com.pda.pda_android.base.BaseActivity;
import com.pda.pda_android.base.network.LoadCallBack;
import com.pda.pda_android.base.network.OkHttpManager;
import com.pda.pda_android.base.others.ContentUrl;
import com.pda.pda_android.base.utils.LogUtils;

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
                String accountTxtBase64 = Base64.encodeToString(username.getBytes(), Base64.DEFAULT);
                String passwTxtTxtBase64 = Base64.encodeToString(password.getBytes(), Base64.DEFAULT);
                login(accountTxtBase64,passwTxtTxtBase64);
                break;
        }
    }

    /**
     * 登录方法
     */
    private void login(String username,String password) {

        Map<String, String> params = new HashMap<>(); //提交数据包
        params.put("phone", username); //将姓名参数添加到数据包
        params.put("password", password); //将密码参数添加到数据包
        params.put("user_type", 1 + ""); //用户类型: 1-学生, 3-教师
        OkHttpManager.getInstance().postRequest(LoginActivity.this, ContentUrl.testUrl + ContentUrl.stu_login, new LoadCallBack<String>(LoginActivity.this) {
            @Override
            protected void onFailure(Call call, IOException e) {

            }

            @Override
            protected void onSuccess(Call call, Response response, String s) throws IOException {
                LogUtils.showLog("信息信息信息信息",s);
            }
        },params);
    }
}
