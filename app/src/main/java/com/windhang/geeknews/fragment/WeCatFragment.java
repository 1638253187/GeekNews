package com.windhang.geeknews.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.windhang.geeknews.R;
import com.windhang.geeknews.adapter.WeCatAdapter;
import com.windhang.geeknews.base.BaseMvpFargment;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.QueryBean;
import com.windhang.geeknews.bean.WechatBean;
import com.windhang.geeknews.model.WeCatModel;
import com.windhang.geeknews.presenter.WeCatPresenter;
import com.windhang.geeknews.util.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeCatFragment extends BaseMvpFargment<WeCatPresenter, WeCatModel, BaseView<WechatBean, String>> implements BaseView<WechatBean, String>, OnRefreshLoadMoreListener {


    @BindView(R.id.recy)
    RecyclerView recy;
    Unbinder unbinder;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private ArrayList<WechatBean.NewslistBean> list;
    private String key = "52b7ec3471ac3bec6846577e79f20e4c";
    private int num = 10;
    private int page = 1;
    private String word = "";
    private WeCatAdapter adapter;

    public WeCatFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView() {
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new WeCatAdapter(getActivity(), list);
        recy.setAdapter(adapter);
        smart.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        if (presenter != null) {
            presenter.getWecat(key, num, page++,word);
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_we_cat;
    }

    @Override
    protected BaseView<WechatBean, String> initMvpView() {
        return this;
    }

    @Override
    protected WeCatModel initMvpModel() {
        return new WeCatModel();
    }

    @Override
    protected WeCatPresenter initMvpPresenter() {
        return new WeCatPresenter();
    }

    @Override
    public void onSuccess(WechatBean wechatBean) {
        list.addAll(wechatBean.getNewslist());
        adapter.setList((ArrayList<WechatBean.NewslistBean>) wechatBean.getNewslist());

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String s) {
        ToastUtil.showShort(s);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void queryData(QueryBean queryBean) {
        if (presenter != null) {
            presenter.getWecat(key, num, page, queryBean.getQuery());
            Log.e("tag",queryBean.getQuery());
            ToastUtil.showShort(queryBean.getQuery());
        }
    }
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        initData();
        smart.finishLoadMore();
        refreshLayout.finishLoadMore();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        list.clear();
        page=1;
        initData();
        refreshLayout.finishRefresh();
        smart.finishRefresh();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
