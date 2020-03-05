package com.bawei.gujianlong20200224.api;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:13:22
 *@Description:
 * */


import com.bawei.gujianlong20200224.bean.UserBean;
import com.bawei.gujianlong20200224.bean.UserTwoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {
    @GET("verify/findGiftRecordByUid")
    Observable<UserBean> getDataUser(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("type") int type, @Query("page") int page, @Query("size") int size);

    @GET("verify/findGiftRecordByUid")
    Observable<UserTwoBean> getDataUserTwo(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("type") int type, @Query("page") int page, @Query("size") int size);
}
