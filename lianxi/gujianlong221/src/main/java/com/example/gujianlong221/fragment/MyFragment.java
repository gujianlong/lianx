package com.example.gujianlong221.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/21
 *@Time:13:44
 *@Description:
 * */


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gujianlong221.LoginRegActivity;
import com.example.gujianlong221.R;
import com.example.gujianlong221.base.BaseFragment;
import com.example.gujianlong221.base.BasePresenter;
import com.example.gujianlong221.bean.LoginBean;
import com.example.gujianlong221.bean.RegBean;
import com.example.gujianlong221.bean.UserBean;
import com.example.gujianlong221.mvp.LoginRegPresenter;
import com.example.gujianlong221.utils.GlideUtils;

import butterknife.BindView;

public class MyFragment extends BaseFragment {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.image)
    ImageView image;
    String str = "http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg";

    @Override
    protected void initView(View inflate) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginRegActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new LoginRegPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.my_frag;
    }


    @Override
    protected void startDing() {
        GlideUtils.loadImage(str, image);
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void onLoginError(Throwable throwable) {

    }

    @Override
    public void onRegSuccess(RegBean regBean) {

    }

    @Override
    public void onRegError(Throwable throwable) {

    }

    @Override
    public void onUserSuccess(UserBean userBean) {

    }

    @Override
    public void onUserError(Throwable throwable) {

    }
}
