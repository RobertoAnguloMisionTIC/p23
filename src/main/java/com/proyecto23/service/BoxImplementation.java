package com.proyecto23.service;

import com.proyecto23.model.Box;
import com.proyecto23.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoxImplementation implements BoxService{
    @Autowired
    private BoxRepository boxRepository;

    @Override
    @Transactional
    public void create(Box box) {
        if(box.getId() != null){
            if(boxRepository.existsById(box.getId())){
                return;
            }else{
                boxRepository.save(box);
                return;
            }
        }else {
            boxRepository.save(box);
            return;
        }
    }

    @Override
    public List<Box> boxes() {
        return (List<Box>) boxRepository.findAll();
    }

    @Override
//    @Transactional
    public void update(Box box) {
        if (boxRepository.existsById(box.getId())){
            boxRepository.save(box);
            return;
        }else
            return;
    }

    @Override
//    @Transactional
    public void delete(Integer id) {
        if(boxRepository.existsById(id)){
            boxRepository.deleteById(id);
            return;
        }else
            return;
    }
}
