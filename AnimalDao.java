package com.example.at_lab_project;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDao {

    // Insert a single animal
    @Insert
    void insert(Animal animal);

    // Get all animals
    @Query("SELECT * FROM Animal")
    List<Animal> getAll();

    // Get animals filtered by species
    @Query("SELECT * FROM Animal WHERE species = :species")
    List<Animal> getBySpecies(String species);

    // Get animal by ID (for detail page)
    @Query("SELECT * FROM Animal WHERE id = :id")
    Animal getById(int id);
    @Query("DELETE FROM Animal")
    void deleteAll();

}
