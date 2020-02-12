package com.example.mycart.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/5
 *@Time:15:23
 *@Description:
 * */


import com.example.mycart.base.BasePresenter;
import com.example.mycart.bean.CartBean;
import com.example.mycart.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;
    @Override
    protected void initModel() {
        iModel=new Model();
    }

    @Override
    public void getDataCart(int userId, String sessionId) {
        iModel.getDataCart(userId, sessionId, new Contract.MyCallBack() {
            @Override
            public void mySuccessCart(CartBean cartBean) {
                getView().mySuccessCart(cartBean);
            }

            @Override
            public void myErrorCart(Throwable throwable) {
                getView().myErrorCart(throwable);
            }
        });
    }
}
