package com.windhang.geeknews.model;

import com.windhang.geeknews.api.GankService;
import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BaseModel;
import com.windhang.geeknews.bean.GankBean;
import com.windhang.geeknews.util.HttpUtil;
import com.windhang.geeknews.util.RxUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GankModel extends BaseModel {

    public void getGank(final BaseCallBack<GankBean,String>callBack,String tech,int ios,int web){
        HttpUtil.getHttpUtil().getServer(GankService.sBaseUrl,GankService.class)
                .getGankData(tech,ios,web).compose(RxUtil.<GankBean>rxObservableTransformer())
                .subscribe(new Observer<GankBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GankBean gankBean) {
                    callBack.onSuccess(gankBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    callBack.onFail("网络错误:"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
