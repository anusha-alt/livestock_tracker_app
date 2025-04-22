package com.example.at_lab_project;

import android.os.Bundle;
import android.widget.TextView;
import android.os.StrictMode;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FinalPageActivity extends AppCompatActivity {

    private TextView predictionText;
    private final String COLAB_URL = "https://cc66fa0894fa1773a7.gradio.live"; // Replace this with your actual URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fp);

        predictionText = findViewById(R.id.predictionTextView);

        String name = getIntent().getStringExtra("animalName");
        String species = getIntent().getStringExtra("animalSpecies");

        predictionText.setText("Fetching predictions for " + name + " (" + species + ")...");

        // For simplicity: allow network operation on main thread (not best practice for production)
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            String requestUrl = COLAB_URL + "?name=" + name + "&species=" + species;
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line).append("\n");
            }
            in.close();

            predictionText.setText(result.toString());
        } catch (Exception e) {
            predictionText.setText("Failed to get prediction.\n\n" + e.getMessage());
        }
    }
}

