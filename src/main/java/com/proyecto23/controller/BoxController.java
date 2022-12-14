package com.proyecto23.controller;

import com.proyecto23.model.Box;
import com.proyecto23.service.BoxImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Box")
@CrossOrigin(origins = "*")
public class BoxController {
    @Autowired
    private BoxImplementation boxImplementation;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBox(@RequestBody Box box){
        boxImplementation.create(box);
    }

    @GetMapping("/all")
    public List<Box> getBoxes(){
        return boxImplementation.boxes();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Box updateBox(@RequestBody Box box){
        return boxImplementation.update(box);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBox(@PathVariable ("id") Integer id){
        boxImplementation.delete(id);
    }
}
