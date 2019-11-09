package com.soft.videoplay.videoview;

import android.media.AudioManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.VideoView;

import com.soft.videoplay.R;

import java.io.IOException;
import java.util.ArrayList;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class DrawActivity extends AppCompatActivity {
    private IjkVideoView mVideoView;
    private IjkVideoView mVideoView1;
    private SurfaceView surfaceView1;
    private SurfaceView surfaceView2;
    private SurfaceView surfaceView3;
    private SurfaceView surfaceView4;
    private SurfaceHolder holder;
    private SurfaceHolder holder1;
    private SurfaceHolder holder2;
    private SurfaceHolder holder3;
    private SurfaceHolder holder4;
    private ArrayList<String> list = new ArrayList<>();
    private IjkMediaPlayer player;
    private IjkMediaPlayer player1;
    private IjkMediaPlayer player2;
    private IjkMediaPlayer player3;
    private IjkMediaPlayer player4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        mVideoView=findViewById(R.id.videoView);
        surfaceView1=findViewById(R.id.surface1);
        surfaceView2=findViewById(R.id.surface2);
        surfaceView3=findViewById(R.id.surface3);
        surfaceView4=findViewById(R.id.surface4);

        init();
    }

    private void init() {
        list.add("http://v-cdn.zjol.com.cn/280443.mp4");
        list.add("http://v-cdn.zjol.com.cn/276982.mp4");
        list.add("http://v-cdn.zjol.com.cn/276984.mp4");
        list.add("http://v-cdn.zjol.com.cn/276985.mp4");
        mVideoView.setVideoPath("http://v-cdn.zjol.com.cn/276985.mp4");
//        mVideoView.setFullscreen(true);
        mVideoView.start();

        player = new IjkMediaPlayer();
        player1 = new IjkMediaPlayer();
        player2= new IjkMediaPlayer();
        player3 = new IjkMediaPlayer();
        player4 = new IjkMediaPlayer();
        holder=mVideoView.getHolder();
        holder1=surfaceView1.getHolder();
        holder2=surfaceView2.getHolder();
        holder3=surfaceView3.getHolder();
        holder4=surfaceView4.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                play(player,holder,list.get(0));
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
        holder1.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                play(player1,holder1,list.get(0));
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        holder2.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                play(player2,holder2,list.get(1));
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
        holder3.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                play(player3,holder3,list.get(2));
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
        holder4.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                play(player4,holder4,list.get(3));
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }


    private void play(IjkMediaPlayer player,SurfaceHolder holder,String url){
        try {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.reset();

            player.setDataSource(url);
            player.setDisplay(holder);
            player.prepareAsync();
            player.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(IMediaPlayer iMediaPlayer) {
                    iMediaPlayer.setVolume(0f,0f);
                    player.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
