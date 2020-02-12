package com.example.zuoye1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zuoye1.base.BaseActivity;
import com.example.zuoye1.base.BasePresenter;
import com.example.zuoye1.bean.CartBean;
import com.example.zuoye1.bean.LoginBean;
import com.example.zuoye1.bean.RegisterBean;
import com.example.zuoye1.mvp.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.d_button)
    Button dButton;
    @BindView(R.id.z_button)
    Button zButton;

    @Override
    protected void startDing() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("key", "");
        startActivity(intent);
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editPhone.getText().toString();
                String pwd = editPwd.getText().toString();
                mPresenter.postInfoLogin(phone, pwd);
            }
        });
        zButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone1 = editPhone.getText().toString();
                String pwd1 = editPwd.getText().toString();
                mPresenter.postInfoRegister(phone1, pwd1);
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
        //if ("0000".equals(loginBean.getStatus())) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("key", loginBean.getResult().getHeadPic());
        startActivity(intent);
        //   }else {
        //     Toast.makeText(this, "登录失败"+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        //  }


    }

    @Override
    public void onLoginError(Throwable throwable) {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        //if ("0000".equals(registerBean.getStatus())) {
        Toast.makeText(this, "注册成功,请登录", Toast.LENGTH_SHORT).show();
        //  }
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
