package com.windhang.geeknews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.windhang.geeknews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Welf_Image extends AppCompatActivity {

    @BindView(R.id.iv_pic)
    ImageView ivPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welf__image);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        Glide.with(this).load(pic).into(ivPic);
    }
}
