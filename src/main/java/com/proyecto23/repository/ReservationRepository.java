package com.proyecto23.repository;

import com.proyecto23.model.Message;
import com.proyecto23.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
}
