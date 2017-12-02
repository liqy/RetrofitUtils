package com.bwie.retrofitutils.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liqy on 2017/12/1.
 */

public class RetrofitHelper {

    private static OkHttpClient okHttpClient;
    private static ServiceAPI serviceAPI;

    /**
     * 静态代码块
     */
    static {
        initOkHttpClient();
    }

    /**
     * 初始化OkHttpClient
     */
    private static void initOkHttpClient() {

        if (okHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (okHttpClient == null) {
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .build();
                }
            }
        }
    }

    /**
     * 初始化一个ServiceAPI单例
     * @return
     */
    public static ServiceAPI getAPI() {
        if (serviceAPI == null) {
            synchronized (ServiceAPI.class) {
                if (serviceAPI == null) {
                    serviceAPI = RetrofitHelper.createAPI(ServiceAPI.class, UrlUtils.BASE_HOST_URL);
                }
            }
        }
        return serviceAPI;
    }

    public static GankAPI getGankAPI(){
        return createAPI(GankAPI.class,UrlUtils.GANK_HOST_URL);
    }


    /**
     * 这个是泛型方法，注意定义规则
     * 初始化Retrofit ,生成API方法，
     *
     * @param clazz
     * @param url
     * @param <T>
     * @return
     */
    public static <T> T createAPI(Class<T> clazz, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//TODO 怎么替换这个URL
                .client(okHttpClient)//自定义OKHTTP客户端
                //GSON转化
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }


}
