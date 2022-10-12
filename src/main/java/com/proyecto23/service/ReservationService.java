package com.proyecto23.service;

import com.proyecto23.model.Message;
import com.proyecto23.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    public Reservation create(Reservation reservation);
    public Optional<Reservation> getReservation(Integer id);
    public List<Reservation> reservations();
    public Reservation update(Reservation reservation);
    public boolean delete(Integer id);
}
