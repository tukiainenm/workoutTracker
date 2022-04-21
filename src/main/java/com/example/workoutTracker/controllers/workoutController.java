package com.example.workoutTracker.controllers;


import com.example.workoutTracker.entities.Workout;
import com.example.workoutTracker.repositories.workoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.workoutTracker.entities.Exercise;
import com.example.workoutTracker.repositories.exerciseRepository;


@Controller
public class workoutController {

    @Autowired
    private exerciseRepository eRepository;

    @Autowired
    private workoutRepository wRepository;



    @RequestMapping(value = {"/","/home"})
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/calculator")
    public String calculate() {
        return "calculator";
    }


    @RequestMapping(value = "/workouts")
    public String workoutList(Model model) {
        model.addAttribute("workouts", wRepository.findAll());
        return "workouts";
    }

    @RequestMapping(value = "/add")
    public String addExercise(Model model) {
        model.addAttribute("workout", new Workout());
        model.addAttribute("exercises", eRepository.findAll());
        return "addworkout";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveExercise(@ModelAttribute Workout workout) {
        wRepository.save(workout);
        return "redirect:workouts";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") Long id, Model model) {
        wRepository.deleteById(id);
        return "redirect:../workouts";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editExercise(@PathVariable("id") long id, Model model) {
        model.addAttribute("exercise", wRepository.findById(id));
        return "redirect:/workouts";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveEditedWorkout(@ModelAttribute Workout workout) {
        wRepository.save(workout);
        return "redirect:../workouts";
    }
}


