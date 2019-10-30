package com.soft.videoplay;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MyGvAdapter extends BaseAdapter {
    Context context;
    LayoutInflater mInflater;
    List<String> list=new ArrayList<>();
    private VideoView videoView;

    public MyGvAdapter(Context context, List<String> strings) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = strings;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private int selectid = -1;
    //用于setOnItemSelectedListener中调用，赋值当前选择的item的position
    public void notifyDataSetChanged(int id) {
        selectid = id;
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.mygv_item_layout, null);
        final VideoView video = (VideoView) convertView.findViewById(R.id.videoView);
        if (selectid == position) {
            //开启动画
            Animation testAnim = AnimationUtils.loadAnimation(context, R.anim.vodani);

            convertView.startAnimation(testAnim);
        }

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0f,0f);
                video.setVideoURI(Uri.parse(list.get(position)));
                video.start();
            }
        });
        return convertView;
    }
}
