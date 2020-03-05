package com.bawei.gujianlong20200224.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:14:02
 *@Description:
 * */


import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong20200224.R;
import com.bawei.gujianlong20200224.adapter.UserTwoAdapter;
import com.bawei.gujianlong20200224.base.BaseFragment;
import com.bawei.gujianlong20200224.base.BasePresenter;
import com.bawei.gujianlong20200224.bean.UserBean;
import com.bawei.gujianlong20200224.bean.UserTwoBean;
import com.bawei.gujianlong20200224.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UserTwoFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    private int type = 2;
    private int page = 1;
    List<UserTwoBean.ResultBean> list=new ArrayList<>();
    private UserTwoAdapter userTwoAdapter;

    @Override
    protected void initView(View inflate) {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.usertwo_frag;
    }

    @Override
    protected void startDing() {
        mPresenter.getDataUserTwo(11, "158252187763511", type, page, 5);
        userTwoAdapter = new UserTwoAdapter(list,getContext());
        rv.setAdapter(userTwoAdapter);
    }


    @Override
    public void onUserSuccess(UserBean userBean) {

    }

    @Override
    public void onUserErrey(Throwable throwable) {

    }

    @Override
    public void onUserTwoSuccess(UserTwoBean userTwoBean) {
        list.addAll(userTwoBean.getResult());
        userTwoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onUserTwoErrey(Throwable throwable) {

    }
}
