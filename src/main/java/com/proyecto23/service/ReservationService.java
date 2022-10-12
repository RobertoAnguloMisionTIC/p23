package com.proyecto23.service;

import com.proyecto23.model.Message;
import com.proyecto23.model.Reservation;

import java.util.List;

public interface ReservationService {
    public void create(Reservation reservation);
    public List<Reservation> reservations();
    public void update(Reservation reservation);
    public void delete(Integer id);
}
