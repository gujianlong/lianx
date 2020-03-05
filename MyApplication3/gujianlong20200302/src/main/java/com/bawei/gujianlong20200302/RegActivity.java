package com.bawei.gujianlong20200302;
/*
 *@auther:谷建龙
 *@Date: 2020/3/2
 *@Time:13:49
 *@Description:
 * */


import com.bawei.gujianlong20200302.base.BaseActivity;
import com.bawei.gujianlong20200302.base.BasePresenter;
import com.bawei.gujianlong20200302.bean.LoginBean;
import com.bawei.gujianlong20200302.bean.RegBean;
import com.bawei.gujianlong20200302.bean.UserBean;

public class LoginActivity extends BaseActivity {
    @Override
    protected void startDing() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void onLoginErrro(Throwable throwable) {

    }

    @Override
    public void onRegSuccess(RegBean regBean) {

    }

    @Override
    public void onRegErrro(Throwable throwable) {

    }

    @Override
    public void onUserSuccess(UserBean userBean) {

    }

    @Override
    public void onUserErrro(Throwable throwable) {

    }
}
