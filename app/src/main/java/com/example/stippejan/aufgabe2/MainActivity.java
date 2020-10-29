package com.example.stippejan.aufgabe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button_right);
        button1.setOnClickListener((v) -> {
            Intent explicitIntent = new Intent(getApplicationContext(), SecondActivity.class);
            MainActivity.this.startActivity(explicitIntent);
        });
    }
}