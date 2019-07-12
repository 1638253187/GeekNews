package com.windhang.geeknews.model;

import com.windhang.geeknews.api.WeChatService;
import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BaseModel;
import com.windhang.geeknews.bean.WechatBean;
import com.windhang.geeknews.util.HttpUtil;
import com.windhang.geeknews.util.RxUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class WeCatModel extends BaseModel {
    public void getWecat(final BaseCallBack<WechatBean, String> callBack, String key, int num, int page,String word) {
        HttpUtil.getHttpUtil().getServer(WeChatService.bUrl, WeChatService.class)
                .getWechatData(key, num, page)
                .compose(RxUtil.<WechatBean>rxObservableTransformer())
                .subscribe(new Observer<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        callBack.onSuccess(wechatBean);
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
