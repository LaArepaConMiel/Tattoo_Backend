package com.example.tattoo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tattoo.models.user;
import com.example.tattoo.repositories.userRepository;

@Service
public class userService {
    @Autowired
    userRepository userRepository;

    public ArrayList<user> getUsers(){
        return (ArrayList<user>)userRepository.findAll();
    }

    public user saveUser(user user){
        return userRepository.save(user);
    }

    public Optional<user> getById(String username){
        return userRepository.findById(username);
    }

    public ArrayList<user> getByPassword(String password){
        return userRepository.findByPassword(password);
    }
}