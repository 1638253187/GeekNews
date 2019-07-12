package com.windhang.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.windhang.geeknews.R;
import com.windhang.geeknews.bean.GankBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class GankAdapter extends RecyclerView.Adapter<GankAdapter.ViewHolder> {
    private ArrayList<GankBean.ResultsBean> list;
    private Context context;
    private OnItemCliclListener onItemCliclListener;
    private SimpleDateFormat sjgs=  new SimpleDateFormat("yyyy-MM-dd");

    public void setOnItemCliclListener(OnItemCliclListener onItemCliclListener) {
        this.onItemCliclListener = onItemCliclListener;
    }

    public GankAdapter(ArrayList<GankBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_gank_one, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        GankBean.ResultsBean resultsBean = list.get(i);
        String sss = resultsBean.getCreatedAt().substring(0,19).replaceAll("T"," ");
        viewHolder.tv_createdAt.setText(sss);
        viewHolder.tv_desc.setText(resultsBean.getDesc());
        viewHolder.tv_who.setText(resultsBean.getWho());
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
        private TextView tv_who, tv_desc, tv_createdAt;
        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_createdAt = itemView.findViewById(R.id.tv_createdAt);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_who = itemView.findViewById(R.id.tv_who);
            view=itemView;
        }
    }

    public interface OnItemCliclListener {
        void onItemClick(int position);
    }
}
