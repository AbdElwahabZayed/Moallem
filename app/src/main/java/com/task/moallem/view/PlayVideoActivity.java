package com.task.moallem.view;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import com.task.moallem.R;
import com.task.moallem.model.Video;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayVideoActivity extends AppCompatActivity {

    int index = 0;

    @BindView(R.id.videoView)
    VideoView videoView;
    @BindView(R.id.playvideo_thumb_imagview)
    ImageView imageViewPlay;
    @BindView(R.id.video_thumb_imagview)
    ImageView imageViewThumb;
    public  static String TAG="PlayVideoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        ButterKnife.bind(this);
        Intent i=getIntent();
        if(i!=null) {
            Video video=i.getParcelableExtra("SelectedVideo");
            setVideoView(video);
        }
    }

    private void setVideoView(Video video) {
        imageViewThumb.setImageResource(video.getImage());

        final MediaController mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(videoView);
        videoView.setMediaController(mediacontroller);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                video.getVideo()));
        videoView.requestFocus();
        setVideoViewListeners(mediacontroller);
    }

    private void setVideoViewListeners(MediaController mediacontroller) {
        imageViewPlay.requestFocus();
        imageViewPlay.setOnClickListener(v -> {
            imageViewPlay.setVisibility(View.INVISIBLE);
            imageViewThumb.setVisibility(View.INVISIBLE);
            videoView.start();

        });
        videoView.setOnPreparedListener(mp -> mp.setOnVideoSizeChangedListener((mp1, width, height) -> {
            videoView.setMediaController(mediacontroller);
            mediacontroller.setAnchorView(videoView);
        }));

        videoView.setOnCompletionListener(mp -> mp.release());

        videoView.setOnErrorListener((mp, what, extra) -> {
            Log.d(TAG, "What " + what + " extra " + extra);
            return false;
        });
    }

}
