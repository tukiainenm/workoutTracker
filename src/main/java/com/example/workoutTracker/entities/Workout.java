package com.example.workoutTracker.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String date;

    @ManyToMany
    private Set<Exercise> exercises = new HashSet<>();

    public Workout(long id, String name, Set<Exercise> exercises, String date) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.exercises = exercises;
    }

    public Workout() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}
