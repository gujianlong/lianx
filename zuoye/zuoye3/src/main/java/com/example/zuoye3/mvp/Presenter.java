package com.example.zuoye3.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:15:31
 *@Description:
 * */


import com.example.zuoye3.base.BasePresenter;
import com.example.zuoye3.bean.OrderBean;
import com.example.zuoye3.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getInfo(int status, int page, int count) {
        iModel.getInfo(status, page, count, new Contract.MyCallBack() {
            @Override
            public void SuccessionOrder(OrderBean orderBean) {
                getView().SuccessionOrder(orderBean);
            }

            @Override
            public void ErrorOrder(Throwable throwable) {
                getView().ErrorOrder(throwable);
            }
        });
    }
}
