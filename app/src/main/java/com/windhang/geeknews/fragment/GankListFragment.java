package com.windhang.geeknews.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.windhang.geeknews.R;
import com.windhang.geeknews.adapter.GankAdapter;
import com.windhang.geeknews.base.BaseModel;
import com.windhang.geeknews.base.BaseMvpFargment;
import com.windhang.geeknews.base.BasePresenter;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.GankBean;
import com.windhang.geeknews.model.GankModel;
import com.windhang.geeknews.presenter.GankPresenter;
import com.windhang.geeknews.util.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class GankListFragment extends BaseMvpFargment<GankPresenter, GankModel, BaseView<GankBean, String>> implements BaseView<GankBean, String> {
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    Unbinder unbinder;
    private String tech;
    private int num = 10;
    private int page = 1;
    private ArrayList<GankBean.ResultsBean> list;
    private GankAdapter adapter;

    public GankListFragment(String tech) {
        this.tech = tech;
    }

    @Override
    protected void initView() {
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new GankAdapter(list, getActivity());
        recy.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        if (presenter != null) {
            presenter.getGank(tech, num, page);
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_list;
    }

    @Override
    protected BaseView initMvpView() {
        return this;
    }

    @Override
    protected GankModel initMvpModel() {
        return new GankModel();
    }

    @Override
    protected GankPresenter initMvpPresenter() {
        return new GankPresenter();
    }


    @Override
    public void onSuccess(GankBean gankBean) {
        list.addAll(gankBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String s) {
        ToastUtil.showShort(s);
    }


}
