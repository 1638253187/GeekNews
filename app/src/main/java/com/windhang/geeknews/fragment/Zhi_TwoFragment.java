package com.windhang.geeknews.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.windhang.geeknews.R;
import com.windhang.geeknews.adapter.RecyAdapter;
import com.windhang.geeknews.base.BaseFragment;
import com.windhang.geeknews.base.BaseMvpActivity;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.ZuanBean;
import com.windhang.geeknews.model.ZuanModel;
import com.windhang.geeknews.presenter.ZuanPresenter;
import com.windhang.geeknews.util.ToastUtil;
import com.windhang.geeknews.view.ZuanView;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhi_TwoFragment extends BaseMvpActivity<ZuanPresenter, ZuanModel, BaseView<ZuanBean,String>> implements BaseView<ZuanBean,String>, ZuanView, OnRefreshListener {


    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    Unbinder unbinder;
    private ArrayList<ZuanBean.DataBean> list;
    private RecyAdapter adapter;

    public Zhi_TwoFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView() {
        recy.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        list = new ArrayList<>();
        adapter = new RecyAdapter(getActivity(), list);
        recy.setAdapter(adapter);
        smart.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {

        if (presenter!=null){
            presenter.getZuan();
        }

    }

    @Override
    protected void initListener() {


    }

    @Override
    protected ZuanView initMvpView() {
        return this;
    }

    @Override
    protected ZuanModel initMvpModel() {
        return new ZuanModel();
    }

    @Override
    protected ZuanPresenter initMvpPresenter() {
        return new ZuanPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi__two;
    }


    @Override
    public void onSuccess(ZuanBean zuanBean) {
        list.addAll(zuanBean.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String s) {
        ToastUtil.showShort(s);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        list.clear();
        initData();
        smart.finishRefresh();
        refreshLayout.finishRefresh();
    }
}
