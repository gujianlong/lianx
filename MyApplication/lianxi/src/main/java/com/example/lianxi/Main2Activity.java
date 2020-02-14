package com.example.lianxi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.lianxi.adapter.MyAdapter;
import com.example.lianxi.base.BaseActivity;
import com.example.lianxi.base.BasePresenter;
import com.example.lianxi.bean.UserBean;
import com.example.lianxi.mvp.Presenter;
import com.example.lianxi.url.MyUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends BaseActivity {


    private RecyclerView recyclerView;
    private List<UserBean.OrderListBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        myAdapter = new MyAdapter(list, this);
        recyclerView.setAdapter(myAdapter);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "0");
        map.put("page", "1");
        map.put("count", "5");
        mPresenter.getInfoPramars(MyUrl.DINGBEAN, UserBean.class, map);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof UserBean) {
            list.addAll(((UserBean) o).getOrderList());
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
