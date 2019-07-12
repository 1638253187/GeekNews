package com.windhang.geeknews.api;


import com.windhang.geeknews.bean.GankBean;
import com.windhang.geeknews.bean.WelfareBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author anfly
 * @date 2019/7/10.
 * description：
 */
public interface GankService {
    String sBaseUrl = "http://gank.io/api/";
    String weflBaseUrl = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";

    /**
     * http://gank.io/api/
     * 1)技术文章列表
     * 数据类型(tech)：Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App|all
     * 请求个数(num)： 数字，大于0
     * 第几页(page)：数字，大于0
     * data/{tech}/{num}/{page}
     */

    @GET("data/{tech}/{num}/{page}")
    Observable<GankBean> getGankData(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);

    @GET("10/{page}")
    Observable<WelfareBean> welfareData(@Path("page") int page);
}
