package com.windhang.geeknews.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.windhang.geeknews.R;
import com.windhang.geeknews.adapter.RecyAdapter;
import com.windhang.geeknews.adapter.RecyHotAdapter;
import com.windhang.geeknews.adapter.Web;
import com.windhang.geeknews.base.BaseMvpFargment;
import com.windhang.geeknews.base.BaseView;
import com.windhang.geeknews.bean.HotBean;
import com.windhang.geeknews.model.HotModel;
import com.windhang.geeknews.presenter.HotPresenter;
import com.windhang.geeknews.util.ToastUtil;

import java.util.ArrayList;
import java.util.Queue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhi_ThreeFragment extends BaseMvpFargment<HotPresenter, HotModel, BaseView<HotBean, String>> implements BaseView<HotBean, String>, OnRefreshListener {


    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    Unbinder unbinder;
    private ArrayList<HotBean.RecentBean> list;
    private RecyHotAdapter adapter;

    public Zhi_ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView() {
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
         list = new ArrayList<>();
          adapter = new RecyHotAdapter(getActivity(), list);
          recy.setAdapter(adapter);
          smart.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {
        if (presenter!=null){
            presenter.getHot();
        }

    }

    @Override
    protected void initListener() {
        adapter.setOnItemCliclListener(new RecyHotAdapter.OnItemCliclListener() {
            @Override
            public void onItemClick(int position) {
                HotBean.RecentBean recentBean = list.get(position);
                String url = recentBean.getUrl();
                Intent intent = new Intent(getActivity(), Web.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }

    @Override
    protected BaseView<HotBean, String> initMvpView() {
        return this;
    }

    @Override
    protected HotModel initMvpModel() {
        return new HotModel();
    }

    @Override
    protected HotPresenter initMvpPresenter() {
        return new HotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi__three;
    }

    @Override
    public void onSuccess(HotBean hotBean) {
        list.addAll(hotBean.getRecent());
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
