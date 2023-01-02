package com.example.app4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(this, "onActivityResult() 메서드 호출됨. 요청코드 : " +
                    requestCode + ", 결과 코드 : " + resultCode, Toast.LENGTH_SHORT).show();
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(this, "응답으로 전달된 name : " + name, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                SimpleData data = new SimpleData(100, "Hello Android!");
                intent.putExtra(KEY_SIMPLE_DATA, data);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
        
    }
}