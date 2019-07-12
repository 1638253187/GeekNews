package com.windhang.geeknews.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {
    //统一管理观察者与被观察者的断开
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void destroy() {
        compositeDisposable.clear();
    }
}
