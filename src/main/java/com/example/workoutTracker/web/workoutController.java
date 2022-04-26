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


    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

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
    public String addWorkout(Model model) {
        model.addAttribute("workout", new Workout());
        model.addAttribute("exercises", eRepository.findAll());
        return "addworkout";
    }

    @RequestMapping(value = "/addexercise")
    public String addExercise(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "addexercise";
    }

    @RequestMapping(value = "/saveexercise", method = RequestMethod.POST)
    public String saveExercise(@ModelAttribute("exercise") Exercise exercise, BindingResult bindingResult) {
        eRepository.save(exercise);
        return "redirect:add";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveExercise(@ModelAttribute Workout workout, BindingResult bindingResult) {
        wRepository.save(workout);
        return "redirect:workouts";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") Long id, Model model) {
        wRepository.deleteById(id);
        return "redirect:../workouts";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody
    List<Exercise> BookListRest() {
        return (List<Exercise>) eRepository.findAll();
    }
}


