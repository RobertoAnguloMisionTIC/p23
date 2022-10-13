package com.proyecto23.service;

import com.proyecto23.model.Client;
import com.proyecto23.model.CountClient;
import com.proyecto23.model.Reservation;
import com.proyecto23.model.Status;
import com.proyecto23.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Reservation> periodTimeReservationsReport(Date d1, Date d2) {
        if(d1.before(d2)){
            return reservationRepository.findAllByStartDateAfterAndStartDateBefore(d1, d2);
        }else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<CountClient> getTopClient() {
        List<CountClient> topClient = new ArrayList<>();
        List<Object[]> report = reservationRepository.reservationsCountByClient();
        for (int i = 0; i < report.size(); i++) {
            topClient.add(new CountClient((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return topClient;
    }

    @Override
    public Status reservationsCountByStatus() {
        List<Reservation> completed = reservationRepository.findAllByStatus("completed");
        List<Reservation> cancelled = reservationRepository.findAllByStatus("cancelled");
        return new Status(completed.size(),cancelled.size());
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
