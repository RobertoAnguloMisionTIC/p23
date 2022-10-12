package com.proyecto23.service;

import com.proyecto23.model.Box;
import com.proyecto23.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BoxImplementation implements BoxService{
    @Autowired
    private BoxRepository boxRepository;

    @Override
    @Transactional
    public Box create(Box box) {
        if (box.getId() == null){
            return boxRepository.save(box);
        }else{
            Optional<Box> boxNew = getBox(box.getId());
            if (boxNew.isEmpty()){
                return boxRepository.save(box);
            }else {
                return box;
            }
        }
    }

    @Override
    public Optional<Box> getBox(Integer id) {
        return boxRepository.findById(id);
    }

    @Override
    public List<Box> boxes() {
        return (List<Box>) boxRepository.findAll();
    }

    @Override
    public Box update(Box box) {
        if (box != null && box.getId() != null){
            if (boxRepository.existsById(box.getId())){
                Optional<Box> oldBox = boxRepository.findById(box.getId());
                Box editedBox = oldBox.get();
                if (box.getName() != null){
                    editedBox.setName(box.getName());
                }
                if (box.getLocation() != null){
                    editedBox.setLocation(box.getLocation());
                }
                if (box.getCapacity() != 0){
                    editedBox.setCapacity(box.getCapacity());
                }
                if (box.getDescription() != null){
                    editedBox.setDescription(box.getDescription());
                }
                if (box.getCategory() != null){
                    editedBox.setCategory(box.getCategory());
                }
                if (box.getMessages() != null){
                    editedBox.setMessages(box.getMessages());
                }
                if (box.getReservations() != null){
                    editedBox.setReservations(box.getReservations());
                }
                return boxRepository.save(editedBox);
            }else{
                return box;
            }
        }else {
            return box;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if(boxRepository.existsById(id)){
            boxRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
