package com.windhang.geeknews.view;

import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.NewsBean;

public interface NewsView extends BaseView<NewsBean,String> {
    @Override
    void onSuccess(NewsBean newsBean);

    @Override
    void onFail(String v);
}
