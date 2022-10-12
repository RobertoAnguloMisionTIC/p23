package com.proyecto23.service;

import com.proyecto23.model.Box;

import java.util.List;
import java.util.Optional;

public interface BoxService {
    public Box create(Box box);
    public Optional<Box> getBox(Integer id);
    public List<Box> boxes();
    public Box update(Box box);
    public boolean delete(Integer id);
}
