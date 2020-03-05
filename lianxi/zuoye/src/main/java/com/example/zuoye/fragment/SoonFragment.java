package com.example.zuoye.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/23
 *@Time:11:08
 *@Description:
 * */


import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zuoye.R;
import com.example.zuoye.adapter.SoonAdapter;
import com.example.zuoye.base.BaseFragment;
import com.example.zuoye.base.BasePresenter;
import com.example.zuoye.bean.BeingBean;
import com.example.zuoye.bean.TwoBean;
import com.example.zuoye.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SoonFragment extends BaseFragment {

    @BindView(R.id.rvs)
    RecyclerView rvs;
    List<TwoBean.SubjectsBean> list=new ArrayList<>();
    private SoonAdapter soonAdapter;

    @Override
    protected void initView(View inflate) {
        rvs.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.soon_frag;
    }

    @Override
    protected void startDing() {
        mPresenter.getDataTwo();
        soonAdapter = new SoonAdapter(list, getContext());
        rvs.setAdapter(soonAdapter);
    }


    @Override
    public void onOneSuccess(BeingBean beingBean) {

    }

    @Override
    public void onOneError(Throwable throwable) {

    }

    @Override
    public void onTwoinSuccess(TwoBean twoBean) {
        list.addAll(twoBean.getSubjects());
        soonAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTwoinError(Throwable throwable) {

    }
}
