package com.soft.videoplay;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.VideoView;

import com.soft.videoplay.videoview.UniversalMediaController;
import com.soft.videoplay.videoview.UniversalVideoView;

import java.util.ArrayList;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> list = new ArrayList<>();
    private UniversalVideoView mVideoView;
    UniversalMediaController mediaController;
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = findViewById(R.id.videoView);
        mediaController = findViewById(R.id.media_controller);
        gridview = findViewById(R.id.gridview);
        init();
    }

    private void init() {
        list.add("https://v-cdn.zjol.com.cn/280443.mp4");
        list.add("https://v-cdn.zjol.com.cn/276982.mp4");
        list.add("https://v-cdn.zjol.com.cn/276984.mp4");
        list.add("https://v-cdn.zjol.com.cn/276985.mp4");

        mVideoView.setVideoPath("https://v-cdn.zjol.com.cn/276985.mp4");
        mVideoView.setMediaController(mediaController);
        mVideoView.start();
        mVideoView.setVideoViewCallback(new UniversalVideoView.VideoViewCallback() {
            @Override
            public void onScaleChange(boolean isFullscreen) {

            }

            @Override
            public void onPause(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onStart(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onBufferingStart(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onBufferingEnd(MediaPlayer mediaPlayer) {

            }
        });
       /* videoView.setVideoURI(Uri.parse("https://v-cdn.zjol.com.cn/276998.mp4"));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });*/

//        MyGvAdapter adapter=new MyGvAdapter(this,list);
//        gridview.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}