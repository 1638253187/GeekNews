package com.windhang.geeknews.presenter;

import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BasePresenter;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.WechatBean;
import com.windhang.geeknews.model.WeCatModel;

public class WeCatPresenter extends BasePresenter<WeCatModel, BaseView<WechatBean, String>> implements BaseCallBack<WechatBean, String> {
    public void getWecat(String key, int num, int page,String word) {
        if (model != null) {
            model.getWecat(this, key, num, page,word);
        }
    }
    @Override
    public void onSuccess(WechatBean K) {
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
