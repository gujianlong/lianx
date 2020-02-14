package com.example.lianxi2;

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

import com.example.lianxi2.app.MyApp;
import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.DengBean;
import com.example.lianxi2.fragment.HomeFragment;
import com.example.lianxi2.mvp.Presenter;
import com.example.lianxi2.url.MyUrl;

import java.util.HashMap;
import java.util.Map;

public class Signin extends BaseActivity {


    private Button d_button;
    private EditText d_phone;
    private EditText d_pwd;
    private TextView d_deng;
    private SharedPreferences sp;

    @Override
    protected void startDing() {

        d_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = d_phone.getText().toString().trim();
                String pwd = d_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone) && TextUtils.isEmpty(pwd)) {
                    Toast.makeText(Signin.this, "请输入正确的手机号和密码", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Map<String, Object> map = new HashMap<>();
                    map.put("phone", phone);
                    map.put("pwd", pwd);
                    mPresenter.postInfoParams(MyUrl.DENGBEAN, DengBean.class, map);
                }
            }
        });
        d_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this, register.class);
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
        d_button = findViewById(R.id.button);
        d_phone = findViewById(R.id.phone);
        d_pwd = findViewById(R.id.pwd);
        d_deng = findViewById(R.id.zhuce);
        sp = getSharedPreferences("gjl", MODE_PRIVATE);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_signin;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof DengBean) {
            if (((DengBean) o).getStatus().equals("0000")) {
                sp.edit().putString("userId", ((DengBean) o).getResult().getUserId() + "").commit();
                sp.edit().putString("sessionId", ((DengBean) o).getResult().getSessionId() + "").commit();
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Signin.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
