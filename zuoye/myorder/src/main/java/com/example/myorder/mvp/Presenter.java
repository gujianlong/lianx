package com.example.myorder.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/11
 *@Time:17:43
 *@Description:
 * */


import com.example.myorder.base.BaseFragment;
import com.example.myorder.base.BasePresenter;
import com.example.myorder.bean.OrderBean;
import com.example.myorder.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;
    @Override
    protected void initModel() {
        iModel=new Model();
    }

    @Override
    public void getOrderData(int userId, String sessionId, int status, int page, int count) {
        iModel.getOrderData(userId, sessionId, status, page, count, new Contract.MyCallBack() {
            @Override
            public void getOrderSuccess(OrderBean orderBean) {
                getView().getOrderSuccess(orderBean);
            }

            @Override
            public void getOrderError(Throwable throwable) {
                getView().getOrderError(throwable);
            }
        });
    }
}
