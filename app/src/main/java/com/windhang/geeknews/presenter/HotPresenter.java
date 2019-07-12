package com.windhang.geeknews.presenter;

import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BasePresenter;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.HotBean;
import com.windhang.geeknews.model.HotModel;

public class HotPresenter extends BasePresenter<HotModel, BaseView<HotBean,String>> implements BaseCallBack<HotBean, String> {

    public void getHot(){
        if (model!=null){
            model.getHot(this);
        }
    }

    @Override
    public void onSuccess(HotBean K) {
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
