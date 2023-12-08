package org.example.Booking.Service.Service;

import org.example.Booking.Service.Model.seat_price;
import org.example.Booking.Service.Repository.iSeatPriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SeatPriceService {

    @Autowired
    iSeatPriceRepo seatPriceRepo;

    public void importData(List<seat_price> data) {
        seatPriceRepo.saveAll(data);
    }

}
