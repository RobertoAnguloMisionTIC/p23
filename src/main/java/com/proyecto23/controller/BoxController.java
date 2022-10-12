package com.proyecto23.controller;

import com.proyecto23.model.Box;
import com.proyecto23.service.BoxImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Box")
@CrossOrigin(origins = "*")
public class BoxController {
    @Autowired
    private BoxImplementation boxImplementation;

    @PostMapping("/save")
    public void createBox(@RequestBody Box box){
        boxImplementation.create(box);
    }

    @GetMapping("/all")
    public List<Box> getBoxes(){
        return boxImplementation.boxes();
    }

    @PutMapping("/update")
    public void updateBox(@RequestBody Box box){
        boxImplementation.update(box);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBox(@PathVariable ("id") Integer id){
        boxImplementation.delete(id);
    }
}
