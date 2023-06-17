package com.example.tattoo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.tattoo.models.user;

@Repository
public interface userRepository extends CrudRepository<user, String>{
    
}