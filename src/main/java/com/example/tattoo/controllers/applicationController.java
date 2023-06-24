package com.example.tattoo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tattoo.models.application;
import com.example.tattoo.models.user;
import com.example.tattoo.services.applicationService;

@RestController
@RequestMapping("/application")
@CrossOrigin
public class applicationController {
    @Autowired
    applicationService applicationService;

    @GetMapping()
    public ArrayList<application> getApplications(){
        return applicationService.getApplications();
    }

    @PostMapping()
    public application saveApplicationModel(@RequestBody application application){
        return this.applicationService.saveApplication(application);
    }

    @GetMapping(path="/user/{username}")
    public ArrayList<application> getApplicationsByUser(@PathVariable("username") String username){
        return this.applicationService.getApplicationsByUser(new user(username)).get();
    }

    @PutMapping
    public application updateApplicationModel(@RequestBody application application){
        return this.applicationService.updateApplication(application);
    }

    @GetMapping( path = "/{id}")
    public Optional<application> getApplicationByUsername(@PathVariable("id") int id){
        return this.applicationService.getById(id);
    }
}