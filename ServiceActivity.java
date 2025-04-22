package com.example.at_lab_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivity extends AppCompatActivity {

    RecyclerView serviceRecyclerView;
    TextView title;
    String species;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        serviceRecyclerView = findViewById(R.id.serviceRecyclerView);
        title = findViewById(R.id.servicesTitle);

        species = getIntent().getStringExtra("species");
        if (species == null) species = "Cow";

        title.setText("Available Services for " + species + ":");

        List<ServiceItem> services = getServicesForSpecies(species);

        ServiceAdapter adapter = new ServiceAdapter(services, item -> {
            Intent intent = new Intent(ServiceActivity.this, AnimalDetailActivity.class);
            intent.putExtra("species", species);
            intent.putExtra("service", item.getName());
            startActivity(intent);
        });

        serviceRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        serviceRecyclerView.setAdapter(adapter);
    }

    private List<ServiceItem> getServicesForSpecies(String species) {
        List<ServiceItem> list = new ArrayList<>();
        if (species.equalsIgnoreCase("Cow")) {
            list.add(new ServiceItem("Vaccination", R.drawable.ic_vaccine));
            list.add(new ServiceItem("Milk yield monitoring", R.drawable.ic_milk));
            list.add(new ServiceItem("Hoof trimming", R.drawable.ic_trim));
        } else if (species.equalsIgnoreCase("Cat")) {
            //list.add(new ServiceItem("Neutering", R.drawable.ic_neuter));
            list.add(new ServiceItem("Diet consulting", R.drawable.ic_diet));
            list.add(new ServiceItem("Wellness check", R.drawable.ic_health_check));
        }
        return list;
    }
}

