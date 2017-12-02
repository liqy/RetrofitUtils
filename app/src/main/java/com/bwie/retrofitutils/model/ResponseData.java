package com.bwie.retrofitutils.model;

import java.util.List;

/**
 * Created by liqy on 2017/12/1.
 */

public class ResponseData<T> {
    public String message;
    public T data;

    @Override
    public String toString() {
        return "ResponseData{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
