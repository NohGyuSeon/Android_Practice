package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ViewerFragment viewerFragment;
    ListFragment listFragment;

    int[] images = {R.drawable.image01, R.drawable.image02, R.drawable.image03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewerFragment = (ViewerFragment) getSupportFragmentManager().findFragmentById(R.id.viewerFragment);
        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);
    }

    public void onImageChanged(int index) {
        if (index == 0) {
            ViewerFragment.setImage(images[0]);
        } else if (index == 1) {
            ViewerFragment.setImage(images[1]);
        } else if (index == 2) {
            ViewerFragment.setImage(images[2]);
        }
    }

}