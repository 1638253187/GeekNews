package com.windhang.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.windhang.geeknews.R;
import com.windhang.geeknews.bean.NewsBean;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RecyNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<NewsBean.StoriesBean> newslist;
    private ArrayList<NewsBean.TopStoriesBean> bannerlist;
    private OnItemClickListener mListener;



    private int finalNewsPosition;

    public RecyNewsAdapter(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public RecyNewsAdapter(Context context, ArrayList<NewsBean.StoriesBean> newslist, ArrayList<NewsBean.TopStoriesBean> bannerlist) {
        this.context = context;
        this.newslist = newslist;
        this.bannerlist = bannerlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int type = getItemViewType(i);
        switch (type) {
            case 0:
                View inflate = LayoutInflater.from(context).inflate(R.layout.item_news, null);
                return new ViewHolder(inflate);
            case 1:
                View inflate1 = LayoutInflater.from(context).inflate(R.layout.item_news_tow, null);
                return new ViewHolder1(inflate1);
            case 2:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.item_news_three, null);
                return new ViewHolder2(inflate2);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        if (type == 0) {
            NewsBean.TopStoriesBean topStoriesBean = bannerlist.get(i);
            final ViewHolder viewHolder1 = (ViewHolder) viewHolder;
            viewHolder1.banner.setImages(bannerlist);
            viewHolder1.banner.setBannerTitles(Collections.singletonList(topStoriesBean.getTitle()));
            viewHolder1.banner.setImageLoader(new BannAdapter()).start();
        }else if (type==1){

        }else{
            int newspostion = i - 1;
            if (bannerlist.size()>0){
                newspostion-=1;
            }
            ViewHolder2 viewHolder1 = (ViewHolder2) viewHolder;
            NewsBean.StoriesBean storiesBean = newslist.get(newspostion);
            viewHolder1.tv_title.setText(storiesBean.getTitle());
            List<String> images = storiesBean.getImages();
            if (images!=null&&images.size()>0){
                RequestOptions options = new RequestOptions().placeholder(R.mipmap.ic_launcher);
                Glide.with(context).load(images.get(0)).apply(options).into(viewHolder1.iv_images);

                final int finalNewPosition = newspostion;
                viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mListener != null) {
                            mListener.onItemClick(v, newslist.get(finalNewPosition));
                        }
                    }
                });
            }
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (bannerlist.size()>0) {
            if (position == 0) {
                return 0;
            } else if (position == 1) {
                return 1;
            } else {
                return 2;
            }
        }else {
            if (position==0){
                return 1;
            }else {
                return 2;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (bannerlist.size() > 0) {
            return newslist.size() + 1 + 1;
        } else {
            return newslist.size() + 1;
        }
    }


    public void setData(NewsBean bean) {

        List<NewsBean.TopStoriesBean> top_stories = bean.getTop_stories();
        bannerlist.clear();
        bannerlist.addAll(top_stories);

        List<NewsBean.StoriesBean> stories = bean.getStories();
        newslist.clear();
        newslist.addAll(stories);
        notifyDataSetChanged();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private View view;
        public Banner banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            banner = itemView.findViewById(R.id.banner);
            view=itemView;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        private TextView tv_time;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView iv_images;
        private View view;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            iv_images = itemView.findViewById(R.id.iv_images);
            tv_title = itemView.findViewById(R.id.tv_title);
            view=itemView;
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View v, NewsBean.StoriesBean pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}
