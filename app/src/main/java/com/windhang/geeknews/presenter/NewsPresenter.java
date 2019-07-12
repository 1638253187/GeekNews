package com.windhang.geeknews.presenter;

import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BasePresenter;
import com.windhang.geeknews.bean.NewsBean;
import com.windhang.geeknews.model.NewsModel;
import com.windhang.geeknews.view.NewsView;

public class NewsPresenter extends BasePresenter<NewsModel, NewsView> implements BaseCallBack<NewsBean, String> {
    public void getNews() {
        if (model != null) {
            model.getNews(this);
        }
    }

    @Override
    public void onSuccess(NewsBean newsBean) {
        if (view != null) {
            view.onSuccess(newsBean);
        }
    }

    @Override
    public void onFail(String s) {
        if (view != null) {
            view.onFail(s);
        }
    }
}
