package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageview1;
    ImageView imageview2;
    ImageView imageview3;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview1 = findViewById(R.id.imageView1);
        imageview2 = findViewById(R.id.imageView2);
        imageview3 = findViewById(R.id.imageView3);
    }

    public void onClicked1(View view) {
        if (count == 0) {
            imageview1.setVisibility(View.VISIBLE);
            imageview2.setVisibility(View.INVISIBLE);
            imageview3.setVisibility(View.INVISIBLE);

            count = 1;
        } else if (count == 1) {
            imageview1.setVisibility(View.INVISIBLE);
            imageview2.setVisibility(View.VISIBLE);
            imageview3.setVisibility(View.INVISIBLE);

            count = 2;
        } else if (count == 2) {
            imageview1.setVisibility(View.INVISIBLE);
            imageview2.setVisibility(View.INVISIBLE);
            imageview3.setVisibility(View.VISIBLE);

            count = 0;
        }
    }
}