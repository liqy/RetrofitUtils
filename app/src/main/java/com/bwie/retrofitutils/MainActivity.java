package com.bwie.retrofitutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bwie.retrofitutils.model.DaoMaster;
import com.bwie.retrofitutils.model.DaoSession;
import com.bwie.retrofitutils.model.GankData;
import com.bwie.retrofitutils.model.GankFeed;
import com.bwie.retrofitutils.model.GankFeedDao;
import com.bwie.retrofitutils.model.ResponseData;
import com.bwie.retrofitutils.model.ResponseDataList;
import com.bwie.retrofitutils.model.Tag;
import com.bwie.retrofitutils.network.GankAPI;
import com.bwie.retrofitutils.network.RetrofitHelper;
import com.bwie.retrofitutils.network.ServiceAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * 动态代理生成代理类对象
         */
        ServiceAPI api = RetrofitHelper.getAPI();

        Call<ResponseData<List<Tag>>> tags = api.tags();

        tags.enqueue(new Callback<ResponseData<List<Tag>>>() {
            @Override
            public void onResponse(Call<ResponseData<List<Tag>>> call, Response<ResponseData<List<Tag>>> response) {
//                Log.d(getLocalClassName(),response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseData<List<Tag>>> call, Throwable t) {

            }
        });

        Call<ResponseDataList<Tag>> listCall = api.tagList();
        listCall.enqueue(new Callback<ResponseDataList<Tag>>() {
            @Override
            public void onResponse(Call<ResponseDataList<Tag>> call, Response<ResponseDataList<Tag>> response) {
//                Log.d(getLocalClassName(),response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseDataList<Tag>> call, Throwable t) {

            }
        });

        GankAPI gankAPI = RetrofitHelper.getGankAPI();


        Call<GankData<GankFeed>> gankDataCall = gankAPI.list(20,1);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        final DaoSession daoSession = new DaoMaster(helper.getWritableDb()).newSession();

        gankDataCall.enqueue(new Callback<GankData<GankFeed>>() {
            @Override
            public void onResponse(Call<GankData<GankFeed>> call, Response<GankData<GankFeed>> response) {

                GankFeedDao gankFeedDao = daoSession.getGankFeedDao();

                for (GankFeed feed : response.body().results) {
                    gankFeedDao.insert(feed);
                }

                Log.d(getLocalClassName(), "Count=" + gankFeedDao.count());

            }

            @Override
            public void onFailure(Call<GankData<GankFeed>> call, Throwable t) {

            }
        });

    }
}
