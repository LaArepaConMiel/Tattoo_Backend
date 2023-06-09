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
        ArrayList<user> users = this.userService.getByPassword(user.getPassword());
        if(users.size() == 0) return null;
        for (user obj : users) {
            if(obj.getPassword().equals(user.getPassword())) return obj;
        }
        return null;
    }

    @GetMapping( path = "/{id}/{pas}")
    public user getULogin(@PathVariable("id") String username, @PathVariable("pas") String password){
        ArrayList<user> users = this.userService.getByPassword(password);
        if(users.size() == 0) return null;
        for (user obj : users) {
            if(obj.getPassword().equals(password)) return obj;
        }
        return null;
    }

}