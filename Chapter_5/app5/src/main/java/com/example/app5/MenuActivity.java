package com.example.app5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int MENU_TO_BACK = 101;
    public static final int MENU_TO_TEL = 102;
    public static final int MENU_TO_NAVER = 103;
    public static final int BACK_TO_MENU = 111;
    public static final int TEL_TO_MENU = 112;
    public static final int NAVER_TO_MENU = 113;
    public static final int BACK_TO_MAIN = 121;
    public static final int TEL_TO_MAIN = 122;
    public static final int NAVER_TO_MAIN = 123;
    SimpleData data;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MENU_TO_BACK) {
            println("메뉴에서 돌아가기\n요청 코드: " + requestCode);
        } else if (requestCode == MENU_TO_TEL) {
            println("메뉴에서 전화걸기\n요청 코드: " + requestCode);
        } else if (requestCode == MENU_TO_NAVER) {
            println("메뉴에서 네이버\n요청 코드: " + requestCode);
        }

        if (resultCode == BACK_TO_MENU) {
            println("돌아가기에서 메뉴\n결과 코드: " + resultCode);
        } else if (resultCode == TEL_TO_MENU) {
            println("전화걸기에서 메뉴\n결과 코드: " + resultCode);
        } else if (resultCode == NAVER_TO_MENU) {
            println("네이버에서 메뉴\n결과 코드: " + resultCode);
        }

        if (resultCode == BACK_TO_MAIN) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("name", "(메인) 돌아가기");
            setResult(BACK_TO_MAIN, intent);
            finish();
        } else if (resultCode == TEL_TO_MAIN) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("name", "(메인) 전화걸기");
            setResult(TEL_TO_MAIN, intent);
            finish();
        } else if (resultCode == NAVER_TO_MAIN) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("name", "(메인) 네이버");
            setResult(NAVER_TO_MAIN, intent);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        data = getData(getIntent());

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BackActivity.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, MENU_TO_BACK);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TelActivity.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, MENU_TO_TEL);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NaverActivity.class);
                intent.putExtra("data", data);
                startActivityForResult(intent, MENU_TO_NAVER);
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