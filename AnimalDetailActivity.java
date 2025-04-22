package com.example.at_lab_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalDetailActivity extends AppCompatActivity {

    private TextView nameView, speciesView, infoView;
    private AnimalDao animalDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        nameView = findViewById(R.id.animalNameView);
        speciesView = findViewById(R.id.animalSpeciesView);
        infoView = findViewById(R.id.animalInfoText);

        int animalId = getIntent().getIntExtra("animalId", -1);
        String fallbackSpecies = getIntent().getStringExtra("species");
        Button predictionButton = findViewById(R.id.viewPredictionButton);
        predictionButton.setOnClickListener(v -> {
            Intent intent = new Intent(AnimalDetailActivity.this, FinalPageActivity.class);
            intent.putExtra("animalName", nameView.getText().toString());
            intent.putExtra("animalSpecies", speciesView.getText().toString());
            startActivity(intent);
        });

        animalDao = AppDb.getInstance(this).animalDao();

        if (animalId != -1) {
            // 🧠 Fetch on background thread
            new Thread(() -> {
                Animal animal = animalDao.getById(animalId);
                runOnUiThread(() -> {
                    if (animal != null) {
                        nameView.setText(animal.getName());
                        speciesView.setText(animal.getSpecies());
                        infoView.setText(getSuggestedTreatment(animal.getSpecies(), animal.getName()));
                    } else {
                        setFallbackDisplay(fallbackSpecies);
                    }
                });
            }).start();
        } else {
            setFallbackDisplay(fallbackSpecies);
        }
    }

    private void setFallbackDisplay(String fallbackSpecies) {
        nameView.setText("");
        speciesView.setText(fallbackSpecies != null ? fallbackSpecies : "Unknown");
        infoView.setText(getSuggestedTreatment(fallbackSpecies, "This animal"));
    }

    private String getSuggestedTreatment(String species, String name) {
        if (species == null) return "No treatment suggestion available.";

        switch (species.toLowerCase()) {
            case "cow":
                return name + " should receive regular vaccinations and hoof care.";
            case "cat":
                return name + " may benefit from wellness checks and diet consulting.";
            case "goat":
                return name + " should have routine deworming and hoof trimming.";
            default:
                return "No specific treatment available for " + name + ".";
        }

    }

}


