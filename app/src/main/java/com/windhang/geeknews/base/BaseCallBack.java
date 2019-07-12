package com.windhang.geeknews.base;

public abstract interface BaseCallBack<K,V> {
    void onSuccess(K K);
    void onFail(V V);
}
