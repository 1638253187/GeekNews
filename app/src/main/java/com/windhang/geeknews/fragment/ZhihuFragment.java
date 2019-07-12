package com.windhang.geeknews.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.windhang.geeknews.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuFragment extends Fragment {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private View view;
    private TabLayout mTab;
    private ViewPager mVp;

    public ZhihuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflate = inflater.inflate(R.layout.fragment_zhihu, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Zhi_OneFragment());
        fragments.add(new Zhi_TwoFragment());
        fragments.add(new Zhi_ThreeFragment());
        mVp.setPageMargin(44);
        mVp.setOffscreenPageLimit(3);
        mVp.setPageMargin(32);
        mVp.setClipChildren(false);
        mVp.setPageTransformer(true, new CustomPageTransformer());

        mVp.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("日报");
        mTab.getTabAt(1).setText("专栏");
        mTab.getTabAt(2).setText("热门");
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
