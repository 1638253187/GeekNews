package com.windhang.geeknews.model;

import com.windhang.geeknews.api.GankService;
import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BaseModel;
import com.windhang.geeknews.bean.WelfareBean;
import com.windhang.geeknews.util.HttpUtil;
import com.windhang.geeknews.util.RxUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FlModel extends BaseModel {
    public void getWelf(final BaseCallBack<WelfareBean, String> callBack, int page) {
        HttpUtil.getHttpUtil().getServer(GankService.weflBaseUrl, GankService.class)
                .welfareData(page)
                .compose(RxUtil.<WelfareBean>rxObservableTransformer())
                .subscribe(new Observer<WelfareBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WelfareBean welfareBean) {
                        callBack.onSuccess(welfareBean);

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
