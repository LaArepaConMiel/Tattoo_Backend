package com.example.tattoo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tattoo.models.client;
import com.example.tattoo.services.clientService;




@RestController
@RequestMapping("/client")
@CrossOrigin()
public class clientController {
    
    @Autowired
    clientService clientService;

    @GetMapping( path = "/{id}")
    public ArrayList<client> getClientsByUser (@PathVariable("id") String id){
        return this.clientService.getClientsbyUser(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
         clientService.removeById(id);      
    }

    @PostMapping()
    public client saveClientModel(@RequestBody client client){
        return this.clientService.saveClient(client);
    }
}
