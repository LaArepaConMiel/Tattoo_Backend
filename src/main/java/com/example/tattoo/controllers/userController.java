package com.example.tattoo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tattoo.models.user;
import com.example.tattoo.services.userService;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    userService userService;

    @GetMapping()
    public ArrayList<user> getUsers(){
        return userService.getUsers();
    }

    @PostMapping()
    public user saveUserModel(@RequestBody user user){
        return this.userService.saveUser(user);
    }

    @GetMapping( path = "/{id}")
    public Optional<user> getUserByUsername(@PathVariable("id") String username){
        return this.userService.getById(username);
    }

    @PostMapping( path = "/login")
    public user getULogin(@RequestBody user user){
        Optional<user> obj = this.userService.getById(user.getUsername());
        if(obj.isPresent()){
            if(obj.get().getPassword().equals(user.getPassword())) return obj.get();
        }
        return null;
    }
}