package com.example.app3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = editText.getText().toString();
                    Toast.makeText(getApplicationContext(), "입력된 값을 변수에 저장했습니다 : " + name, Toast.LENGTH_LONG).show();
                }
            });
        }

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            Toast.makeText(this, "값을 복원했습니다 " + name, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "가로", Toast.LENGTH_SHORT).show();
            Log.d("Main", "세로");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "세로", Toast.LENGTH_SHORT).show();
            Log.d("Main", "가로");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name", name);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onCreate() 함수를 호출했습니다.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this,"onStop() 함수를 호출했습니다.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"onDestory() 함수를 호출했습니다.", Toast.LENGTH_LONG).show();
    }
}