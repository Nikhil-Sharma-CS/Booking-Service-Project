package org.example.Booking.Service.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class booking_details {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double price;

    private Integer[] seats;


    @ManyToOne
    @JoinColumn(name = "user_fk_id")
    @JsonIgnore
    org.example.Booking.Service.Model.user user;
}
