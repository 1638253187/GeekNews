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
import com.windhang.geeknews.bean.ZuanBean;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ZuanBean.DataBean> list;

    public RecyAdapter(Context context, ArrayList<ZuanBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_zuan, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZuanBean.DataBean dataBean = list.get(i);
        viewHolder.tv_description.setText(dataBean.getDescription());
        viewHolder.tv_name.setText(dataBean.getName());
        Glide.with(context).load(dataBean.getThumbnail()).into(viewHolder.iv_thumbnail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_thumbnail;
        private TextView tv_name, tv_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_thumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
        }
    }
}
