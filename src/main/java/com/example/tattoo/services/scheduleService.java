package com.example.tattoo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tattoo.models.schedule;
import com.example.tattoo.models.application;
import com.example.tattoo.repositories.scheduleRepository;

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

    public schedule saveSchedule(schedule session){
        Integer idApp = session.getApplication().getId();
        session.setApplication(null);
        schedule newSesh = scheduleRepository.save(session);
        newSesh.setApplication(new application(idApp));
        newSesh = updateSchedule(session);
        return newSesh;
    }

    public schedule updateSchedule(schedule session){
        Optional<schedule> newSesh = getById(session.getId());
        if(newSesh.isPresent()){
            application app = applicationRepository.findById(session.getApplication().getId()).get();
            newSesh.get().setApplication(app);
            scheduleRepository.save(newSesh.get());
            return newSesh.get();
        }
        return null;
    }

    public void removeSchedule(schedule cl){
        scheduleRepository.delete(cl);
    }

    public ArrayList<schedule> getSchedulesbyUser(String userId){      
        //buscar aplicaciones por user          
        //ArrayList<application> appsbyUser = applicationRepository.findByUser(new user(userId, "", "",null)).get();
        ArrayList<schedule> schedules = getSchedules();
        ArrayList<schedule> list = new ArrayList<schedule>();

        for (schedule obj : schedules) {
            if (obj.getApplication().getUser().getUsername().equals(userId)){
                list.add(obj);
            }
        }
        return list;
    }
}