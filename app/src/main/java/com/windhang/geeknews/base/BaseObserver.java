package com.windhang.geeknews.base;


import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        Log.e("TAG", "onSubscribe");
    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG", "onError：" + e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.e("TAG", "onComplete");
    }
}
