package com.example.app7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {
    public static final int PRODUCT_TO_MENU = 113;
    public static final int PRODUCT_TO_MAIN = 123;

    TextView textView_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        textView_data = findViewById(R.id.textView_data);

        Intent intent = getIntent();
        getData(intent);

        Button btn_product_menu = findViewById(R.id.btn_product_menu);
        btn_product_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("name", "상품");
                setResult(PRODUCT_TO_MENU, intent);
                finish();
            }
        });

        Button btn_product_login = findViewById(R.id.btn_product_login);
        btn_product_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("name", "상품");
                setResult(PRODUCT_TO_MAIN, intent);
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