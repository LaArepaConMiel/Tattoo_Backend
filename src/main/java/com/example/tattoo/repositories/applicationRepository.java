package com.example.tattoo.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tattoo.models.application;
import com.example.tattoo.models.user;

@Repository
public interface applicationRepository extends CrudRepository<application, Integer> {
    public abstract Optional<ArrayList<application>> findByUser(user user);
        
}