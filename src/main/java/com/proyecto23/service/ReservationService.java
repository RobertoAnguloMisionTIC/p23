package com.proyecto23.service;

import com.proyecto23.model.CountClient;
import com.proyecto23.model.Message;
import com.proyecto23.model.Reservation;
import com.proyecto23.model.Status;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    public Reservation create(Reservation reservation);
    public Optional<Reservation> getReservation(Integer id);
    public List<Reservation> reservations();
    public Reservation update(Reservation reservation);
    public List<Reservation> periodTimeReservationsReport(Date d1, Date d2);
    public List<CountClient> getTopClient();
    public Status reservationsCountByStatus();
    public boolean delete(Integer id);
}
