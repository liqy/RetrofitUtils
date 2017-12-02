package com.bwie.retrofitutils.model;

/**
 * Created by liqy on 2017/12/1.
 */

public class Tag {

    /**
     * double_col_mode : false
     * umeng_event : recommend
     * is_default_tab : true
     * url : http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-101
     * list_id : -101
     * refresh_interval : 1800
     * type : 1
     * name : 推荐
     */

    public boolean double_col_mode;
    public String umeng_event;
    public boolean is_default_tab;
    public String url;
    public int list_id;
    public int refresh_interval;
    public int type;
    public String name;

    public static Tag objectFromData(String str) {
        return new com.google.gson.Gson().fromJson(str, Tag.class);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "double_col_mode=" + double_col_mode +
                ", umeng_event='" + umeng_event + '\'' +
                ", is_default_tab=" + is_default_tab +
                ", url='" + url + '\'' +
                ", list_id=" + list_id +
                ", refresh_interval=" + refresh_interval +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
