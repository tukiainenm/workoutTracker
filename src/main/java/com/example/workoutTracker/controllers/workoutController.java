package com.example.workoutTracker.controllers;


import com.example.workoutTracker.repositories.categoryRepository;
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
    private categoryRepository cRepository;

    @RequestMapping(value = {"/","/home"})
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/calculator")
    public String calculate() {
        return "calculator";
    }


    @RequestMapping(value = "/tracker")
    public String exerciseList(Model model) {
        model.addAttribute("exercises", eRepository.findAll());
        return "tracker";
    }

    @RequestMapping(value = "/add")
    public String addExercise(Model model) {
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("categories", cRepository.findAll());
        return "redirect:tracker";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveExercise(@ModelAttribute Exercise exercise) {
        eRepository.save(exercise);
        return "redirect:/tracker";
    }
}


