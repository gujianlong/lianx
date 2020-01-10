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
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.bean.DingBean;
import com.example.gujianlong1230.bean.OrderBean;
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
    private List<UserBean.ResultBean.MlssBean> mMlssList = new ArrayList<>();
    private List<UserBean.ResultBean.PzshBean> mPzshList = new ArrayList<>();
    private List<UserBean.ResultBean.RxxpBean> mRxxpList = new ArrayList<>();

    private XBanner xBanner;
    private MyAdapter myAdapter;


    @Override
    protected void startDing() {
        mPresenter.getInfoBanner();
        mPresenter.getInfo();
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
    public void onHomeSuccess(UserBean userBean) {
        mPzshList.clear();
        mPzshList.add(userBean.getResult().getPzsh());
        mMlssList.clear();
        mMlssList.add(userBean.getResult().getMlss());
        mRxxpList.clear();
        mRxxpList.add(userBean.getResult().getRxxp());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onHomeError(Throwable throwable) {

    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        xBanner.setBannerData(result);
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(banner).load(result.get(position).getImageUrl()).into((ImageView) view);
            }
        });
    }

    @Override
    public void onBannerError(Throwable throwable) {

    }

    @Override
    public void onCartSuccess(CartBean cartBean) {

    }

    @Override
    public void onCartError(Throwable throwable) {

    }

    @Override
    public void onDingSuccess(DingBean dingBean) {

    }

    @Override
    public void onDingError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }
}
