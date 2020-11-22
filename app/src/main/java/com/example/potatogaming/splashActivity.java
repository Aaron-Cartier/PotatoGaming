package com.example.potatogaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splashActivity extends AppCompatActivity {
    MediaPlayer splashPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashPlayer = new MediaPlayer();
        splashPlayer = MediaPlayer.create(this, R.raw.bit_intro);
        splashPlayer.start();

        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                finish();
                startActivity(new Intent(splashActivity.this, MainActivity.class));
                splashPlayer.stop();
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 5000);
    }
}