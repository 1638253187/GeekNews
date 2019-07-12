package com.windhang.geeknews.model;

import com.windhang.geeknews.api.NewsServer;
import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BaseModel;
import com.windhang.geeknews.bean.NewsBean;
import com.windhang.geeknews.util.HttpUtil;
import com.windhang.geeknews.util.RxUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class NewsModel extends BaseModel {
    public void getNews(final BaseCallBack<NewsBean, String> callBack) {
        HttpUtil.getHttpUtil().getServer(NewsServer.baseurl, NewsServer.class)
                .getNews().compose(RxUtil.<NewsBean>rxObservableTransformer())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        callBack.onSuccess(newsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail("网络错误:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
