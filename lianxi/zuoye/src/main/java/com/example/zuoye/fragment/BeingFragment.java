package com.example.zuoye.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/23
 *@Time:11:07
 *@Description:
 * */


import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zuoye.R;
import com.example.zuoye.adapter.BeingAdapter;
import com.example.zuoye.base.BaseFragment;
import com.example.zuoye.base.BasePresenter;
import com.example.zuoye.bean.BeingBean;
import com.example.zuoye.bean.TwoBean;
import com.example.zuoye.mvp.Presenter;
import com.google.zxing.oned.OneDimensionalCodeWriter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BeingFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    List<BeingBean.SubjectsBean> list = new ArrayList<>();
    private BeingAdapter beingAdapter;


    @Override
    protected void initView(View inflate) {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.being_frag;
    }

    @Override
    protected void startDing() {
        mPresenter.getDataOne();

        beingAdapter = new BeingAdapter(list, getContext());
        rv.setAdapter(beingAdapter);
    }


    @Override
    public void onOneSuccess(BeingBean beingBean) {
        list.addAll(beingBean.getSubjects());
        beingAdapter.notifyDataSetChanged();
    }

    @Override
    public void onOneError(Throwable throwable) {
        //Toast.makeText(getContext(), ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTwoinSuccess(TwoBean twoBean) {

    }

    @Override
    public void onTwoinError(Throwable throwable) {

    }
}
