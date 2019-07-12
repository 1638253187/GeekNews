package com.windhang.geeknews.api;


import com.windhang.geeknews.bean.WechatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author anfly
 * @date 2019/7/9.
 * description：
 */
public interface WeChatService {

    String bUrl = "http://api.tianapi.com/";

    //key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
    @GET("wxnew/?")
    Observable<WechatBean> getWechatData(@Query("key") String key, @Query("num") int num, @Query("page") int page);

    //搜索的
    @GET("wxnew/?")
    Observable<WechatBean> getSearchData(@Query("key") String key, @Query("num") int num, @Query("page") int page, @Query("word") String word);
}
