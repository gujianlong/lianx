package com.bawei.gujianlong2020218.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:11:08
 *@Description:
 * */


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.gujianlong2020218.R;
import com.bawei.gujianlong2020218.adapter.OrderAdapter;
import com.bawei.gujianlong2020218.base.BaseFragment;
import com.bawei.gujianlong2020218.base.BasePresenter;
import com.bawei.gujianlong2020218.bean.JsonSqlite;
import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;
import com.bawei.gujianlong2020218.mvp.Presenter;
import com.bawei.gujianlong2020218.utils.NetUtils;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import gujianlong2020218.database.DaoMaster;
import gujianlong2020218.database.DaoSession;
import gujianlong2020218.database.JsonSqliteDao;


public class OrderfromFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    private int status = 0;
    private int page = 1;
    private JsonSqliteDao jsonSqliteDao;
    //private OrItAdapter orItAdapter;
    List<OrderBean.OrderListBean> list = new ArrayList<>();
    private OrderAdapter orderAdapter;


    @Override
    protected void initView(View inflate) {
        DaoSession daoSession = DaoMaster.newDevSession(getContext(), "a.db");
        jsonSqliteDao = daoSession.getJsonSqliteDao();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.orderfram_frag;
    }

    @Override
    protected void startDing() {

        Bundle arguments = getArguments();
        if (arguments != null) {
            status = arguments.getInt("status");
        }
        //判断是否有网
        if (NetUtils.getInstance().hasNet(getContext())) {
            mPresenter.getOrderData(27909, "158208796966027909", status, page, 5);
            orderAdapter = new OrderAdapter(getContext(), list);
            rv.setAdapter(orderAdapter);
        }else {
//            List<JsonSqlite> list1 = jsonSqliteDao.queryBuilder().list();
//            for (int i = 0; i < list1.size(); i++) {
//                JsonSqlite jsonSqlite = list1.get(i);
//                String json = jsonSqlite.getJson();
//                OrderBean orderBean = new Gson().fromJson(json, OrderBean.class);
//                List<OrderBean.OrderListBean> orderList = orderBean.getOrderList();
//                //设置适配器展示
//                rv.setAdapter(new OrderAdapter(getContext(), orderList));
//            }
            Toast.makeText(getContext(), "没有网络", Toast.LENGTH_SHORT).show();
        }


    }

    public static OrderfromFragment getInstance(int status) {
        OrderfromFragment orderfromFragment = new OrderfromFragment();
        Bundle bundle = new Bundle();
        bundle.getInt("status", status);
        orderfromFragment.setArguments(bundle);
        return orderfromFragment;
    }

    @Override
    public void onShowSuccess(ShowBean showBean) {

    }

    @Override
    public void onShowError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {
        list.addAll(orderBean.getOrderList());
        orderAdapter.notifyDataSetChanged();
    }

    @Override
    public void onOrderError(Throwable throwable) {
        Toast.makeText(getContext(), "获取失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
