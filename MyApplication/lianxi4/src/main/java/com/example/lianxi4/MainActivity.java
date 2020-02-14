package com.example.lianxi4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.accounts.NetworkErrorException;
import android.os.Bundle;
import android.view.View;

import com.example.lianxi4.adapter.OneAdapter;
import com.example.lianxi4.adapter.TwoAdapter;
import com.example.lianxi4.base.BaseActivity;
import com.example.lianxi4.base.BasePresenter;
import com.example.lianxi4.bean.UserBean;
import com.example.lianxi4.mvp.Presenter;
import com.example.lianxi4.url.MyUrl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView one_rv;
    private RecyclerView two_rv;
    private OneAdapter oneAdapter;
    private TwoAdapter twoAdapter;
    private List<UserBean.ResultBean> oneList = new ArrayList<>();
    private List<UserBean.ResultBean.SecondCategoryVoBean> twoList = new ArrayList<>();

    @Override
    protected void startDing() {
        oneAdapter = new OneAdapter(oneList, this);
        one_rv.setAdapter(oneAdapter);
        twoAdapter = new TwoAdapter(twoList, this);
        two_rv.setAdapter(twoAdapter);
        mPresenter.onGetInfo(MyUrl.HOMEBEAN, UserBean.class);
        oneAdapter.setItemClick(new OneAdapter.ItemClick() {
            @Override
            public void onItemClick(int position) {
                twoList.clear();
                twoList.addAll(oneList.get(position).getSecondCategoryVo());
                twoAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        one_rv = findViewById(R.id.one_rv);
        two_rv = findViewById(R.id.two_rv);
        one_rv.setLayoutManager(new LinearLayoutManager(this));
        two_rv.setLayoutManager(new GridLayoutManager(this, 3));
}

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof UserBean) {
            oneList.addAll(((UserBean) o).getResult());
            oneAdapter.notifyDataSetChanged();
            twoList.addAll(oneList.get(0).getSecondCategoryVo());
            twoAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
