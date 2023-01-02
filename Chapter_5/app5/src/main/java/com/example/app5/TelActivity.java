package com.example.app5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelActivity extends AppCompatActivity {
    public static final int TEL_TO_MENU = 112;
    public static final int TEL_TO_MAIN = 122;

    TextView textView;

    MainFragment mainFragment;
    TelFragment telFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);

        textView = findViewById(R.id.textView_data);

        Intent intent = getIntent();
        getData(intent);

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        telFragment = new TelFragment();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(TEL_TO_MENU, intent);
                finish();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(TEL_TO_MAIN, intent);
                finish();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChangeButton(0);
            }
        });

    }

    private void getData(Intent intent) {
        Bundle bundle = intent.getExtras();
        SimpleData data = bundle.getParcelable("data");
        textView.setText("ID: " + data.id + "\nPW: " + data.pw);
    }

    public void onChangeButton(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, telFragment).commit();
        }
    }

}