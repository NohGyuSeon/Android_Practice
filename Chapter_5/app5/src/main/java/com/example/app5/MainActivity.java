package com.example.app5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int MAIN_TO_MENU = 100;
    public static final int BACK_TO_MAIN = 121;
    public static final int TEL_TO_MAIN = 122;
    public static final int NAVER_TO_MAIN = 123;

    EditText editTextID;
    EditText editTextPW;
    String ID, PW;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == BACK_TO_MAIN) {
            String name = data.getStringExtra("name");
            println("돌아가기 → 메인\n받은 응답 : " + name);
        } else if (resultCode == TEL_TO_MAIN) {
            String name = data.getStringExtra("name");
            println("전화걸기 → 메인\n받은 응답 : " + name);
        } else if (resultCode == NAVER_TO_MAIN) {
            String name = data.getStringExtra("name");
            println("네이버 → 메인\n받은 응답 : " + name);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextID = findViewById(R.id.editTextTextPersonName);
        editTextPW = findViewById(R.id.editTextTextPersonName2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkLogin()) {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    SimpleData data = new SimpleData(ID, PW);
                    intent.putExtra("data", data);
                    startActivityForResult(intent, MAIN_TO_MENU);
                } else {
                    Toast.makeText(getApplicationContext(), "ID/PW 값을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean checkLogin() {
        ID = editTextID.getText().toString();
        PW = editTextPW.getText().toString();

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