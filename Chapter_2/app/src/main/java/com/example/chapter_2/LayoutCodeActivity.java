package com.example.chapter_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LayoutCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainlayout = new LinearLayout(this);
        mainlayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        Button button1 = new Button(this);
        button1.setText("버튼");
        button1.setLayoutParams(params);

        EditText text1 = new EditText(this);
        text1.setText("NGS");
        text1.setLayoutParams(params);

        mainlayout.addView(button1);
        mainlayout.addView(text1);

        setContentView(mainlayout);
    }
}