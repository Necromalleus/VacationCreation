package com.example.mitchell.vacationcreation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Main2Activity extends AppCompatActivity {
    Integer[] Houses = {R.drawable.house1, R.drawable.house2, R.drawable.house3, R.drawable.house4, R.drawable.house5, R.drawable.house6};
    int arr = 0;
    Button button1, button2, button3;
    MediaPlayer mpBirds, mpDrums;
    int playing;
    int radButtonKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Button button = (Button)findViewById(R.id.button2);
        ImageView image = (ImageView) findViewById(R.id.img2);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int arr = sharedPref.getInt("key1", 0);
        image.setImageResource(Houses[1]);




        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button3);
        button1.setOnClickListener(Sounds);
         final RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
         final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton8);
         final RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton7);

        mpBirds = new MediaPlayer();
        mpDrums = new MediaPlayer();
        mpBirds = MediaPlayer.create(this, R.raw.seagulls);
        mpDrums = MediaPlayer.create(this, R.raw.jig);
        playing = 0;

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



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButton3.isChecked()) {
                    radButtonKey = 0;
                }
                else if (radioButton2.isChecked()) {
                    radButtonKey = 1;
                }
                else if (radioButton.isChecked()){
                    radButtonKey = 2;
                }
                else {
                    radButtonKey = 4;
                }

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key2", radButtonKey);
                editor.apply();

                startActivity(new Intent(Main2Activity.this, Main3Activity.class));

            }
        });



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
