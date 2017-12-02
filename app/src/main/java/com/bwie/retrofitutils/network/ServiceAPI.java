package com.bwie.retrofitutils.network;

import com.bwie.retrofitutils.model.ResponseData;
import com.bwie.retrofitutils.model.ResponseDataList;
import com.bwie.retrofitutils.model.Tag;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 接口
 * Created by liqy on 2017/12/1.
 */

public interface ServiceAPI {

    @GET(UrlUtils.TAGS)
    Call<ResponseData<List<Tag>>> tags();

    @GET(UrlUtils.TAGS)
    Call<ResponseDataList<Tag>> tagList();

    @GET("api/data/Android/{size}/{page}")
    Call<ResponseDataList<Tag>> tagList(@Path("size") int size,@Path("page") int page);



}
