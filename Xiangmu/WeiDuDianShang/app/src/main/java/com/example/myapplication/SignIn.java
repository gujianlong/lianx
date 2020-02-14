package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.DengBean;
import com.example.myapplication.mvp.Presenter;
import com.example.myapplication.url.MyUrl;

import java.util.HashMap;
import java.util.Map;

public class SignIn extends BaseActivity {


    private EditText Z_phone;
    private EditText Z_pwd;
    private SharedPreferences sp;
    private Button Z_button;
    private TextView segister;

    @Override
    protected void startDing() {
        Z_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = SignIn.this.Z_phone.getText().toString().trim();
                String pwd = SignIn.this.Z_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone) && TextUtils.isEmpty(pwd)) {
                    Toast.makeText(SignIn.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Map<String, Object> map = new HashMap<>();
                map.put("phone", phone);
                map.put("pwd", pwd);
                mPresenter.onPostInfoParams(MyUrl.DENGBASE, DengBean.class, map);
            }
        });
        segister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, Segister.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        Z_button = findViewById(R.id.SignIn_button);
        Z_phone = findViewById(R.id.SignIn_Phone);
        Z_pwd = findViewById(R.id.SignIn_pwd);
        segister = findViewById(R.id.SignIn_zhu);
        sp = getSharedPreferences("gjl", MODE_PRIVATE);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_sign_in;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof DengBean && ((DengBean) o).getStatus().equals("0000")) {
            sp.edit().putString("userId", ((DengBean) o).getResult().getUserId() + "").commit();
            sp.edit().putString("sessionId", ((DengBean) o).getResult().getSessionId() + "").commit();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignIn.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onError(String error) {

    }
}
