package com.example.lianxi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.LoginBean;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.RegBean;
import com.example.lianxi2.mvp.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.button_deng)
    Button buttonDeng;
    @BindView(R.id.button_zhu)
    Button buttonZhu;

    @Override
    protected void startDing() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onRegSuccess(RegBean regBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegError(Throwable throwable) {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(Throwable throwable) {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }


    @OnClick({R.id.button_deng, R.id.button_zhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_deng:
                String phone = edtPhone.getText().toString();
                String pwd = edtPwd.getText().toString();
                //md5加密
                String s = EncryptUtils.encryptMD5ToString(pwd);
                s = s.substring(0, 6);
                mPresenter.getLogin(phone, s);
                break;
            case R.id.button_zhu:
                String phone1 = edtPhone.getText().toString();
                String pwd1 = edtPwd.getText().toString();
                //md5加密
                String s1 = EncryptUtils.encryptMD5ToString(pwd1);
                s1 = s1.substring(0, 6);
                mPresenter.getReg(phone1, s1);
                break;
        }
    }
}
