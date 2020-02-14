package com.bawei.zhangsan20191224;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.zhangsan20191224.base.BaseActivity;
import com.bawei.zhangsan20191224.base.BasePresenter;
import com.bawei.zhangsan20191224.bean.DengBean;
import com.bawei.zhangsan20191224.mvp.Presenter;
import com.bawei.zhangsan20191224.url.MyUrl;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {


    private EditText d_phone;
    private EditText d_pwd;
    private Button d_deng;
    private Button d_zhu;
    private SharedPreferences sp;

    @Override
    protected void startDing() {
        d_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = d_phone.getText().toString().trim();
                String pwd = d_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone) && TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "手机号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Map<String, Object> map = new HashMap<>();
                    map.put("phone", phone);
                    map.put("pwd", pwd);
                    mPresenter.onPostInfo(MyUrl.DENGBEAN, DengBean.class, map);
                }
            }
        });
        d_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZhuCeActivity.class);
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
        d_phone = findViewById(R.id.edit_phone);
        d_pwd = findViewById(R.id.edit_pwd);
        d_deng = findViewById(R.id.d_deng);
        d_zhu = findViewById(R.id.d_zhu);
        sp = getSharedPreferences("gjl", MODE_PRIVATE);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof DengBean) {
            if (((DengBean) o).getStatus().equals("0000")) {
                sp.edit().putString("userId", ((DengBean) o).getResult().getUserId() + "").commit();
                sp.edit().putString("sessionId", ((DengBean) o).getResult().getSessionId() + "").commit();
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
