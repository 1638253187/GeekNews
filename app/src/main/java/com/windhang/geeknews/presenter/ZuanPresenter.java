package com.windhang.geeknews.presenter;

import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BasePresenter;
import com.windhang.geeknews.bean.ZuanBean;
import com.windhang.geeknews.model.ZuanModel;
import com.windhang.geeknews.view.ZuanView;

public class ZuanPresenter extends BasePresenter<ZuanModel, ZuanView> implements BaseCallBack<ZuanBean, String> {
    public void getZuan(){
        if (model!=null){
            model.getZuan(this);
        }
    }

    @Override
    public void onSuccess(ZuanBean K) {
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
