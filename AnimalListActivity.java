/*package com.example.at_lab_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.Executors;

public class AnimalListActivity extends AppCompatActivity implements AnimalListAdapter.OnAnimalClickListener {

    private RecyclerView recyclerView;
    private TextView title;
    private AnimalDao animalDao;
    private String species;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        recyclerView = findViewById(R.id.recyclerView);
        title = findViewById(R.id.titleText);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        species = getIntent().getStringExtra("species");
        if (species == null) species = "Cow";

        title.setText("Animals: " + species);

        animalDao = AppDb.getInstance(this).animalDao();

        // Run the database query on a background thread
        Executors.newSingleThreadExecutor().execute(() -> {
            List<Animal> animals = animalDao.getBySpecies(species);

            // Update RecyclerView on the main thread
            runOnUiThread(() -> {
                AnimalListAdapter adapter = new AnimalListAdapter(animals, this);
                recyclerView.setAdapter(adapter);
            });
        });
    }

    @Override
    public void onAnimalClick(Animal animal) {
        Intent intent = new Intent(this, AnimalDetailActivity.class);
        intent.putExtra("animalId", animal.id);
        startActivity(intent);
    }
}*/


