package com.example.mintic.boat.controller;

import java.util.List;
import java.util.Optional;

import com.example.mintic.boat.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.mintic.boat.model.Message;
import com.example.mintic.boat.service.ServiceMessage;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ControllerMessage {
    
    @Autowired
    private ServiceMessage serviceMessage;

    
    @GetMapping("/all")
    public List<Message> getAll(){
        return serviceMessage.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return serviceMessage.getMessage(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return serviceMessage.save(message);
    }

    //Metodo para eliminar (Capa de controlador)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int id){
        return serviceMessage.delete(id);
    }

    //Metodo para actualizar (Capa de controlador)
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return serviceMessage.update(message);
    }

}
