package com.bawei.zhangsan20191224;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.zhangsan20191224.base.BaseActivity;
import com.bawei.zhangsan20191224.base.BasePresenter;
import com.bawei.zhangsan20191224.bean.DengBean;
import com.bawei.zhangsan20191224.bean.ZhuBean;
import com.bawei.zhangsan20191224.mvp.Presenter;
import com.bawei.zhangsan20191224.url.MyUrl;
import com.bawei.zhangsan20191224.utils.MD5Utils;

import java.util.HashMap;
import java.util.Map;

public class ZhuCeActivity extends BaseActivity {


    private EditText z_phone;
    private EditText z_pwd;
    private Button z_zhu;

    @Override
    protected void startDing() {
        z_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = MD5Utils.getMd5("123");
                Log.e("a", "onClick: " + string);
                String z_phone = ZhuCeActivity.this.z_phone.getText().toString().trim();
                String z_pwd = ZhuCeActivity.this.z_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(z_phone) && TextUtils.isEmpty(z_pwd)) {
                    Toast.makeText(ZhuCeActivity.this, "手机号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Map<String, Object> map = new HashMap<>();
                    map.put("phone", z_pwd);
                    map.put("pwd", z_pwd);
                    mPresenter.onPostInfo(MyUrl.ZHUBEAN, DengBean.class, map);
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
        z_phone = findViewById(R.id.edit_phone);
        z_pwd = findViewById(R.id.edit_pwd);
        z_zhu = findViewById(R.id.z_zhu);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_zhu_ce;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof ZhuBean) {
            if (((ZhuBean) o).getStatus().equals("0000")) {
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ZhuCeActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "该账号已被注册", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
