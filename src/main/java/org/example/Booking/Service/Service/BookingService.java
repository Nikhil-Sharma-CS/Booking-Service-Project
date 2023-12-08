package org.example.Booking.Service.Service;

import org.example.Booking.Service.Model.booking_details;
import org.example.Booking.Service.Model.seat;
import org.example.Booking.Service.Model.user;
import org.example.Booking.Service.Repository.iBookingDetailsRepo;
import org.example.Booking.Service.Repository.iSeatRepo;
import org.example.Booking.Service.Repository.iUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    UserService userService;

    @Autowired
    SeatService seatService;

    @Autowired
    iSeatRepo seatRepo;

    @Autowired
    iBookingDetailsRepo bookingDetailsRepo;

    @Autowired
    iUserRepo userRepo;

    public String bookingSeats(Integer[] seatId, String phoneNumber, String name) {
        user user = userService.findUserByName(name);

        if(user == null)
            return "User does not exists";

        //Now check if seats to be booked are available or not

        for(Integer id : seatId)
        {
            if(!seatService.checkAvailability(id))
            {
               return "Seat number " + id + " is already booked";
            }
        }

        //Now up until here we know that all seats are available and user is also valid, so we will book seats

        booking_details bookingdetails = new booking_details();

        bookingdetails.setUser(user);

        //Now set the price of booking
        Double TotalPrice= 0.0;

        //Now get the prices for all classes
        for(Integer id : seatId)
        {
            seat seat = seatRepo.findById(id).orElse(null);

            assert seat != null;
            Double price = seatService.getPriceByClass(seat.getSclass());
            TotalPrice += price;

        }

        //Now set the price
        bookingdetails.setPrice(TotalPrice);

        //Now book the seats
        for(Integer id : seatId)
        {
            seatService.bookSeats(id);
        }

        //Now our seats are booked
        bookingdetails.setSeats(seatId);


        bookingDetailsRepo.save(bookingdetails);

        return "Your Booking Id is "+ bookingdetails.getId()  + " and total price is " + TotalPrice;
    }

    public List<booking_details> bookings(String userEmail, String phoneNumber) {
        //First we need to extract user
        user user =  userRepo.getByemail(userEmail);

        if(user == null)
        {
            user = userRepo.getByphonenumber(phoneNumber);
            if(user == null)
                return null;
        }

        return bookingDetailsRepo.findAllByuser(user);
    }
}
