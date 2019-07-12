package com.windhang.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.windhang.geeknews.R;
import com.windhang.geeknews.bean.HotBean;

import java.util.ArrayList;

public class RecyHotAdapter extends RecyclerView.Adapter<RecyHotAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HotBean.RecentBean> list;
    private OnItemCliclListener onItemCliclListener;

    public void setOnItemCliclListener(OnItemCliclListener onItemCliclListener) {
        this.onItemCliclListener = onItemCliclListener;
    }

    public RecyHotAdapter(Context context, ArrayList<HotBean.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hot, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        HotBean.RecentBean recentBean = list.get(i);
        viewHolder.tv_title.setText(recentBean.getTitle());
        RequestOptions transform = new RequestOptions().transform(new RoundedCorners(4));
        Glide.with(context).load(recentBean.getThumbnail()).apply(transform).into(viewHolder.iv_thumbnail);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemCliclListener!=null){
                    onItemCliclListener.onItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView iv_thumbnail;
        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_thumbnail = itemView.findViewById(R.id.iv_thumbnail);
            view = itemView;
        }
    }

    public interface OnItemCliclListener {
        void onItemClick(int position);
    }
}
