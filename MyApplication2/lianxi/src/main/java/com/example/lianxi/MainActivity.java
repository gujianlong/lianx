package com.example.lianxi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi.adapter.MyAdapter;
import com.example.lianxi.base.BaseActivity;
import com.example.lianxi.base.BasePresenter;
import com.example.lianxi.bean.UserBean;
import com.example.lianxi.mvp.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private List<UserBean.DataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        mPresenter.getInfoParams("http://blog.zhaoliang5156.cn/api/shop/fulishe1.json");
        myAdapter.setItemClick(new MyAdapter.ItemClick() {
            @Override
            public void onClick(int s) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String url) {
        Gson gson = new Gson();
        UserBean userBean = gson.fromJson(url, UserBean.class);
        list.addAll(userBean.getData());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable throwable) {

    }
}
