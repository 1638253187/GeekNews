package com.windhang.geeknews.fragment;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.windhang.geeknews.R;
import com.windhang.geeknews.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends BaseFragment {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    public String[] arr = {"Android", "iOS", "前端"};
    @BindView(R.id.iv_tu)
    ImageView ivTu;
    @BindView(R.id.ctl)
    CollapsingToolbarLayout ctl;
    private ArrayList<Fragment> list;
    private ArrayList<String> titles;
    public GankFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        titles = new ArrayList<>();
        vp.setPageTransformer(true, new CustomPageTransformer());

        for (int i = 0; i < arr.length; i++) {
            titles.add(arr[i]);
            list.add(new GankListFragment(arr[i]));
        }
        list.add(new WelfareFragment());
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("Android");
        tab.getTabAt(1).setText("ios");
        tab.getTabAt(2).setText("前端");
        tab.getTabAt(3).setText("福利");
    }


    @Override
    protected void initData() {
        ctl.setExpandedTitleColor(getResources().getColor(R.color.aaa));
        ctl.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
    }

    @Override
    protected void initListener() {


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }
    public class CustomPageTransformer implements ViewPager.PageTransformer {
        //最小状态时，Size缩小为90%
        private static final float MIN_SCALE = 0.9F;
        @Override
        public void transformPage(View view, float position) {
            //这里自定义动画
            float scale = Math.max(MIN_SCALE,1 - Math.abs(position));
            if (position < -1.0f) {
                view.setScaleY(MIN_SCALE);
            } else if (position <= 0.0f) {
                view.setScaleY(scale);
            } else if (position <= 1.0f) {
                view.setScaleY(scale);
            } else {
                view.setScaleY(MIN_SCALE);
            }
        }
    }
}
