package com.windhang.geeknews.presenter;

import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BasePresenter;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.GankBean;
import com.windhang.geeknews.model.GankModel;

public class GankPresenter extends BasePresenter<GankModel, BaseView<GankBean, String>> implements BaseCallBack<GankBean, String> {
    public void getGank(String tech,int num,int page) {
        if (model != null) {
            model.getGank(this,tech,num,page);
        }
    }

    @Override
    public void onSuccess(GankBean K) {
        if (view != null) {
            view.onSuccess(K);
        }
    }

    @Override
    public void onFail(String V) {
        if (view != null) {
            view.onFail(V);
        }
    }
}