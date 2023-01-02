package com.example.app7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int MAIN_TO_MENU = 100;
    public static final int CUSTOMER_TO_MAIN = 121;
    public static final int SALES_TO_MAIN = 122;
    public static final int PRODUCT_TO_MAIN = 123;

    EditText editID;
    EditText editPW;
    String ID, PW;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == CUSTOMER_TO_MAIN) {
            String name = data.getStringExtra("name");
            println("고객 → 메인\n받은 응답 : " + name);
        } else if (resultCode == SALES_TO_MAIN) {
            String name = data.getStringExtra("name");
            println("매출 → 메인\n받은 응답 : " + name);
        } else if (resultCode == PRODUCT_TO_MAIN) {
            String name = data.getStringExtra("name");
            println("상품 → 메인\n받은 응답 : " + name);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editID = findViewById(R.id.editTextTextPersonName);
        editPW = findViewById(R.id.editTextTextPersonName2);

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLogin()) {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    SimpleData data = new SimpleData(ID, PW);
                    intent.putExtra("data", data);
                    startActivityForResult(intent, MAIN_TO_MENU);
                } else {
                    Toast.makeText(getApplicationContext(), "ID/PW를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkLogin() {
        ID = editID.getText().toString();
        PW = editPW.getText().toString();

        if (ID.length() < 1 || PW.length() < 1) {
            return false;
        } else {
            return true;
        }
    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

}