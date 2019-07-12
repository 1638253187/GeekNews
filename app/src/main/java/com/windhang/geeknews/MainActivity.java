package com.windhang.geeknews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.windhang.geeknews.base.BaseActivity;
import com.windhang.geeknews.bean.QueryBean;
import com.windhang.geeknews.fragment.AboutFragment;
import com.windhang.geeknews.fragment.GankFragment;
import com.windhang.geeknews.fragment.GoldFragment;
import com.windhang.geeknews.fragment.LikeFragment;
import com.windhang.geeknews.fragment.SettingFragment;
import com.windhang.geeknews.fragment.VetxFragment;
import com.windhang.geeknews.fragment.WeCatFragment;
import com.windhang.geeknews.fragment.ZhihuFragment;
import com.windhang.geeknews.util.FragmentType;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navi)
    NavigationView navi;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.search)
    MaterialSearchView search;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    private Toast toast;
    private ImageView imageView;
    private MenuItem item;

    @Override
    public void initView() {


        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nv_open, R.string.nv_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //获得fragment管理器
        fragmentManager = getSupportFragmentManager();
        //初始化fragment
        initFragment();
        //先知乎碎片
        addZhiFragment();
        navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawer.closeDrawer(Gravity.LEFT);
                menuItem.setChecked(true);
                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.zhihu:

                        toolbar.setTitle(R.string.zhihu);
                        switchFragment(0);
                        toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, -20, -1010);
                        imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.mipmap.ic_drawer_zhihu);
                        toast.setView(imageView);
                        toast.show();
                        break;
                    case R.id.wechat:
                        toolbar.setTitle(R.string.wechat);
                        switchFragment(1);
                        toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, -20, -1010);
                        imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.mipmap.ic_drawer_wechat);
                        toast.setView(imageView);
                        toast.show();
                        break;
                    case R.id.gank:
                        toolbar.setTitle(R.string.gank);
                        switchFragment(2);
                        toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 20, -1010);
                        imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.mipmap.ic_drawer_gank);
                        toast.setView(imageView);
                        toast.show();
                        break;
                    case R.id.gold:
                        toolbar.setTitle(R.string.gold);
                        toolbar.setTitle(R.string.gold);
                        switchFragment(3);
                        toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, -20, -1010);
                        imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.mipmap.ic_drawer_gold);
                        toast.setView(imageView);
                        toast.show();
                        break;
                    case R.id.vtex:
                        toolbar.setTitle(R.string.vtex);
                        toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, -20, -1010);
                        imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.mipmap.ic_drawer_vtex);
                        toast.setView(imageView);
                        toast.show();
                        switchFragment(4);

                        break;
                    case R.id.like:
                        toolbar.setTitle(R.string.like);
                        switchFragment(5);
                        toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, -140, -1010);
                        imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.mipmap.ic_drawer_like);
                        toast.setView(imageView);
                        toast.show();
                        break;
                    case R.id.setting:
                        toolbar.setTitle(R.string.setting);
                        switchFragment(6);
                        toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, -140, -1010);
                        imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.mipmap.ic_drawer_setting);
                        toast.setView(imageView);
                        toast.show();
                        break;
                    case R.id.about:
                        toolbar.setTitle(R.string.about);
                        switchFragment(7);
                        toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, -140, -1010);
                        imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.mipmap.ic_drawer_about);
                        toast.setView(imageView);
                        toast.show();
                        break;
                }
                return false;
            }
        });
    }


    private void switchFragment(int type) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = fragments.get(type);
        //fragment是否添加过
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl_main, fragment);
        }
        //隐藏上一个碎片
        Fragment lastFragment = fragments.get(lastFragmentType);
        transaction.hide(lastFragment);
        //显示新的Fragment
        transaction.show(fragment);
        lastFragmentType = type;
        if (lastFragmentType == FragmentType.TYPE_WECHAT || lastFragmentType == FragmentType.TYPE_GANK) {
            item.setVisible(true);
        } else {
            item.setVisible(false);
        }
        transaction.commit();

    }

    private void addZhiFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_main, fragments.get(0));
        fragmentTransaction.commit();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhihuFragment());
        fragments.add(new WeCatFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new VetxFragment());
        fragments.add(new LikeFragment());
        fragments.add(new SettingFragment());
        fragments.add(new AboutFragment());

    }


    @Override
    public void initData() {


    }

    @Override
    public void initListener() {
        search.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (lastFragmentType == FragmentType.TYPE_WECHAT) {
                    EventBus.getDefault().post(new QueryBean(query, FragmentType.TYPE_WECHAT));
                } else if (lastFragmentType == FragmentType.TYPE_GANK) {
                }
//                Log.e("tag",query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        search.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                Log.e("tag", "打开");
            }

            @Override
            public void onSearchViewClosed() {
                Log.e("tag", "关闭");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.seach_main, menu);
        item = menu.findItem(R.id.action_seach);
        //隐藏搜索框
        item.setVisible(false);
        search.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
