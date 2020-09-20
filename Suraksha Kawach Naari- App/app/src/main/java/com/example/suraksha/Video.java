package com.example.suraksha;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {
    Button clk;
    VideoView videov;
    MediaController mediaC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        clk = (Button) findViewById(R.id.button);
        videov = (VideoView) findViewById(R.id.videoview);
        mediaC = new MediaController(this);


    }
public void videoplay(View v) {
        String videopath = "android.resource://com.example.naari/"+R.raw.video;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        videov.start();

}


}
