package com.windhang.geeknews.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.windhang.geeknews.R;
import com.windhang.geeknews.bean.NewsBean;
import com.youth.banner.loader.ImageLoader;

public class BannAdapter extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        NewsBean.TopStoriesBean topStoriesBean = (NewsBean.TopStoriesBean) path;
        RequestOptions options = new RequestOptions().placeholder(R.mipmap.bg_drawer);
        Glide.with(context).load(topStoriesBean.getImage()).apply(options).into(imageView);
    }
}
