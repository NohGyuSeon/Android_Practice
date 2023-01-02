package com.example.app5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BackActivity extends AppCompatActivity {
    public static final int BACK_TO_MENU = 111;
    public static final int BACK_TO_MAIN = 121;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        textView = findViewById(R.id.textView_data);

        Intent intent = getIntent();
        getData(intent);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(BACK_TO_MENU, intent);
                finish();
            }
        });

    }

    private void getData(Intent intent) {
        Bundle bundle = intent.getExtras();
        SimpleData data = bundle.getParcelable("data");
        textView.setText("ID: " + data.id + "\nPW: " + data.pw);
    }

}