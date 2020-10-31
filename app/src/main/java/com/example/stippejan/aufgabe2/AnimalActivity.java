package com.example.stippejan.aufgabe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalActivity extends AppCompatActivity {
    private static final String PARCELABLE_INTENT_KEY = "parcInt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        // Referenzen auf die Text- und ImageView erzeugen
        TextView textView = findViewById(R.id.animalTextView);
        ImageView imageView = findViewById(R.id.animalImageView);

        // Intent verarbeiten
        // Animal-Objekt extrahieren und Attribute in String einsetzen
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Animal animal = bundle.getParcelable(PARCELABLE_INTENT_KEY);
            int species = animal.getSpeciesStringId();
            int gender = animal.getGenderStringId();
            int age = animal.getAge();
            textView.setText(
                    String.format(
                            "%s %s %s %s %s %s %d %s",
                            getString(R.string.sentence1_part1),
                            getString(species),
                            getString(R.string.sentence1_part2),
                            getString(R.string.sentence2_part1),
                            getString(gender),
                            getString(R.string.sentence2_part2),
                            age,
                            getString(R.string.sentence2_part3)
                    )
            );

            // Das Bild angpasst an das species-Attribut des Animal-Objekts setzen
            // Passendes Foto je nach Tierart
            if (species == R.string.rabbit) {
                imageView.setImageResource(R.drawable.rabbit);
            } else if (species == R.string.deer) {
                imageView.setImageResource(R.drawable.deer);
            } else if (species == R.string.fox) {
                imageView.setImageResource(R.drawable.fox);
            } else if (species == R.string.eagle) {
                imageView.setImageResource(R.drawable.eagle);
            } else if (species == R.string.wolf) {
                imageView.setImageResource(R.drawable.wolf);
            }
        }
    }
}