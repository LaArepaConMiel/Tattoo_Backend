package com.example.tattoo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.tattoo.repositories.applicationRepository;
import com.example.tattoo.repositories.userRepository;
import com.example.tattoo.models.application;
import com.example.tattoo.models.user;

@Service
public class applicationService {
    @Autowired
    applicationRepository applicationRepository;
    @Autowired
    userRepository userRepository;

    public ArrayList<application> getApplications(){
        return (ArrayList<application>)applicationRepository.findAll();
    }

    public Optional<application> getById(Integer id){
        return applicationRepository.findById(id);
    }

    public Optional<ArrayList<application>> getApplicationsByUser(user user){
        return applicationRepository.findByUser(user);
    }

    public application saveApplication(application application){
        String username = application.getUser().getUsername();
        application.setUser(null);
        application obj = applicationRepository.save(application);
        obj.setUser(new user(username, null, null, null));
        obj = updateApplication(obj);
        return obj;
    }

    public application updateApplication(application application){
        Optional<application> updateApplication = getById(application.getId());
        if(updateApplication.isPresent()){
            user user = userRepository.findById(application.getUser().getUsername()).get();
            updateApplication.get().setUser(user);
            applicationRepository.save(updateApplication.get());
            return updateApplication.get();
        }else{
            return null;
        }
    }
}