package com.windhang.geeknews.base;

import java.util.ArrayList;

public abstract class BasePresenter<M extends BaseModel, V> {
    protected M model;
    protected V view;
    ArrayList<BaseModel> list = new ArrayList<>();
    public void setModel(M model) {
        this.model = model;
    }

    public void setView(V view) {
        this.view = view;
    }
    public void destroy() {

        //当activity销毁的时候，观察者与被观察者的断开
        if (list != null && list.size() > 0) {
            for (BaseModel baseModel : list) {
                baseModel.destroy();
            }
        }

        //当activity销毁的时候,将view置空，防止内存泄漏
        if (view != null) {
            view = null;
        }

        //当activity销毁的时候,将model置空，防止内存泄漏
        if (model != null) {
            model = null;
        }
    }
}
