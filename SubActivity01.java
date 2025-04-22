// SubActivity01.java
package com.example.at_lab_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.BaseAdapter;
import com.example.at_lab_project.AnimalCategoryAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity01 extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub01);

        gridView = findViewById(R.id.gridView);
        AnimalCategoryAdapter adapter = new AnimalCategoryAdapter(this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = (String) adapter.getItem(position);
                Toast.makeText(SubActivity01.this, "Selected: " + category, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SubActivity01.this, ServiceActivity.class);
                intent.putExtra("category", category);
                startActivity(intent);
            }
        });
    }
}



