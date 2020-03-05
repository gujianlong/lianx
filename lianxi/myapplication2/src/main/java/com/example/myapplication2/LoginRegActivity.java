package com.example.myapplication2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.example.myapplication2.base.BaseActivity;
import com.example.myapplication2.base.BasePresenter;
import com.example.myapplication2.bean.LoginBean;
import com.example.myapplication2.bean.RegBean;
import com.example.myapplication2.mvp.LoginRegPresenter;


import butterknife.BindView;
import butterknife.OnClick;

public class LoginRegActivity extends BaseActivity {


    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.deng)
    Button deng;
    @BindView(R.id.zhu)
    Button zhu;

    @Override
    protected void startDing() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new LoginRegPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login_reg;
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Intent intent = new Intent(LoginRegActivity.this, Main2Activity.class);
        startActivity(intent);
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(Throwable throwable) {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegSuccess(RegBean regBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegError(Throwable throwable) {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.deng, R.id.zhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.deng:
                String s = phone.getText().toString();
                String s1 = pwd.getText().toString();
                String a = EncryptUtils.encryptMD5ToString(s1);
                a = a.substring(0, 6);
                mPresenter.getDataLogin(s,a);
                break;
            case R.id.zhu:
                String p = phone.getText().toString();
                String p1 = pwd.getText().toString();
                String a1 = EncryptUtils.encryptMD5ToString(p1);
                a1 = a1.substring(0, 6);
                mPresenter.getDataReg(p,a1);
                break;
        }
    }
}
