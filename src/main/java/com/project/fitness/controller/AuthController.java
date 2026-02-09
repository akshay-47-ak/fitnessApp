package com.project.fitness.controller;

import com.project.fitness.model.User;
import com.project.fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor  // used to Create the final Contructor
public class AuthController {


    private final UserService userService;



    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){

        User user1 = userService.register(user);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

}
