package com.example.mintic.boat.controller;

import java.util.List;
import java.util.Optional;

import com.example.mintic.boat.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.mintic.boat.model.Client;
import com.example.mintic.boat.service.ServiceClient;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ControllerClient {
    
    @Autowired
    private ServiceClient serviceClient;

    
    @GetMapping("/all")
    public List<Client> getAll(){
        return serviceClient.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id) {
        return serviceClient.getClient(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return serviceClient.save(client);
    }

    //Metodo para eliminar (Capa de controlador)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int id){
        return serviceClient.delete(id);
    }

    //Metodo para actualizar (Capa de controlador)
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return serviceClient.update(client);
    }

}
