package com.example.gujianlong1230;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gujianlong1230.base.BaseActivity;
import com.example.gujianlong1230.base.BasePresenter;
import com.example.gujianlong1230.bean.BannerBean;
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.bean.DingBean;
import com.example.gujianlong1230.bean.OrderBean;
import com.example.gujianlong1230.bean.UserBean;
import com.example.gujianlong1230.mvp.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Order2Activity extends BaseActivity {


    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void startDing() {
        String key = getIntent().getStringExtra("key");
        price.setText(key);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_order2;
    }

    @Override
    public void onHomeSuccess(UserBean userBean) {

    }

    @Override
    public void onHomeError(Throwable throwable) {

    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {

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


    @OnClick(R.id.button)
    public void onViewClicked() {
        Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
    }
}
