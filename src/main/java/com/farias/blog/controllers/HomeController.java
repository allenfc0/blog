package com.farias.blog.controllers;

import com.farias.blog.models.User;
import com.farias.blog.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.PostLoad;
import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@Slf4j
@Primary
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService){
        this.userService = userService;
    }

    @GetMapping({"/", "/index"})
    public String getHome() {

        return "index";
    }

    @GetMapping({"/login"})
    public String getLogin() {

        return "login";
    }

    @GetMapping({"/signup"})
    public String getSignUp() {

        return "signup";
    }

    @GetMapping({"/profile"})
    public String getProfile() {

        return "profile";
    }



    @PostConstruct
    public void testing() {
        addUser("Allen", "", "allen@email.com", "123");
        addUser("", "", "", "");
        addUser("admin","", "test", "pass");
        userService.deleteUserById(2);

        for(User u : userService.getUsers()){
            System.out.println(u);
        }
    }

    public void addUser(String name, String dob, String email, String password) {
        User u = new User(name, dob, email, password);
        userService.addNewUser(u);
    }

}
