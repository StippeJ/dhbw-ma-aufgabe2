package com.example.stippejan.aufgabe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String PARCELABLE_INTENT_KEY = "parcInt";
    private static final String EXPLICIT_INTENT_KEY = "expInt";
    private final int[] SPECIES = { R.string.rabbit, R.string.deer, R.string.fox, R.string.eagle, R.string.wolf };
    private final int[] GENDERS = { R.string.male, R.string.female };
    private static final String[] EMAIL_ADRESSES = { "droidmule123@gmail.com" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

        // Click-Listener für den linken Button
        // Animal-Objekt mit Zufallswerten erstellen und mit Parcelable-Intent Activity starten
        Button button_left = findViewById(R.id.animal_button);
        button_left.setOnClickListener((v) -> {
            Animal animal = new Animal(
                    SPECIES[new Random().nextInt(SPECIES.length)],
                    GENDERS[new Random().nextInt(GENDERS.length)],
                    new Random().nextInt(8) + 1
            );
            Intent parcelableIntent = new Intent(getApplicationContext(), AnimalActivity.class);
            parcelableIntent.putExtra(PARCELABLE_INTENT_KEY, animal);
            MainActivity.this.startActivity(parcelableIntent);
        });

        // Click-Listener für den rechten Button
        // String zu Intent hinzufügen und Activity starten
        Button button_right = findViewById(R.id.button_right);
        button_right.setOnClickListener((v) -> {
            Intent explicitIntent = new Intent(getApplicationContext(), SecondActivity.class);
            explicitIntent.putExtra(EXPLICIT_INTENT_KEY, getString(R.string.second_activity));
            MainActivity.this.startActivity(explicitIntent);
        });

        // Click-Listener für den unteren Button
        // Email per Intent erstellen
        Button button_bottom = findViewById(R.id.email_button);
        button_bottom.setOnClickListener((v) -> {
            Intent implicitIntent = new Intent(Intent.ACTION_SENDTO);
            implicitIntent.setData(Uri.parse("mailto:"));
            implicitIntent.putExtra(Intent.EXTRA_EMAIL, EMAIL_ADRESSES);
            implicitIntent.putExtra(Intent.EXTRA_SUBJECT, "Mobile Anwendungen 2020 - Uebung2");
            implicitIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_content));
            startActivity(implicitIntent);
        });
    }
}