package com.example.mintic.boat.controller;

import java.util.List;
import java.util.Optional;

import com.example.mintic.boat.model.Boat;
import com.example.mintic.boat.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.mintic.boat.service.ServiceBoat;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ControllerBoat {

    @Autowired
    private ServiceBoat serviceBoat;
    

    @GetMapping("/all")
    public List<Boat> getAll(){
        return serviceBoat.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable("id") int id) {
        return serviceBoat.getBoat(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat) {
        return serviceBoat.save(boat);
    }

    //Metodo para eliminar (Capa de controlador)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int id){
        return serviceBoat.delete(id);
    }

    //Metodo para actualizar (Capa de controlador)
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat update(@RequestBody Boat boat) {
        return serviceBoat.update(boat);

    }

}
