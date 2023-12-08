package org.example.Booking.Service.Service;

import org.example.Booking.Service.Model.user;
import org.example.Booking.Service.Repository.iUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    iUserRepo userRepo;


    //This is for registering the user

    public String registerUser(user user) {

        org.example.Booking.Service.Model.user user1 = userRepo.getByemail(user.getEmail());

        if(user1 != null)
            return "Email Id already registered";

        userRepo.save(user);

        return "User registered successfully";
    }


    //Find user by userName

    public user findUserByName(String name) {
        return userRepo.findUserByname(name);
    }

}
