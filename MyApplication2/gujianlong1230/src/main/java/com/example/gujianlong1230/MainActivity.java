package com.example.gujianlong1230;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gujianlong1230.adabter.MyAdapter;
import com.example.gujianlong1230.app.MyApp;
import com.example.gujianlong1230.base.BaseActivity;
import com.example.gujianlong1230.base.BasePresenter;
import com.example.gujianlong1230.bean.BannerBean;
import com.example.gujianlong1230.bean.UserBean;
import com.example.gujianlong1230.mvp.Presenter;
import com.example.gujianlong1230.utils.GlideUtils;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private List<BannerBean.ResultBean> bannerList = new ArrayList<>();
    private List<UserBean.ResultBean.MlssBean> list = new ArrayList<>();
    private XBanner xBanner;
    private MyAdapter myAdapter;


    @Override
    protected void startDing() {
        mPresenter.getInfo("http://172.17.8.100/small/commodity/v1/bannerShow");
        mPresenter.getInfo("http://172.17.8.100/small/commodity/v1/commodityList");
        myAdapter = new MyAdapter(list, this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        xBanner = findViewById(R.id.xb);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(final String url) {
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();
        BannerBean bannerBean = gson.fromJson(url, BannerBean.class);
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        bannerList.addAll(result);
        //xBanner.setBannerData(bannerList);
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
            }
        });
        UserBean userBean = gson.fromJson(url, UserBean.class);
        list.add(userBean.getResult().getMlss());
        myAdapter.notifyDataSetChanged();


    }

    @Override
    public void onError(Throwable throwable) {

    }
}
