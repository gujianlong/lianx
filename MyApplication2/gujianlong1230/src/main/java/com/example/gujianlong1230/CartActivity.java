package com.example.gujianlong1230;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.gujianlong1230.adabter.CartAdapter;
import com.example.gujianlong1230.base.BaseActivity;
import com.example.gujianlong1230.base.BasePresenter;
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.mvp.Presenter;
import com.example.gujianlong1230.url.MyUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartActivity extends BaseActivity {


    private ExpandableListView elv;
    private List<CartBean.ResultBean> list = new ArrayList<>();
    private CartAdapter cartAdapter;

    @Override
    protected void startDing() {
        Map<String, Object> map = new HashMap();
        map.put("sessionId", "157835847656211357");
        map.put("userId", "11357");
        mPresenter.getInfoParam(MyUrl.CartBean, map, CartBean.class);
        cartAdapter = new CartAdapter(this, list);
        elv.setAdapter(cartAdapter);
        for (int i = 0; i < list.size(); i++) {
            elv.expandGroup(i);
        }
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        elv = findViewById(R.id.elv);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_gouwuche;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof CartBean) {
            list.addAll(((CartBean) o).getResult());
            cartAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
