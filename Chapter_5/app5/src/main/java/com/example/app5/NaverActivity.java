package com.example.app5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NaverActivity extends AppCompatActivity {
    public static final int NAVER_TO_MENU = 113;
    public static final int NAVER_TO_MAIN = 123;

    TextView textView;

    MainFragment mainFragment;
    NaverFragment naverFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naver);

        textView = findViewById(R.id.textView_data);

        Intent intent = getIntent();
        getData(intent);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        naverFragment = new NaverFragment();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(NAVER_TO_MENU, intent);
                finish();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(NAVER_TO_MAIN, intent);
                finish();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChangeButton(1);
            }
        });

    }

    private void getData(Intent intent) {
        Bundle bundle = intent.getExtras();
        SimpleData data = bundle.getParcelable("data");
        textView.setText("ID: " + data.id + "\nPW: " + data.pw);
    }

    public void onChangeButton(int index) {
        if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, naverFragment).commit();
        }
    }

}