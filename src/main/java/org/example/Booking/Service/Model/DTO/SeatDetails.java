package org.example.Booking.Service.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDetails {
    private org.example.Booking.Service.Model.seat seat;
    private Double seatPrice;

}
