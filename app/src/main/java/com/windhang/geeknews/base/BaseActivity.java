package com.windhang.geeknews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected int lastFragmentType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initMvp();
        initView();
        initData();
        initListener();
    }

    protected void initMvp() {

    }

    public void initData() {

    }

    public void initListener() {

    }

    public void initView() {

    }



    protected abstract int getLayoutId();

}
