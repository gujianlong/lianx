package com.example.gujianlong221.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/21
 *@Time:13:44
 *@Description:
 * */


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong221.R;
import com.example.gujianlong221.adapter.ViewAdapter;
import com.example.gujianlong221.base.BaseFragment;
import com.example.gujianlong221.base.BasePresenter;
import com.example.gujianlong221.bean.LoginBean;
import com.example.gujianlong221.bean.RegBean;
import com.example.gujianlong221.bean.UserBean;
import com.example.gujianlong221.mvp.LoginRegPresenter;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends BaseFragment {


    List<String> mList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ViewAdapter mViewAdapter;

    @Override
    protected void initView(View inflate) {
        mRecyclerView = inflate.findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new LoginRegPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.order_frag;
    }


    @Override
    protected void startDing() {
        for (int i = 0; i < 10; i++) {
            mList.add("李小二");
        }

        mViewAdapter = new ViewAdapter(mList,getContext());
        mRecyclerView.setAdapter(mViewAdapter);
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
