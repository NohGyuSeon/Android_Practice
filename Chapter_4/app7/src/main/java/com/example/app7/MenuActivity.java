package com.example.app7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int MAIN_TO_MENU = 100;
    public static final int MENU_TO_CUSTOMER = 101;
    public static final int MENU_TO_COST = 102;
    public static final int MENU_TO_PRODUCT = 103;
    public static final int CUSTOMER_TO_MENU = 111;
    public static final int COST_TO_MENU = 112;
    public static final int PRODUCT_TO_MENU = 113;
    public static final int CUSTOMER_TO_MAIN = 121;
    public static final int COST_TO_MAIN = 122;
    public static final int PRODUCT_TO_MAIN = 123;
    SimpleData data;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MAIN_TO_MENU) {
            println("MAIN_TO_MENU 요청 코드 : " + requestCode + ", 응답 코드 : " + resultCode);
        } else if (requestCode == MENU_TO_CUSTOMER) {
            println("MENU_TO_CUSTOMER 요청 코드 : " + requestCode + ", 응답 코드 : " + resultCode);
        } else if (requestCode == MENU_TO_COST) {
            println("MENU_TO_COST 요청 코드 : " + requestCode + ", 응답 코드 : " + resultCode);
        } else if (requestCode == MENU_TO_PRODUCT) {
            println("MENU_TO_PRODUCT 요청 코드 : " + requestCode + ", 응답 코드 : " + resultCode);
        }

        if (resultCode == CUSTOMER_TO_MENU) {
            String name = data.getStringExtra("name");
            println("고객 → 메뉴\n받은 응답 : " + name);
        } else if (resultCode == COST_TO_MENU) {
            String name = data.getStringExtra("name");
            println("매출 → 메뉴\n받은 응답 : " + name);
        } else if (resultCode == PRODUCT_TO_MENU) {
            String name = data.getStringExtra("name");
            println("상품 → 메뉴\n받은 응답 : " + name);
        }

        if (resultCode == CUSTOMER_TO_MAIN) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("name", "메뉴 (고객)");
            setResult(CUSTOMER_TO_MAIN, intent);
            finish();
        } else if (resultCode == COST_TO_MAIN) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("name", "메뉴 (매출)");
            setResult(COST_TO_MAIN, intent);
            finish();
        } else if (resultCode == PRODUCT_TO_MAIN) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("name", "메뉴 (상품)");
            setResult(PRODUCT_TO_MAIN, intent);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        data = getData(getIntent());

        Button btn_customer = findViewById(R.id.btn_customer);
        btn_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, MENU_TO_CUSTOMER);
            }
        });

        Button btn_cost = findViewById(R.id.btn_cost);
        btn_cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CostActivity.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, MENU_TO_COST);
            }
        });

        Button btn_login = findViewById(R.id.btn_product);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, MENU_TO_PRODUCT);
            }
        });

    }

    public SimpleData getData(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");
            return data;
        } else {
            return null;
        }
    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
    
}