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
import com.example.myapplication.bean.ZhuCeBean;
import com.example.myapplication.mvp.Presenter;
import com.example.myapplication.url.MyUrl;

import java.util.HashMap;
import java.util.Map;

public class Segister extends BaseActivity {
    private EditText phone;
    private EditText pwd;
    private Button button;

    @Override
    protected void startDing() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = Segister.this.phone.getText().toString().trim();
                String pwd = Segister.this.pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone) && TextUtils.isEmpty(pwd)) {
                    Toast.makeText(Segister.this, "手机号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Map<String, Object> map = new HashMap<>();
                    map.put("phone", phone);
                    map.put("pwd", pwd);
                    mPresenter.onPostInfoParams(MyUrl.ZhuCe, ZhuCeBean.class, map);
                }
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.SignIn_button);
        phone = findViewById(R.id.SignIn_Phone);
        pwd = findViewById(R.id.SignIn_pwd);


    }

    @Override
    protected int layoutId() {
        return R.layout.activity_segister;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ZhuCeBean) {
            if (((ZhuCeBean) o).getMessage().equals("注册成功")) {
                Intent intent = new Intent(Segister.this, SignIn.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "该账号已被注册", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
