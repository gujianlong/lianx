package com.bawei.gujianlong2020218.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:10:28
 *@Description:
 * */


import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong2020218.R;
import com.bawei.gujianlong2020218.adapter.ShowAdapter;
import com.bawei.gujianlong2020218.base.BaseFragment;
import com.bawei.gujianlong2020218.base.BasePresenter;
import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;
import com.bawei.gujianlong2020218.mvp.Presenter;
import com.bawei.gujianlong2020218.utils.NetUtils;
import com.bawei.gujianlong2020218.weight.MyView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShowFragment extends BaseFragment {
    @BindView(R.id.a_rv)
    RecyclerView aRv;
    List<ShowBean.ResultBean> list = new ArrayList<>();
    @BindView(R.id.show_smart)
    SmartRefreshLayout showSmart;
    private ShowAdapter showAdapter;
    private int page = 1;

    @Override
    protected void initView(View inflate) {
        aRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        //支持上下拉
        showSmart.setEnableRefresh(true);
        showSmart.setEnableLoadMore(true);
        //设置上下拉监听
        showSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                page = 1;
                mPresenter.getShowData("板鞋", page, 5);
                showSmart.finishRefresh();
            }
        });
        showSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.getShowData("板鞋", page, 5);
                showSmart.finishLoadMore();
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.shou_fragment;
    }

    @Override
    protected void startDing() {

        if (NetUtils.getInstance().hasNet(getContext())) {
            mPresenter.getShowData("板鞋", page, 5);
            showAdapter = new ShowAdapter(getContext(), list);
            aRv.setAdapter(showAdapter);
        }else {
            Toast.makeText(getContext(), "没有网络", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onShowSuccess(ShowBean showBean) {
        list.addAll(showBean.getResult());
        showAdapter.notifyDataSetChanged();
    }

    @Override
    public void onShowError(Throwable throwable) {
        //Toast.makeText(getContext(), "获取失败" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }
}
