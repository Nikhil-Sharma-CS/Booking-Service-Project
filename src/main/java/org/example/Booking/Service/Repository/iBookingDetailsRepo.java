package org.example.Booking.Service.Repository;

import org.example.Booking.Service.Model.booking_details;
import org.example.Booking.Service.Model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iBookingDetailsRepo extends JpaRepository<booking_details, Integer> {
    List<booking_details> findAllByuser(user user);
}
