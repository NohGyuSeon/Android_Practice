package com.example.chapter_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textview3 = findViewById(R.id.textView3);

        editText.addTextChangedListener(new TextWatcher() {
            String beforeText;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                beforeText = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = showBytes();
                if(length > 80) editText.setText(beforeText);
            }
        });
    }

    private int showBytes() {
        try {
            int length = editText.getText().toString().getBytes("EUC-KR").length;
            textview3.setText(length + " / 80 바이트");
            return length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void onClickedSend(View view) {
        String s = editText.getText().toString();
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        editText.setText("");
    }

}