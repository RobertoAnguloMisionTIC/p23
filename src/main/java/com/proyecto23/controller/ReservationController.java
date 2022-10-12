package com.proyecto23.controller;

import com.proyecto23.model.Message;
import com.proyecto23.model.Reservation;
import com.proyecto23.service.MessageImplementation;
import com.proyecto23.service.ReservationImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationImplementation reservationImplementation;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable ("id") Integer id){
        reservationImplementation.delete(id);
    }
}
