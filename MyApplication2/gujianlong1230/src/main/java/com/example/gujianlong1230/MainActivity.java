package com.example.gujianlong1230;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gujianlong1230.adabter.MyAdapter;
import com.example.gujianlong1230.app.MyApp;
import com.example.gujianlong1230.base.BaseActivity;
import com.example.gujianlong1230.base.BasePresenter;
import com.example.gujianlong1230.bean.BannerBean;
import com.example.gujianlong1230.bean.UserBean;
import com.example.gujianlong1230.mvp.Presenter;
import com.example.gujianlong1230.url.MyUrl;
import com.example.gujianlong1230.utils.GlideUtils;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private List<BannerBean.ResultBean> bannerList = new ArrayList<>();
    private List<UserBean.ResultBean.MlssBean> mMlssList = new ArrayList<>();
    private List<UserBean.ResultBean.PzshBean> mPzshList = new ArrayList<>();
    private List<UserBean.ResultBean.RxxpBean> mRxxpList = new ArrayList<>();

    private XBanner xBanner;
    private MyAdapter myAdapter;


    @Override
    protected void startDing() {
        mPresenter.getInfo(MyUrl.BannerBean, BannerBean.class);
        mPresenter.getInfo(MyUrl.HomeBean, UserBean.class);
        myAdapter = new MyAdapter(this, mMlssList, mPzshList, mRxxpList);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        xBanner = findViewById(R.id.xb);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof BannerBean) {
            bannerList.addAll(((BannerBean) o).getResult());
            xBanner.setBannerData(bannerList);
            xBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(banner).load(bannerList.get(position).getImageUrl()).into((ImageView) view);
                }
            });
        }
        if (o instanceof UserBean) {
            mPzshList.add(((UserBean) o).getResult().getPzsh());
            mMlssList.add(((UserBean) o).getResult().getMlss());
            mRxxpList.add(((UserBean) o).getResult().getRxxp());
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
