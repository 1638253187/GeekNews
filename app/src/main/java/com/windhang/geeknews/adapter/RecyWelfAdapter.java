package com.windhang.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.windhang.geeknews.R;
import com.windhang.geeknews.bean.WelfareBean;

import java.util.ArrayList;

public class RecyWelfAdapter extends RecyclerView.Adapter<RecyWelfAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WelfareBean.ResultsBean>list;
    private OnItemCliclListener onItemCliclListener;

    public void setOnItemCliclListener(OnItemCliclListener onItemCliclListener) {
        this.onItemCliclListener = onItemCliclListener;
    }

    public RecyWelfAdapter(Context context, ArrayList<WelfareBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_fl, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        WelfareBean.ResultsBean resultsBean = list.get(i);
        Glide.with(context).load(resultsBean.getUrl()).into(viewHolder.iv_url);
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
        private ImageView iv_url;
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
              iv_url = itemView.findViewById(R.id.iv_url);
            view=itemView;
        }
    }

    public interface OnItemCliclListener {
        void onItemClick(int position);
    }
}
