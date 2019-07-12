package com.windhang.geeknews.model;

import com.windhang.geeknews.api.NewsServer;
import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BaseModel;
import com.windhang.geeknews.bean.HotBean;
import com.windhang.geeknews.util.HttpUtil;
import com.windhang.geeknews.util.RxUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class HotModel extends BaseModel {
    public void getHot(final BaseCallBack<HotBean,String> callBack){
        HttpUtil.getHttpUtil().getServer(NewsServer.baseurlss,NewsServer.class)
        .getHot("4/news/hot").compose(RxUtil.<HotBean>rxObservableTransformer())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                    callBack.onSuccess(hotBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    callBack.onFail("网路错误:"+e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
