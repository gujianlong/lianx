package com.example.lianxi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.lianxi2.adapter.MyAdapter;
import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.UserBean;
import com.example.lianxi2.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private ExpandableListView expandableListView;
    //private List<UserBean.ResultBean> list = new ArrayList<>();

    @Override
    protected void startDing() {
        mPresenter.getInfoParams();
    }

    @Override
    protected void initView() {
        expandableListView = findViewById(R.id.eLv);
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
    public void onClassSuccess(UserBean homeBean) {
        List<UserBean.ResultBean> result = homeBean.getResult();
        MyAdapter myAdapter = new MyAdapter(this, result);
        expandableListView.setAdapter(myAdapter);
        for (int i = 0; i <result.size(); i++) {
            expandableListView.expandGroup(i);
        }
    }

    @Override
    public void onClassError(Throwable throwable) {

    }
}
