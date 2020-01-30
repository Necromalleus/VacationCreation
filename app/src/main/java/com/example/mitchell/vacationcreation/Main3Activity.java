package com.example.mitchell.vacationcreation;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Integer[] Houses = {R.drawable.house1, R.drawable.house2, R.drawable.house3, R.drawable.house4, R.drawable.house5, R.drawable.house6};
    int arr = 0;
    int arr2;
    MediaPlayer mpBirds, mpDrums;
    int playing;
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final TextView result = (TextView) findViewById(R.id.finalText);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        ImageView image = (ImageView) findViewById(R.id.img3);


        int arr = sharedPref.getInt("key1", 0);
        int arr2 = sharedPref.getInt("key2", 0);
        image.setImageResource(Houses[1]);

        button1 = findViewById(R.id.button4);
        button2 = findViewById(R.id.button5);
        button1.setOnClickListener(Sounds);


        mpBirds = new MediaPlayer();
        mpDrums = new MediaPlayer();
        mpBirds = MediaPlayer.create(this, R.raw.seagulls);
        mpDrums = MediaPlayer.create(this, R.raw.jig);
        playing = 0;

        if (arr2 == 0) {
            result.setText("Congratulations! You have booked One Bedroom in this house. Feel free to listen to more sounds from the surrounding are.");
        }
        else if (arr2 == 1) {
            result.setText("Congratulations! You have booked Two Bedroom in this house. Feel free to listen to more sounds from the surrounding are.");
        }
        else {
            result.setText("Congratulations! You have booked Three Bedroom in this house. Feel free to listen to more sounds from the surrounding are.");
        }

        if (arr == 0) {
            image.setImageResource(R.drawable.house1);
            mpBirds = MediaPlayer.create(this, R.raw.bird_and_rain);
        } else if (arr == 1) {
            image.setImageResource(R.drawable.house2);
            mpBirds = MediaPlayer.create(this, R.raw.crickets);
        } else if (arr == 2) {
            image.setImageResource(R.drawable.house3);
            mpBirds = MediaPlayer.create(this, R.raw.ocean_waves);
        } else if (arr == 3) {
            image.setImageResource(R.drawable.house4);
            mpBirds = MediaPlayer.create(this, R.raw.water_fountain);
        } else if (arr == 4) {
            image.setImageResource(R.drawable.house5);
            mpBirds = MediaPlayer.create(this, R.raw.monsoon);
        } else {
            image.setImageResource(R.drawable.house6);
            mpBirds = MediaPlayer.create(this, R.raw.churning_water);
        }

    }

    Button.OnClickListener Sounds = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpBirds.start();
                    playing = 1;
                    button1.setText("Pause Sounds");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpBirds.pause();
                    playing = 0;
                    button1.setText("Play Sounds From The Area");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };



}
