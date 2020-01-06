package com.example.week;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.week.adapter.OneAdapter;
import com.example.week.adapter.ThreeAdapter;
import com.example.week.adapter.TwoAdapter;
import com.example.week.base.BaseActivity;
import com.example.week.base.BasePresenter;
import com.example.week.bean.ItemBean;
import com.example.week.bean.UserBean;
import com.example.week.mvp.Presenter;
import com.example.week.url.MyUrl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private List<UserBean.ResultBean> oneList = new ArrayList<>();
    private List<UserBean.ResultBean.SecondCategoryVoBean> twoList = new ArrayList<>();
    private List<ItemBean.ResultBean> threeList = new ArrayList<>();
    private RecyclerView one_rv;
    private RecyclerView two_rv;
    private OneAdapter oneAdapter;
    private TwoAdapter twoAdapter;
    private RecyclerView three_rv;
    private ThreeAdapter threeAdapter;
    private Map<String, Object> map;

    @Override
    protected void startDing() {
        mPresenter.getInfo();
        map = new HashMap<>();
        map.put("categoryId", 1001002);
        map.put("page", 1);
        map.put("count", 10);

        oneAdapter = new OneAdapter(oneList, this);
        one_rv.setAdapter(oneAdapter);
        twoAdapter = new TwoAdapter(twoList, this);
        two_rv.setAdapter(twoAdapter);
        threeAdapter = new ThreeAdapter(threeList, this);
        three_rv.setAdapter(threeAdapter);
        oneAdapter.setItemClick(new OneAdapter.ItemClick() {
            @Override
            public void onClick(int position) {
                oneAdapter.setColorItem(position);
                twoList.clear();
                twoList.addAll(oneList.get(position).getSecondCategoryVo());
                twoAdapter.notifyDataSetChanged();
            }
        });
        twoAdapter.setItemClict(new TwoAdapter.ItemClict() {
            @Override
            public void onClick(int position) {
                twoAdapter.setmColor(position);
                EventBus.getDefault().post(twoList.get(position).getId());
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
        one_rv.setLayoutManager(new LinearLayoutManager(this));
        two_rv = findViewById(R.id.two_rv);
        two_rv.setLayoutManager(new GridLayoutManager(this, 3));
        three_rv = findViewById(R.id.three_rv);
        three_rv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onGet(String categoryId) {
        mPresenter.getInfoParams(categoryId);
    }

    @Override
    public void onClassSuccess(UserBean url) {

        oneList.addAll(url.getResult());
        oneAdapter.notifyDataSetChanged();
        twoList.addAll(oneList.get(0).getSecondCategoryVo());
        twoAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClassError(Throwable throwable) {

    }

    @Override
    public void onCommitSuccess(ItemBean url) {
        threeList.clear();
        threeList.addAll(url.getResult());
        threeAdapter.notifyDataSetChanged();

    }

    @Override
    public void onCommitError(Throwable throwable) {

    }
}
