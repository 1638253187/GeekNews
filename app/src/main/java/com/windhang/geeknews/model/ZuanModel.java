package com.windhang.geeknews.model;

import com.windhang.geeknews.api.NewsServer;
import com.windhang.geeknews.base.BaseCallBack;
import com.windhang.geeknews.base.BaseModel;
import com.windhang.geeknews.bean.ZuanBean;
import com.windhang.geeknews.util.HttpUtil;
import com.windhang.geeknews.util.RxUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ZuanModel extends BaseModel {
    public void getZuan(final BaseCallBack<ZuanBean,String> callBack){
        HttpUtil.getHttpUtil().getServer(NewsServer.baseurls,NewsServer.class)
                .getZhuan().compose(RxUtil.<ZuanBean>rxObservableTransformer())
                .subscribe(new Observer<ZuanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZuanBean zuanBean) {
                    callBack.onSuccess(zuanBean);
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
