package com.example.stippejan.aufgabe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String EXPLICIT_INTENT_KEY = "expInt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView secondActivityTextView = findViewById(R.id.secondActivityTextView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            secondActivityTextView.setText(bundle.getString(EXPLICIT_INTENT_KEY));
        }
    }
}