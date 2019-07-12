package com.windhang.geeknews.fragment;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.windhang.geeknews.R;
import com.windhang.geeknews.adapter.RecyNewsAdapter;
import com.windhang.geeknews.base.BaseMvpActivity;
import com.windhang.geeknews.bean.NewsBean;
import com.windhang.geeknews.model.NewsModel;
import com.windhang.geeknews.presenter.NewsPresenter;
import com.windhang.geeknews.util.ToastUtil;
import com.windhang.geeknews.view.NewsView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhi_OneFragment extends BaseMvpActivity<NewsPresenter, NewsModel, NewsView> implements NewsView, OnRefreshListener {


    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private RecyNewsAdapter adapter;
    private ArrayList<NewsBean.StoriesBean> storiesBeans;
    private ArrayList<NewsBean.TopStoriesBean> topStoriesBeans;

    public Zhi_OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void initView() {
        storiesBeans = new ArrayList<>();
        topStoriesBeans = new ArrayList<>();
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyNewsAdapter(getActivity(), storiesBeans, topStoriesBeans);
        recy.setAdapter(adapter);

        smart.setOnRefreshListener(this);
        adapter.setOnItemClickListener(new RecyNewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, NewsBean.StoriesBean pos) {
                ToastUtil.showShort(pos.getTitle());
            }
        });
    }
    @Override
    public void initData() {
        if (presenter != null) {
            presenter.getNews();
        }
    }
    @Override
    protected NewsView initMvpView() {
        return this;
    }

    @Override
    protected NewsModel initMvpModel() {
        return new NewsModel();
    }

    @Override
    protected NewsPresenter initMvpPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi__one;
    }

    @Override
    public void onSuccess(NewsBean newsBean) {
        adapter.setData(newsBean);
        smart.finishRefresh();
    }

    @Override
    public void onFail(String v) {
        ToastUtil.showLong(v);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        initData();
    }
}
