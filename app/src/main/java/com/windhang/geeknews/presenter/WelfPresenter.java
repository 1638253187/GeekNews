package com.windhang.geeknews.presenter;

import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BasePresenter;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.WelfareBean;
import com.windhang.geeknews.model.FlModel;

public class WelfPresenter extends BasePresenter<FlModel, BaseView<WelfareBean,String>> implements BaseCallBack<WelfareBean, String> {
    public void getWelf(int page){
        if (model!=null){
            model.getWelf(this,page);
        }
    }

    @Override
    public void onSuccess(WelfareBean K) {
        if (view!=null){
            view.onSuccess(K);
        }
    }

    @Override
    public void onFail(String V) {
        if (view!=null){
            view.onFail(V);
        }
    }
}
