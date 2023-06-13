package com.example.tattoo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tattoo.models.client;

@Repository
public interface clientRepository extends CrudRepository<client, Integer> {
}