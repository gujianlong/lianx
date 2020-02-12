package com.example.zuoye5.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/15
 *@Time:10:48
 *@Description:
 * */


import com.example.zuoye5.base.BasePresenter;
import com.example.zuoye5.bean.CartBean;
import com.example.zuoye5.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void postInfoCart() {
        iModel.postInfoCart(new Contract.MyCallBack() {
            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }
        });
    }
}
