package com.farias.blog.controllers;

import com.farias.blog.models.User;
import com.farias.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class ProcessingController {

    private UserService userService;

    @Autowired
    public ProcessingController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/process-new-user")
    public String createNewUser(@RequestParam("name") String name,
                                @RequestParam("dob")String dob,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password){

        User user = new User(name, dob, email, password);
        userService.addNewUser(user);

        return "redirect:/login";
    }

    @GetMapping("/process-sign-in")
    public String signIn(@RequestParam("email") String email,
                         @RequestParam("password") String password) {

        if(userService.checkEmailPassword(email, password)){
            return "redirect:/profile";
        }
        return "redirect:/login";

    }
}
