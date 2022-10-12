package com.proyecto23.service;

import com.proyecto23.model.Message;
import com.proyecto23.model.Reservation;
import com.proyecto23.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationImplementation implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> reservationNew = getReservation(reservation.getIdReservation());
            if (reservationNew.isEmpty()){
                return reservationRepository.save(reservation);
            }else {
                return reservation;
            }
        }
    }

    @Override
    public Optional<Reservation> getReservation(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> reservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation update(Reservation reservation) {
        if (reservation != null && reservation.getIdReservation() != null){
            if (reservationRepository.existsById(reservation.getIdReservation())){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }else {
            return reservation;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if(reservationRepository.existsById(id)){
            reservationRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
