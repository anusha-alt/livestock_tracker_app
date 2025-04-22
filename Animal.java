package com.example.at_lab_project;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Animal {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private String name;
    private String species;
    private int age;

    // 👉 Constructor
    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    // 👉 Getters
    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    // Optional: Setters (if you need to update animal details later)
    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

