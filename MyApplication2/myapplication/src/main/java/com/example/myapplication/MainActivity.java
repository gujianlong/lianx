package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adabter.MyAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.bean.Bean;
import com.example.myapplication.mvp.Presenter;
import com.example.myapplication.url.MyUrl;
import com.example.myapplication.utils.NetUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {


    private Button button;
    private RecyclerView recyclerView;
    private List<BannerBean.ResultBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        mPresenter.getInfo(MyUrl.BANNERBEAN, BannerBean.class);
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof BannerBean) {
            list.addAll(((BannerBean) o).getResult());
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
