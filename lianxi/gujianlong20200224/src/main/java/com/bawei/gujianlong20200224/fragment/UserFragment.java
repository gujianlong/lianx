package com.bawei.gujianlong20200224.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:14:02
 *@Description:
 * */


import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong20200224.R;
import com.bawei.gujianlong20200224.adapter.UserAdapter;
import com.bawei.gujianlong20200224.base.BaseFragment;
import com.bawei.gujianlong20200224.base.BasePresenter;
import com.bawei.gujianlong20200224.bean.UserBean;
import com.bawei.gujianlong20200224.bean.UserTwoBean;
import com.bawei.gujianlong20200224.mvp.Presenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UserFragment extends BaseFragment {
    @BindView(R.id.rvs)
    RecyclerView rvs;
    List<UserBean.ResultBean> list = new ArrayList<>();
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private UserAdapter userAdapter;
    private int type = 1;
    private int page = 1;

    @Override
    protected void initView(View inflate) {
        rvs.setLayoutManager(new LinearLayoutManager(getContext()));
        smart.finishRefresh(true);
        smart.finishLoadMore(true);
        smart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                page = 1;
                list.clear();
                mPresenter.getDataUser(11, "158252187763511", type, page, 5);
                smart.finishRefresh();
            }
        });
        smart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.getDataUser(11, "158252187763511", type, page, 5);
                smart.finishLoadMore();
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.user_frag;
    }

    @Override
    protected void startDing() {
        mPresenter.getDataUser(11, "158252187763511", type, page, 5);
        userAdapter = new UserAdapter(getContext(), list);
        rvs.setAdapter(userAdapter);
    }


    @Override
    public void onUserSuccess(UserBean userBean) {
        list.addAll(userBean.getResult());
        userAdapter.notifyDataSetChanged();
    }

    @Override
    public void onUserErrey(Throwable throwable) {
        Toast.makeText(getContext(), "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserTwoSuccess(UserTwoBean userTwoBean) {

    }

    @Override
    public void onUserTwoErrey(Throwable throwable) {

    }
}
