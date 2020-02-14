package com.example.lianxi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lianxi2.R;
import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.ZhuBean;
import com.example.lianxi2.mvp.Presenter;
import com.example.lianxi2.url.MyUrl;

import java.util.HashMap;
import java.util.Map;

public class register extends BaseActivity {


    private Button z_button;
    private EditText z_phone;
    private EditText z_pwd;

    @Override
    protected void startDing() {
        z_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = z_phone.getText().toString().trim();
                String pwd = z_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone)&&TextUtils.isEmpty(pwd)){
                    Toast.makeText(register.this, "手机号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Map<String,Object>map=new HashMap<>();
                    map.put("phone",phone);
                    map.put("pwd",pwd);
                    mPresenter.postInfoParams(MyUrl.ZHEBEAN, ZhuBean.class,map);
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
        z_pwd = findViewById(R.id.pwd);
        z_phone = findViewById(R.id.phone);
        z_button = findViewById(R.id.button);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ZhuBean){
            if (((ZhuBean) o).getMessage().equals("注册成功")){
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(register.this, Signin.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, "该账号已被注册", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
