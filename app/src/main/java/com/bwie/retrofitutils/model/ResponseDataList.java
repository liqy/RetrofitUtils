package com.bwie.retrofitutils.model;

import java.util.List;

/**
 * Created by liqy on 2017/12/1.
 */

public class ResponseDataList<T> {
    public String message;
    public List<T> data;

    @Override
    public String toString() {
        return "ResponseDataList{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
