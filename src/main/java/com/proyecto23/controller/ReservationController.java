package com.proyecto23.controller;

import com.proyecto23.model.Reservation;
import com.proyecto23.model.CountClient;
import com.proyecto23.model.Status;
import com.proyecto23.service.ReservationImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationImplementation reservationImplementation;
    private CountClient countClient;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservation(@RequestBody Reservation reservation){
        reservationImplementation.create(reservation);
    }

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationImplementation.reservations();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateReservation(@RequestBody Reservation reservation){
        reservationImplementation.update(reservation);
    }

    @GetMapping("/report-dates/{d1}/{d2}")
    public List<Reservation> getReservationsReportDates(@PathVariable("d1") Date d1, @PathVariable("d2") Date d2){
        return reservationImplementation.periodTimeReservationsReport(d1,d2);
    }
    @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return reservationImplementation.getTopClient();
    }

    @GetMapping("/report-status")
    public Status getReservationsStatusReport(){
        return reservationImplementation.reservationsCountByStatus();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable ("id") Integer id){
        reservationImplementation.delete(id);
    }
}
