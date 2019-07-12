package com.windhang.geeknews.view;

import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.ZuanBean;

public interface ZuanView extends BaseView<ZuanBean,String> {
    @Override
    void onSuccess(ZuanBean zuanBean);

    @Override
    void onFail(String s);
}
