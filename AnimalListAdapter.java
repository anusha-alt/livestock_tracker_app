package com.example.at_lab_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.at_lab_project.Animal;
import com.example.at_lab_project.AnimalListAdapter;
public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {

    public interface OnAnimalClickListener {
        void onAnimalClick(Animal animal);
    }

    private List<Animal> animalList;
    private OnAnimalClickListener listener;

    public AnimalListAdapter(List<Animal> animalList, OnAnimalClickListener listener) {
        this.animalList = animalList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.nameText.setText(animal.getName());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAnimalClick(animal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;

        ViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.animalName);
        }
    }
}

