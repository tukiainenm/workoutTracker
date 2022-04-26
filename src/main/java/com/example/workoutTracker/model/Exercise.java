package com.example.workoutTracker.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String setsreps;
    private int weight;

    @ManyToMany
    private Set<Workout> workouts = new HashSet<>();

    public Exercise() {
    }

    public Exercise(String name, String setsreps) {
        this.name = name;
        this.setsreps = setsreps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSetsreps() {
        return setsreps;
    }

    public void setSetsreps(String setsreps) {
        this.setsreps = setsreps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", setsreps='" + setsreps + '\'' +
                '}';
    }
}



