package com.example.at_lab_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalCategoryAdapter extends BaseAdapter {

    private final Context context;

    private final String[] categories = {
            "Cow", "Goat", "Dog", "Chicken", "Sheep", "Horse", "Pig", "Cat"
    };

    private final int[] icons = {
            R.drawable.ic_cow,
            R.drawable.ic_goat,
            R.drawable.ic_dog,
            R.drawable.ic_chicken,
            R.drawable.ic_sheep,
            R.drawable.ic_horse,
            R.drawable.ic_pig,
            R.drawable.ic_cat
    };

    public AnimalCategoryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public Object getItem(int position) {
        return categories[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_animal_category, parent, false);
        }

        ImageView icon = convertView.findViewById(R.id.animalIcon);
        TextView label = convertView.findViewById(R.id.animalLabel);

        icon.setImageResource(icons[i]);
        label.setText(categories[i]);

        return convertView;
    }
}

