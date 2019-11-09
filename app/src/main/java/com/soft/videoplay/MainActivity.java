package com.soft.videoplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.soft.videoplay.videoview.IjkUniversalMediaController;
import com.soft.videoplay.videoview.IjkVideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> list = new ArrayList<>();
    private IjkVideoView mVideoView;
    private IjkUniversalMediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView=findViewById(R.id.videoView);
        mediaController=findViewById(R.id.media_controller);
        init();
    }

    private void init() {
        list.add("https://v-cdn.zjol.com.cn/280443.mp4");
        list.add("https://v-cdn.zjol.com.cn/276982.mp4");
        list.add("https://v-cdn.zjol.com.cn/276984.mp4");
        list.add("https://v-cdn.zjol.com.cn/276985.mp4");

        mVideoView.setVideoPath("http://v-cdn.zjol.com.cn/276985.mp4");
        mVideoView.setMediaController(mediaController);
        mVideoView.setFullscreen(true);
        mVideoView.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        mVideoView.stopPlayback();
    }
}