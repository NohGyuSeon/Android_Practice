package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView1;
    ScrollView scrollView2;
    ImageView imageView1;
    ImageView imageView2;
    BitmapDrawable bitmap;
    int count1 = 0;
    int count2 = 0;
    int index = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView1 = findViewById(R.id.scroll1);
        scrollView2 = findViewById(R.id.scroll2);
        imageView1 = findViewById(R.id.imageview1);
        imageView2 = findViewById(R.id.imageview2);

        scrollView1.setHorizontalScrollBarEnabled(true);
        scrollView1.setVerticalScrollBarEnabled(true);

        scrollView2.setHorizontalScrollBarEnabled(true);
        scrollView2.setVerticalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);

        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView1.setImageDrawable(bitmap);

        imageView1.getLayoutParams().width = bitmapWidth;
        imageView1.getLayoutParams().height = bitmapHeight;

        imageView2.setVisibility(View.INVISIBLE);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count1 == 0) {
                    Resources res = getResources();
                    bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);

                    int bitmapWidth = bitmap.getIntrinsicWidth();
                    int bitmapHeight = bitmap.getIntrinsicHeight();

                    imageView1.setImageDrawable(bitmap);
                    imageView1.getLayoutParams().width = bitmapWidth;
                    imageView1.getLayoutParams().height = bitmapHeight;

                    imageView2.setImageDrawable(bitmap);
                    imageView2.getLayoutParams().width = bitmapWidth;
                    imageView2.getLayoutParams().height = bitmapHeight;

                    if (index == 0) {
                        imageView2.setVisibility(View.INVISIBLE);
                    } else if (index == 1){
                        imageView1.setVisibility(View.INVISIBLE);
                    }

                    count1 = 1;
                } else if (count1 == 1) {
                    Resources res = getResources();
                    bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);

                    int bitmapWidth = bitmap.getIntrinsicWidth();
                    int bitmapHeight = bitmap.getIntrinsicHeight();

                    imageView1.setImageDrawable(bitmap);
                    imageView1.getLayoutParams().width = bitmapWidth;
                    imageView1.getLayoutParams().height = bitmapHeight;

                    imageView2.setImageDrawable(bitmap);
                    imageView2.getLayoutParams().width = bitmapWidth;
                    imageView2.getLayoutParams().height = bitmapHeight;

                    if (index == 0) {
                        imageView2.setVisibility(View.INVISIBLE);
                    } else if (index == 1){
                        imageView1.setVisibility(View.INVISIBLE);
                    }

                    count1 = 0;
                }
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count2 == 0) {
                    Resources res = getResources();
                    bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);

                    int bitmapWidth = bitmap.getIntrinsicWidth();
                    int bitmapHeight = bitmap.getIntrinsicHeight();

                    imageView1.setImageDrawable(bitmap);
                    imageView1.getLayoutParams().width = bitmapWidth;
                    imageView1.getLayoutParams().height = bitmapHeight;

                    imageView2.setImageDrawable(bitmap);
                    imageView2.getLayoutParams().width = bitmapWidth;
                    imageView2.getLayoutParams().height = bitmapHeight;

                    if (index == 0) {
                        imageView2.setVisibility(View.INVISIBLE);
                    } else if (index == 1){
                        imageView1.setVisibility(View.INVISIBLE);
                    }

                    count2 = 1;
                } else if (count2 == 1) {
                    Resources res = getResources();
                    bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image03);

                    int bitmapWidth = bitmap.getIntrinsicWidth();
                    int bitmapHeight = bitmap.getIntrinsicHeight();

                    imageView1.setImageDrawable(bitmap);
                    imageView1.getLayoutParams().width = bitmapWidth;
                    imageView1.getLayoutParams().height = bitmapHeight;

                    imageView2.setImageDrawable(bitmap);
                    imageView2.getLayoutParams().width = bitmapWidth;
                    imageView2.getLayoutParams().height = bitmapHeight;

                    if (index == 0) {
                        imageView2.setVisibility(View.INVISIBLE);
                    } else if (index == 1){
                        imageView1.setVisibility(View.INVISIBLE);
                    }

                    count2 = 0;
                }
            }
        });

    }

    public void onClickdown(View view) {
        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.VISIBLE);

        index = 1;
    }

    public void onClickup(View view) {
        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.INVISIBLE);

        index = 0;
    }

}