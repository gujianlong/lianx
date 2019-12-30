package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.MyAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.UserBean;
import com.example.myapplication.mvp.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.rv)
    RecyclerView rv;
    private List<UserBean.ResultBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        myAdapter = new MyAdapter(this, list);
        rv.setAdapter(myAdapter);
        mPresenter.getInfo("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=板鞋&page=1&count=5");
        myAdapter.setItemClick(new MyAdapter.ItemClick() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "跳转成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String url) {
        Gson gson = new Gson();
        UserBean userBean = gson.fromJson(url, UserBean.class);
        list.addAll(userBean.getResult());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable throwable) {

    }

}
