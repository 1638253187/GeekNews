package com.windhang.geeknews.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.windhang.geeknews.R;
import com.windhang.geeknews.activity.Welf_Image;
import com.windhang.geeknews.adapter.RecyWelfAdapter;
import com.windhang.geeknews.base.BaseModel;
import com.windhang.geeknews.base.BaseMvpFargment;
import com.windhang.geeknews.base.BasePresenter;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.WelfareBean;
import com.windhang.geeknews.model.FlModel;
import com.windhang.geeknews.presenter.WeCatPresenter;
import com.windhang.geeknews.presenter.WelfPresenter;
import com.windhang.geeknews.util.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelfareFragment extends BaseMvpFargment<WelfPresenter, FlModel, BaseView<WelfareBean, String>> implements BaseView<WelfareBean, String>, OnRefreshLoadMoreListener {


    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    Unbinder unbinder;
    private ArrayList<WelfareBean.ResultsBean> list;
    private RecyWelfAdapter adapter;
    private int page=0;

    public WelfareFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView() {
        recy.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        list = new ArrayList<>();
        adapter = new RecyWelfAdapter(getActivity(), list);
        recy.setAdapter(adapter);
        smart.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        if (presenter!=null){
            page++;
            presenter.getWelf(page);
        }

    }

    @Override
    protected void initListener() {
        adapter.setOnItemCliclListener(new RecyWelfAdapter.OnItemCliclListener() {
            @Override
            public void onItemClick(int position) {
                WelfareBean.ResultsBean resultsBean = list.get(position);
                Intent intent = new Intent(getActivity(), Welf_Image.class);
                intent.putExtra("pic",resultsBean.getUrl());
                startActivity(intent);
            }
        });

    }

    @Override
    protected BaseView initMvpView() {
        return this;
    }

    @Override
    protected FlModel initMvpModel() {
        return new FlModel();
    }

    @Override
    protected WelfPresenter initMvpPresenter() {
        return new WelfPresenter();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_welfare;
    }

    @Override
    public void onSuccess(WelfareBean welfareBean) {
        list.addAll(welfareBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String s) {
        ToastUtil.showShort(s);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        initData();
        refreshLayout.finishLoadMore();
        smart.finishLoadMore();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        list.clear();
        page=0;
        initData();
        refreshLayout.finishRefresh();
        smart.finishRefresh();
    }
}
