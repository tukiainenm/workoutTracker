package com.example.workoutTracker.web;

import com.example.workoutTracker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class userController {

    @Autowired
    private userRepository uRepository;

    @RequestMapping(value = "/signup")
    public String addUser(Model model) {
        model.addAttribute("signUpForm", new signUpForm());
        return "signup";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signUpForm") signUpForm signUpForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (signUpForm.getPassword().equals(signUpForm.getPasswordCheck())) {
                String pwd = signUpForm.getPassword();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashPwd = passwordEncoder.encode(pwd);

                User newUser = new User();
                newUser.setPasswordHash(hashPwd);
                newUser.setUserName(signUpForm.getUserName());
                newUser.setRole("USER");
                if (uRepository.findByUserName(signUpForm.getUserName()) == null) {
                    uRepository.save(newUser);
                } else {
                    bindingResult.rejectValue("userName", "err.userName", "Username already exists");
                    return "signup";
                }
            } else {
                bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
                return "signup";
            }
        } else {
            return "signup";
        }
        return "redirect:/login";
    }
}