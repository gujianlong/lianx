package com.bawei.zhangsan20191224;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.bawei.zhangsan20191224.adapter.MyAdapter;
import com.bawei.zhangsan20191224.base.BaseActivity;
import com.bawei.zhangsan20191224.base.BasePresenter;
import com.bawei.zhangsan20191224.bean.UserBean;
import com.bawei.zhangsan20191224.mvp.Presenter;
import com.bawei.zhangsan20191224.url.MyUrl;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<UserBean.OrderDataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        mPresenter.onGetInfo(MyUrl.HOMEBEAN, UserBean.class);
        myAdapter.setItemClick(new MyAdapter.ItemClick() {
            @Override
            public void setBigIndex(int setIndex) {
                boolean b = myAdapter.bigIndex(setIndex);
                myAdapter.setBigIndex(setIndex, !b);
                myAdapter.notifyDataSetChanged();
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof UserBean) {
            list.addAll(((UserBean) o).getOrderData());
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
