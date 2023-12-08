package org.example.Booking.Service.Repository;

import org.example.Booking.Service.Model.seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iSeatRepo extends JpaRepository<seat, Integer> {

    @Query(value = "SELECT * FROM seat ORDER BY sclass", nativeQuery = true)
    List<seat> findAllByClass();

    @Query(value = "Select Count(*) From seat Where sclass = :seatClass AND isbooked = 1", nativeQuery = true)
    Integer getBookedSeatCountByClass(String seatClass);

    @Query(value = "Select Count(*) From seat Where sclass = :seatClass", nativeQuery = true)
    Integer getTotalSeatCountByClass(String seatClass);
}
