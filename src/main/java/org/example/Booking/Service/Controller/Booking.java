package org.example.Booking.Service.Controller;

import org.example.Booking.Service.Model.booking_details;
import org.example.Booking.Service.Model.DTO.SeatDetails;
import org.example.Booking.Service.Model.seat;
import org.example.Booking.Service.Model.user;
import org.example.Booking.Service.Service.BookingService;
import org.example.Booking.Service.Service.SeatService;
import org.example.Booking.Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Booking {

    @Autowired
    BookingService bookingService;

    @Autowired
    SeatService seatService;

    @Autowired
    UserService userService;

    //For registering as a user
    @PostMapping("POST/user")
    public String registerUser(@RequestBody user user)
    {
        return userService.registerUser(user);
    }

    //Get all seats
    @GetMapping("GET/seats")
    public List<seat> getSeats()
    {
        System.out.println("Working Directory: " + System.getProperty("user.dir"));

        return  seatService.getSeats();
    }

    //Get seat details with price by providing id

    @GetMapping("GET/seat/{ID}")
    public SeatDetails getSeatDetail(@PathVariable Integer ID)
    {
        return seatService.getSeat(ID);
    }

    //Book list of seats by providing name and phoneNumber of the user

    @PostMapping("POST/booking")
    public String bookingSeats(@RequestBody Integer [] seatId, String phoneNumber, String name)
    {
       return bookingService.bookingSeats(seatId, phoneNumber, name);
    }

    //Get bookings made by user

    @GetMapping("GET/bookings")
    public List<booking_details> bookings(@RequestParam String userEmail, @RequestParam String phoneNumber)
    {
        return bookingService.bookings(userEmail, phoneNumber);
    }
}
