package com.proyecto23.service;

import com.proyecto23.model.Box;

import java.util.List;

public interface BoxService {
    public void create(Box box);
    public List<Box> boxes();
    public void update(Box box);
    public void delete(Integer id);
}
