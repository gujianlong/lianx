package com.bawei.gujianlong20190816;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.bawei.gujianlong20190816.adapter.MyAdapter;
import com.bawei.gujianlong20190816.base.BaseActivity;
import com.bawei.gujianlong20190816.base.BasePresenter;
import com.bawei.gujianlong20190816.bean.UserBean;
import com.bawei.gujianlong20190816.mvp.Presenter;
import com.bawei.gujianlong20190816.url.MyUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private List<UserBean.OrderListBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        map.put("page", 1);
        map.put("count", 5);
        mPresenter.onGetInfo(MyUrl.HOMEBEAN, UserBean.class, map);

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
        return R.layout.activity_list;
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
