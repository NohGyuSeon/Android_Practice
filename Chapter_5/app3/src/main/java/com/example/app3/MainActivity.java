package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    MenuFragment_1 menuFragment_1;
    MenuFragment_2 menuFragment_2;
    MenuFragment_3 menuFragment_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment_1 = (MenuFragment_1) getSupportFragmentManager().findFragmentById(R.id.menuFragment_1);
        menuFragment_2 = new MenuFragment_2();
        menuFragment_3 = new MenuFragment_3();
    }

    public void onFragmentChanged(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container3, menuFragment_1).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container3, menuFragment_2).commit();
        } else if (index == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container3, menuFragment_3).commit();
        }

    }

}