package org.example.Booking.Service.Service;


import org.example.Booking.Service.Model.DTO.SeatDetails;
import org.example.Booking.Service.Model.seat;
import org.example.Booking.Service.Model.seat_price;
import org.example.Booking.Service.Repository.iSeatPriceRepo;
import org.example.Booking.Service.Repository.iSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    iSeatRepo seatRepo;

    @Autowired
    iSeatPriceRepo seatPriceRepo;

    //Get the list of all seats ordered by class and also the status of their booking as true or false

    public List<seat> getSeats() {
        return seatRepo.findAllByClass();
    }

    //Get the seat by id with its price

    public SeatDetails getSeat(Integer id) {
        seat seat = seatRepo.findById(id).orElse(null);

        if(seat == null)
            return new SeatDetails();

        Double price = getPriceByClass(seat.getSclass());

        return new SeatDetails(seat, price);
    }

    //This is for calculating the price of the seat based on class and booking percentage

    public Double getPriceByClass(String seat_class)
    {
        Integer percentage = getPercentageSeatByClass(seat_class);

        seat_price seatprice = seatPriceRepo.getBysclass(seat_class);

        if(percentage < 40)
        {
            if(seatprice.getMinprice() == 0)
                return seatprice.getNormalprice();
            else
                return seatprice.getMinprice();
        }
        else if(percentage <= 60)
        {
            if(seatprice.getNormalprice() == 0)
                return seatprice.getMaxprice();
            else
                return seatprice.getNormalprice();
        }
        else
        {
            if(seatprice.getMaxprice() == 0)
                return seatprice.getNormalprice();
            else
                return seatprice.getMaxprice();
        }
    }


    //Let's retrieve count of booked seats based on class
    public Integer getBookedSeatCountByClass(String seat_class)
    {

        return seatRepo.getBookedSeatCountByClass(seat_class);
    }

    //Now get the total seat count for the given class
    public Integer getTotalSeatCount(String seat_class)
    {

        return seatRepo.getTotalSeatCountByClass(seat_class);
    }

    //Now calculate percentage of seats booked

    public Integer getPercentageSeatByClass(String seat_class)
    {
        Integer totalSeats = getTotalSeatCount(seat_class);

        Integer totalAvailable = getBookedSeatCountByClass(seat_class);

        Integer percentage = (totalAvailable/totalSeats) * 100;

        return percentage;
    }

    //Check seat Availability
    public boolean checkAvailability(Integer id)
    {
        seat seat = seatRepo.findById(id).orElse(null);

        return seat != null && !seat.isIsbooked();
    }

    //Book seats i.e., set the isBooked value to true
    public void bookSeats(Integer id)
    {
        seat seat = seatRepo.findById(id).orElse(null);
        assert seat != null;

        seat.setIsbooked(true);
    }

    //For data importing purposes
    public void importData(List<seat> data) {
        seatRepo.saveAll(data);
    }
}
