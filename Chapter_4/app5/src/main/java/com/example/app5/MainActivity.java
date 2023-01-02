package com.example.app5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
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

        println("onCreate 호출됨.");
        
        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                println("입력된 값을 변수에 저장했습니다 : " + name);
                name = editText.getText().toString();
            }
        });

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            println("값을 복원했습니다." + name);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        println("onStart 호출됨.");
    }

    @Override
    protected void onStop() {
        super.onStop();

        println("onStop 호출됨.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        println("onDestroy 호출됨.");
    }

    @Override
    protected void onPause() {
        super.onPause();

        println("onPause 호출됨.");
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();

        println("onCreate 호출됨.");
        restoreState();
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ( (pref != null) && (pref.contains("name")) ) {
            String name = pref.getString("name", "");
            editText.setText(name);
        }
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", editText.getText().toString());
        editor.commit();
    }

    protected void clearState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        
        outState.putString("name", name);
    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        Log.d("Main", data);
    }
    
}