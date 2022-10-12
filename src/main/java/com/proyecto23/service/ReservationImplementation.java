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
                Optional<Reservation> oldReservation = reservationRepository.findById(reservation.getIdReservation());
                Reservation editedReservation = oldReservation.get();
                if (reservation.getStartDate() != null){
                    editedReservation.setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null){
                    editedReservation.setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null){
                    editedReservation.setStatus(reservation.getStatus());
                }
                if (reservation.getBox() != null){
                    editedReservation.setBox(reservation.getBox());
                }
                if (reservation.getClient() != null){
                    editedReservation.setClient(reservation.getClient());
                }
                if (reservation.getScore() != null){
                    editedReservation.setScore(reservation.getScore());
                }
                return reservationRepository.save(editedReservation);
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
