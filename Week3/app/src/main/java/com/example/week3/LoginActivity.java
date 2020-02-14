package com.example.week3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.example.week3.base.BaseActivity;
import com.example.week3.base.BasePresenter;
import com.example.week3.bean.CartBean;
import com.example.week3.bean.LoginBean;
import com.example.week3.bean.RegisterBean;
import com.example.week3.mvp.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.button_deng)
    Button buttonDeng;
    @BindView(R.id.button_zhu)
    Button buttonZhu;

    @Override
    protected void startDing() {
        buttonDeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edPhone.getText().toString();
                String pwd = edPwd.getText().toString();
                String s = EncryptUtils.encryptMD5ToString(pwd);
                mPresenter.postInfoLogin(phone, s);
            }
        });
        buttonZhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone1 = edPhone.getText().toString();
                String pwd1 = edPwd.getText().toString();
                String s1 = EncryptUtils.encryptMD5ToString(pwd1);
                mPresenter.postInfoRegister(phone1, s1);
            }
        });
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
        return R.layout.activity_login;
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        if ("0000".equals(loginBean.getStatus())) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("key", loginBean.getResult().getHeadPic());
            startActivity(intent);
        } else {
            Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onLoginError(Throwable throwable) {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        if ("0000".equals(registerBean.getStatus())) {
            Toast.makeText(this, "注册成功,请登录", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRegisterError(Throwable throwable) {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCartSuccess(CartBean cartBean) {

    }

    @Override
    public void onCartError(Throwable throwable) {

    }
}
