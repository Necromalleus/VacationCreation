package com.example.mitchell.vacationcreation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer mpJig, mpPipes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mpJig = new MediaPlayer();
        mpJig = MediaPlayer.create(this, R.raw.seagulls);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                mpJig.start();
            }// end run
        }; // end new TimerTask



        // schedule splash screen to be displayed for 5 seconds (= 5000 ms)
        Timer opening = new Timer();
        opening.schedule(task, 4800);
        mpJig.start();

    }



}
