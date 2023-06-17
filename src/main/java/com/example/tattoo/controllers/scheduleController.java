package com.example.tattoo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tattoo.models.schedule;
import com.example.tattoo.services.scheduleService;

@RestController
@RequestMapping("/schedule")
@CrossOrigin
public class scheduleController {
    @Autowired
    scheduleService scheduleService;

    @GetMapping( path = "/{id}")
    public ArrayList<schedule> getSchedulesByUser(@PathVariable("id") String id){
        return this.scheduleService.getSchedulesbyUser(id);
    }

    @PostMapping()
    public schedule savescheduleModel(@RequestBody schedule schedule){
        return this.scheduleService.saveSchedule(schedule);
    }
}
