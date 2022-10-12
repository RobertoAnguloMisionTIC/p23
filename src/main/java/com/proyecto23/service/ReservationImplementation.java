package com.proyecto23.service;

import com.proyecto23.model.Reservation;
import com.proyecto23.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReservationImplementation implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    @Transactional
    public void create(Reservation reservation) {
        if(reservation.getIdReservation() != null){
            if(reservationRepository.existsById(reservation.getIdReservation())){
                return;
            }else{
                reservationRepository.save(reservation);
                return;
            }
        }else {
            reservationRepository.save(reservation);
            return;
        }
    }

    @Override
    public List<Reservation> reservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Reservation reservation) {
        if (reservationRepository.existsById(reservation.getIdReservation())){
            reservationRepository.save(reservation);
            return;
        }else
            return;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if(reservationRepository.existsById(id)){
            reservationRepository.deleteById(id);
            return;
        }else
            return;
    }
}
