package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.week2.adapter.OneAdapter;
import com.example.week2.adapter.TwoAdapter;
import com.example.week2.base.BaseActivity;
import com.example.week2.base.BasePresenter;
import com.example.week2.bean.ItemBean;
import com.example.week2.bean.UserBean;
import com.example.week2.mvp.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView one_rv;
    private RecyclerView two_rv;
    private List<UserBean.ResultBean.SecondCategoryVoBean> oneList = new ArrayList<>();
    private List<ItemBean.ResultBean> twoList = new ArrayList<>();
    private OneAdapter oneAdapter;
    private TwoAdapter twoAdapter;

    @Override
    protected void startDing() {
        mPresenter.getInfoNo();
        oneAdapter = new OneAdapter(this, oneList);
        one_rv.setAdapter(oneAdapter);
        twoAdapter = new TwoAdapter(this, twoList);
        two_rv.setAdapter(twoAdapter);
        oneAdapter.setItemClick(new OneAdapter.ItemClick() {
            @Override
            public void onItem(int position) {
                EventBus.getDefault().post(oneList.get(position).getId());
            }
        });
    }

    @Override
    protected void initView() {
        one_rv = findViewById(R.id.one_rv);
        one_rv.setLayoutManager(new LinearLayoutManager(this));
        two_rv = findViewById(R.id.two_rv);
        two_rv.setLayoutManager(new GridLayoutManager(this, 3));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCalssSuccess(UserBean userBean) {
        oneList.clear();
        oneList.addAll(userBean.getResult().get(0).getSecondCategoryVo());
        oneAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCalssError(Throwable throwable) {

    }

    @Override
    public void onCommitSuccess(ItemBean itemBean) {
        twoList.clear();
        twoList.addAll(itemBean.getResult());
        twoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCommitError(Throwable throwable) {

    }

    @Subscribe
    public void onGet(String categoryId) {
        mPresenter.getInfoParams(categoryId);
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


}
