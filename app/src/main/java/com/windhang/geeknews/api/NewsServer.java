package com.windhang.geeknews.api;

import com.windhang.geeknews.bean.HotBean;
import com.windhang.geeknews.bean.NewsBean;
import com.windhang.geeknews.bean.ZuanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsServer {
    String baseurl="http://news-at.zhihu.com/api/";
    String baseurls="http://news-at.zhihu.com/api/";
    String baseurlss="http://news-at.zhihu.com/api/";
    @GET("4/news/latest")
    Observable<NewsBean>getNews();

    @GET("4/sections")
    Observable<ZuanBean>getZhuan();

    @GET("")
    Observable<HotBean>getHot(@Url String url);

}
