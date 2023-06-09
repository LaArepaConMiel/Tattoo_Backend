package com.example.tattoo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tattoo.models.application;

@Repository
public interface applicationRepository extends CrudRepository<application, Integer> {
}