package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomerActivity extends AppCompatActivity {
    public static final int CUSTOMER_TO_MENU = 111;
    public static final int CUSTOMER_TO_MAIN = 121;

    TextView textView_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        textView_data = findViewById(R.id.textView_data);

        Intent intent = getIntent();
        getData(intent);

        Button btn_customer_menu = findViewById(R.id.btn_customer_menu);
        btn_customer_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("name", "고객");
                setResult(CUSTOMER_TO_MENU, intent);
                finish();
            }
        });

        Button btn_customer_login = findViewById(R.id.btn_customer_login);
        btn_customer_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("name", "고객");
                setResult(CUSTOMER_TO_MAIN, intent);
                finish();
            }
        });

    }

    private void getData(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");

            textView_data.setText("ID: " + data.id + "\nPW: " + data.pw);
        }
    }

}