package com.example.tattoo.services;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tattoo.models.schedule;
import com.example.tattoo.models.user;
import com.example.tattoo.models.application;
import com.example.tattoo.repositories.scheduleRepository;

//
import com.example.tattoo.repositories.userRepository;
import com.example.tattoo.repositories.applicationRepository;

import java.util.Optional;

@Service
public class scheduleService {
    @Autowired
    scheduleRepository scheduleRepository;
    @Autowired
    userRepository userRepository;
    @Autowired
    applicationRepository applicationRepository;

    public ArrayList<schedule> getSchedules(){
        return (ArrayList<schedule>)scheduleRepository.findAll();
    }

    public Optional<schedule> getById(Integer id){
        return scheduleRepository.findById(id);   
    }

    public schedule saveSchedule(schedule cl){
        return scheduleRepository.save(cl);
    }
    public void removeSchedule(schedule cl){
        scheduleRepository.delete(cl);
    }


    


    public ArrayList<schedule> getSchedulesbyUser(String userId){      
        //buscar aplicaciones por user          
        ArrayList<application> appsbyUser = applicationRepository.findByUser(new user(userId, "", "",null)).get();
        ArrayList<schedule> listaSchedules = new ArrayList<schedule>();

        //sacarles el schedule

       for(application app: appsbyUser)listaSchedules.addAll(scheduleRepository.findByApplication(app));
       

        return listaSchedules;
    }
}