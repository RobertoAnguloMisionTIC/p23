package com.proyecto23.repository;

import com.proyecto23.model.Message;
import com.proyecto23.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
    public List<Reservation> findAllByStatus (String status);

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore (Date d1, Date d2);

    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> reservationsCountByClient();
}
