package com.bwie.retrofitutils.network;

import com.bwie.retrofitutils.model.GankData;
import com.bwie.retrofitutils.model.GankFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liqy on 2017/12/2.
 */

public interface GankAPI {

    @GET("api/data/Android/{size}/{page}")
    Call<GankData<GankFeed>> list(@Path("size") int size,@Path("page") int page);


    @GET("api/data/Android/10/1")
    Call<GankData<GankFeed>> lists();
}
