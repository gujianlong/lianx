package com.example.gujianlong221.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/21
 *@Time:13:44
 *@Description:
 * */


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong221.R;
import com.example.gujianlong221.adapter.MlssAdapter;
import com.example.gujianlong221.adapter.PxxpAdapter;
import com.example.gujianlong221.adapter.PzshAdapter;
import com.example.gujianlong221.base.BaseFragment;
import com.example.gujianlong221.base.BasePresenter;
import com.example.gujianlong221.bean.LoginBean;
import com.example.gujianlong221.bean.RegBean;
import com.example.gujianlong221.bean.UserBean;
import com.example.gujianlong221.mvp.LoginRegPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShouFragment extends BaseFragment {

    @BindView(R.id.rv01)
    RecyclerView rv01;
    @BindView(R.id.rv02)
    RecyclerView rv02;
    @BindView(R.id.rv03)
    RecyclerView rv03;
    List<UserBean.ResultBean.MlssBean.CommodityListBeanXX> mMlss = new ArrayList<>();
    List<UserBean.ResultBean.PzshBean.CommodityListBeanX> mPzsh = new ArrayList<>();
    List<UserBean.ResultBean.RxxpBean.CommodityListBean> mPxxp = new ArrayList<>();
    private PxxpAdapter mPxxpAdapter;
    private MlssAdapter mMlssAdapter;
    private PzshAdapter mPzshAdapter;

    @Override
    protected void initView(View inflate) {
        rv01.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv02.setLayoutManager(new LinearLayoutManager(getContext()));
        rv03.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new LoginRegPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.shou_frag;
    }


    @Override
    protected void startDing() {
        mPresenter.getDataUser();

        mPxxpAdapter = new PxxpAdapter(getContext(),mPxxp);
        rv01.setAdapter(mPxxpAdapter);
        mMlssAdapter = new MlssAdapter(getContext(),mMlss);
        rv02.setAdapter(mMlssAdapter);
        mPzshAdapter = new PzshAdapter(getContext(),mPzsh);
        rv03.setAdapter(mPzshAdapter);
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
        mPxxp.clear();
        mPxxp.addAll(userBean.getResult().getRxxp().getCommodityList());
        mPxxpAdapter.notifyDataSetChanged();
        mMlss.clear();
        mMlss.addAll(userBean.getResult().getMlss().getCommodityList());
        mMlssAdapter.notifyDataSetChanged();
        mPzsh.clear();
        mPzsh.addAll(userBean.getResult().getPzsh().getCommodityList());
        mPzshAdapter.notifyDataSetChanged();

    }

    @Override
    public void onUserError(Throwable throwable) {
        Toast.makeText(getContext(), ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
