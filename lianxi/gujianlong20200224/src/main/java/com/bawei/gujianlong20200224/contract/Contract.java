package com.bawei.gujianlong20200224.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:13:41
 *@Description:
 * */


import com.bawei.gujianlong20200224.app.MyApp;
import com.bawei.gujianlong20200224.bean.UserBean;
import com.bawei.gujianlong20200224.bean.UserTwoBean;

import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Contract {
    interface MyCallBack {
        void onUserSuccess(UserBean userBean);

        void onUserErrey(Throwable throwable);

        void onUserTwoSuccess(UserTwoBean userTwoBean);

        void onUserTwoErrey(Throwable throwable);
    }

    interface IView {
        void onUserSuccess(UserBean userBean);

        void onUserErrey(Throwable throwable);

        void onUserTwoSuccess(UserTwoBean userTwoBean);

        void onUserTwoErrey(Throwable throwable);

    }

    interface IModel {
        void getDataUser(int userId, String sessionId, int type, int page, int size, MyCallBack myCallBack);

        void getDataUserTwo(int userId, String sessionId, int type, int page, int size, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getDataUser(int userId, String sessionId, int type, int page, int size);

        void getDataUserTwo(int userId, String sessionId, int type, int page, int size);
    }
}
