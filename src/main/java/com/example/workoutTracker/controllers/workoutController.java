package com.example.workoutTracker.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class workoutController {

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/tracker")
    public String track() {
        return "tracker";
    }

    @RequestMapping(value = "/calculator")
    public String calculate() {
        return "calculator";
    }
}

