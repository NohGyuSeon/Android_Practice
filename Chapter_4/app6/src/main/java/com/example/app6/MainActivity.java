package com.example.app6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int MENU_TO_UNIVERSITY = 101;
    public static final int MENU_TO_NAVER = 102;
    public static final int MENU_TO_GOOGLE = 103;
    public static final int UNIVERSITY_TO_MENU = 111;
    public static final int NAVER_TO_MENU = 112;
    public static final int GOOGLE_TO_MENU = 113;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MENU_TO_UNIVERSITY) {
            println("onActivityResult 메서드 호출 (메뉴 → 대학교)\n요청 코드 : " +
                    requestCode + "\n응답 코드 : " + resultCode);
       } else if (requestCode == MENU_TO_NAVER) {
            println("onActivityResult 메서드 호출 (메뉴 → 네이버)\n요청 코드 : " +
                    requestCode + "\n응답 코드 : " + resultCode);
        } else if (requestCode == MENU_TO_GOOGLE) {
            println("onActivityResult 메서드 호출 (메뉴 → 구글)\n요청 코드 : " +
                    requestCode + "\n응답 코드 : " + resultCode);
        }

        String name = data.getStringExtra("name");

        if (resultCode == UNIVERSITY_TO_MENU) {
            println("응답으로 전달된 name : " + name +
                    "\n대학교 → 메뉴");
        } else  if (resultCode == NAVER_TO_MENU) {
            println("응답으로 전달된 name : " + name +
                    "\n네이버 → 메뉴");
        } else  if (resultCode == GOOGLE_TO_MENU) {
            println("응답으로 전달된 name : " + name +
                    "\n구글 → 메뉴");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UniversityActivity.class);
                startActivityForResult(intent, MENU_TO_UNIVERSITY);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NaverActivity.class);
                startActivityForResult(intent, MENU_TO_NAVER);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoogleActivity.class);
                startActivityForResult(intent, MENU_TO_GOOGLE);
            }
        });

    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

}