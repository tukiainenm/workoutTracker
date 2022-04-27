package com.example.workoutTracker.web;


import com.example.workoutTracker.model.Exercise;
import com.example.workoutTracker.model.Workout;
import com.example.workoutTracker.model.workoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.workoutTracker.model.exerciseRepository;

import java.util.List;


@Controller
public class workoutController {

    @Autowired
    private exerciseRepository eRepository;

    @Autowired
    private workoutRepository wRepository;

    //Method to display the login page
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    //Method to display the homepage
    @RequestMapping(value = {"/","/home"})
    public String home() {
        return "home";
    }

    //Method to display the calculator site
    @RequestMapping(value = "/calculator")
    public String calculate() {
        return "calculator";
    }


    //Method to display all workouts
    @RequestMapping(value = "/workouts")
    public String workoutList(Model model) {
        model.addAttribute("workouts", wRepository.findAll());
        return "workouts";
    }

    @RequestMapping(value = "/add")
    public String addWorkout(Model model) {
        model.addAttribute("workout", new Workout());
        model.addAttribute("exercises", eRepository.findAll());
        return "addworkout";
    }

    //Method to save a workout
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveExercise(@ModelAttribute Workout workout, BindingResult bindingResult) {
        wRepository.save(workout);
        return "redirect:workouts";
    }

    //Method to add an exercise
    @RequestMapping(value = "/addexercise")
    public String addExercise(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "addexercise";
    }

    //Method to save an exercise
    @RequestMapping(value = "/saveexercise", method = RequestMethod.POST)
    public String saveExercise(@ModelAttribute("exercise") Exercise exercise, BindingResult bindingResult) {
        eRepository.save(exercise);
        return "redirect:add";
    }

    //Method to delete a workout
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") Long id, Model model) {
        wRepository.deleteById(id);
        return "redirect:../workouts";
    }

    //Method to delete an exercise
    @RequestMapping(value = "/deleteexercise/{id}", method = RequestMethod.GET)
    public String deleteExercise(@PathVariable("id") Long id, Model model) {
        eRepository.deleteById(id);
        return "redirect:../add";
    }

    //Rest method to get all exercises
    @RequestMapping(value = "/allexercises", method = RequestMethod.GET)
    public @ResponseBody
    List<Exercise> exerciseListRest() {
        return (List<Exercise>) eRepository.findAll();
    }

    //Rest method to get all workouts
    @RequestMapping(value = "/allworkouts", method = RequestMethod.GET)
    public @ResponseBody
    List<Workout> workoutListRest() {
        return (List<Workout>) wRepository.findAll();
    }
}



