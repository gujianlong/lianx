package com.example.lianxi2.fragment;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:20:22
 *@Description:
 * */


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi2.R;
import com.example.lianxi2.adapter.OneAdapter;
import com.example.lianxi2.adapter.TwoAdapter;
import com.example.lianxi2.base.BaseFragment;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.UserBean;
import com.example.lianxi2.contract.Contract;
import com.example.lianxi2.mvp.Presenter;
import com.example.lianxi2.url.MyUrl;
import com.example.lianxi2.weight.MyView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment {


    private RecyclerView one_rv;
    private RecyclerView two_rv;
    private List<UserBean.ResultBean> oneList = new ArrayList<>();
    private List<UserBean.ResultBean.SecondCategoryVoBean> twoList = new ArrayList<>();
    private OneAdapter oneAdapter;
    private TwoAdapter twoAdapter;
    private MyView myView;
    private UserBean bean;

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View inflate) {
        one_rv = inflate.findViewById(R.id.one_rv);
        two_rv = inflate.findViewById(R.id.two_rv);
        one_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        two_rv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        myView = inflate.findViewById(R.id.mv);
    }

    @Override
    protected int layputId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void startDing() {
        mPresenter.getInfoNotParams(MyUrl.HOMEBEAN,UserBean.class);

        oneAdapter = new OneAdapter(oneList, getActivity());
        one_rv.setAdapter(oneAdapter);
        twoAdapter = new TwoAdapter(twoList, getActivity());
        two_rv.setAdapter(twoAdapter);
        myView.setItemClick(new MyView.ItemClick() {
            @Override
            public void onClick(String url) {
                for (int i = 0; i < bean.getResult().size(); i++) {
                    if (bean.getResult().get(i).getName().equals(url)){
                        oneAdapter.setColoePosition(i);
                        twoList.clear();
                        twoList.addAll(oneList.get(i).getSecondCategoryVo());
                        twoAdapter.notifyDataSetChanged();
                    }
                }

            }
        });
        oneAdapter.setItemClick(new OneAdapter.ItemClick() {
            @Override
            public void onItemClick(int position) {
                oneAdapter.setColoePosition(position);
                twoList.clear();
                twoList.addAll(oneList.get(position).getSecondCategoryVo());
                twoAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof UserBean) {
            bean = (UserBean) o;
            oneList.addAll(bean.getResult());
            oneAdapter.notifyDataSetChanged();
            twoList.addAll(oneList.get(0).getSecondCategoryVo());
            twoAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
