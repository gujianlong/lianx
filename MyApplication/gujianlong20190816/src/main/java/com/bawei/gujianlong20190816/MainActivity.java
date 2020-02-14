package com.bawei.gujianlong20190816;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.gujianlong20190816.base.BaseActivity;
import com.bawei.gujianlong20190816.base.BasePresenter;
import com.bawei.gujianlong20190816.bean.DengBean;
import com.bawei.gujianlong20190816.mvp.Presenter;
import com.bawei.gujianlong20190816.url.MyUrl;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private Button button;
    private EditText phone;
    private EditText pwd;
    private SharedPreferences sp;

    @Override
    protected void startDing() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = MainActivity.this.phone.getText().toString().trim();
                String pwd = MainActivity.this.pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone) && TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "手机号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Map<String, Object> map = new HashMap<>();
                map.put("phone", phone);
                map.put("pwd", pwd);
                mPresenter.onPostInfo(MyUrl.DENGBEAN, DengBean.class, map);
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        sp = getSharedPreferences("gjl", MODE_PRIVATE);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof DengBean && ((DengBean) o).getStatus().equals("0000")) {
            //sp.getString("userId", ((DengBean) o).getResult().getUserId() + "").isEmpty();
            //sp.getString("sessionId", ((DengBean) o).getResult().getSessionId() + "").isEmpty();
            sp.edit().putString("userId", ((DengBean) o).getResult().getUserId() + "").commit();
            sp.edit().putString("sessionId", ((DengBean) o).getResult().getSessionId() + "").commit();
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onError(String error) {

    }
}
