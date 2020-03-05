package com.example.zuoye.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:30
 *@Description:
 * */


import com.example.zuoye.base.BasePresenter;
import com.example.zuoye.bean.BeingBean;
import com.example.zuoye.bean.TwoBean;
import com.example.zuoye.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;
    @Override
    protected void initModel() {
        iModel=new Model();
    }


    @Override
    public void getDataOne() {
        iModel.getDataOne(new Contract.MyCallBack() {
            @Override
            public void onOneSuccess(BeingBean beingBean) {
                getView().onOneSuccess(beingBean);
            }

            @Override
            public void onOneError(Throwable throwable) {
                getView().onOneError(throwable);
            }

            @Override
            public void onTwoinSuccess(TwoBean twoBean) {
                getView().onTwoinSuccess(twoBean);
            }

            @Override
            public void onTwoinError(Throwable throwable) {
                getView().onTwoinError(throwable);
            }
        });
    }

    @Override
    public void getDataTwo() {
        iModel.getDataTwo(new Contract.MyCallBack() {
            @Override
            public void onOneSuccess(BeingBean beingBean) {
                getView().onOneSuccess(beingBean);
            }

            @Override
            public void onOneError(Throwable throwable) {
                getView().onOneError(throwable);
            }

            @Override
            public void onTwoinSuccess(TwoBean twoBean) {
                getView().onTwoinSuccess(twoBean);
            }

            @Override
            public void onTwoinError(Throwable throwable) {
                getView().onTwoinError(throwable);
            }
        });
    }
}
