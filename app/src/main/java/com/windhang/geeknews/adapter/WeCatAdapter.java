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
import com.windhang.geeknews.R;
import com.windhang.geeknews.bean.WechatBean;

import java.util.ArrayList;

public class WeCatAdapter extends RecyclerView.Adapter<WeCatAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WechatBean.NewslistBean> list;
    private OnItemCliclListener onItemCliclListener;

    public void setOnItemCliclListener(OnItemCliclListener onItemCliclListener) {
        this.onItemCliclListener = onItemCliclListener;
    }

    public WeCatAdapter(Context context, ArrayList<WechatBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_wecat, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final WechatBean.NewslistBean newslistBean = list.get(i);
        viewHolder.tv_ctime.setText(newslistBean.getCtime());
        viewHolder.tv_description.setText(newslistBean.getDescription());
        viewHolder.tv_title.setText(newslistBean.getTitle());
        Glide.with(context).load(newslistBean.getPicUrl()).into(viewHolder.iv_picUrl);
    }
    public void setList(ArrayList<WechatBean.NewslistBean> list) {
        this.list = list;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_ctime, tv_description;
        private ImageView iv_picUrl;
        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_picUrl = itemView.findViewById(R.id.iv_picUrl);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_ctime = itemView.findViewById(R.id.tv_ctime);
            tv_title = itemView.findViewById(R.id.tv_title);
            view = itemView;
        }
    }

    public interface OnItemCliclListener {
        void onItemClick(int position);
    }
}
