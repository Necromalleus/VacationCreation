package com.example.mitchell.vacationcreation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Houses = {R.drawable.house1, R.drawable.house2, R.drawable.house3, R.drawable.house4, R.drawable.house5, R.drawable.house6};
    ImageView pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);



        GridView grid = (GridView)findViewById(R.id.gridview);
        //final ImageView pic = (ImageView)findViewById(R.id.imgLarge);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), "Select Healthy Snack " + (position+1), Toast.LENGTH_SHORT).show();
                //pic.setImageResource(Houses[position]);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", position);
                editor.apply();

                startActivity(new Intent(MainActivity.this, Main2Activity.class));



            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return Houses.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Houses[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(500, 350));
            return pic;
        }
    } // end class ImageAdapter
}