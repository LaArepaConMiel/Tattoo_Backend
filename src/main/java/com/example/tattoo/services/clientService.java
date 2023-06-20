package com.example.tattoo.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tattoo.models.client;
import com.example.tattoo.models.user;
import com.example.tattoo.models.application;
import com.example.tattoo.repositories.clientRepository;
import com.example.tattoo.repositories.userRepository;
import com.example.tattoo.repositories.applicationRepository;

import java.util.Optional;

@Service
public class clientService {
    @Autowired
    clientRepository clientRepository;
    @Autowired
    userRepository userRepository;
    @Autowired
    applicationRepository applicationRepository;

    public ArrayList<client> getClients(){
        return (ArrayList<client>)clientRepository.findAll();
    }

    public Optional<client> getById(Integer id){
        return clientRepository.findById(id);   
    }

    public client saveClient(client cl){
        return clientRepository.save(cl);
    }
    public void removeClient(client cl){
        clientRepository.delete(cl);
    }

    public void removeById(Integer username){
        removeClient(clientRepository.findById(username).get());  
        
        

    }



    public ArrayList<client> getClientsbyUser(String userId){      
        //buscar aplicaciones por user          
        ArrayList<application> appsbyUser = applicationRepository.findByUser(new user(userId, "", "",null));
        ArrayList<client> listaClients = new ArrayList<client>();
        //sacarles el cliente
        for(application app: appsbyUser)listaClients.add(app.getClient());
        return listaClients;
    }
}