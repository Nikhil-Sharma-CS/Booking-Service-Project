
# Booking-Service

The Booking Service keeps track of the seats available and allows user to book those seats by registering themselves first.

These seats have certain prices sets on them and the application reads the seat and seat pricing data from csv files provided.


## 🚀 About Me
*Hi, My name is Nikhil Sharma*,

I'm a full stack developer trainee at Geekster. I have knowledge of Java, OOPs, Maven, APIs, DSA, SpringBoot.


# Data Flow

## Controller Section
-   *This section contains a Booking Controller* :

* ### Booking Controller
    - This class contains various API endpoints that helps us to interact with the application resources.

    * @PostMapping("POST/user")
    * @GetMapping("GET/seats")
    * @GetMapping("GET/seat/{ID}")
    * @PostMapping("POST/booking")
    * @GetMapping("GET/bookings")

## Service Section

- *This section contains various classes each of which contains methods for buisness logics of the APIs*

* ### Booking Service Class

    * This class implements the logic of how bookings need to be done with provided data.

* ### Seat Service Class

    * This class implements various logics which are used to help implementing various logics like calculating seat price, getting list of seats based on class, etc.

* ### DataImportRunner

    * This class helps in reading the csv file from the resources and maps them to our entity tables according, so it basically initializes our database with the data on the csv files provided.

## Model Section

- *This section contains various models and a DTO which are used as tables to store data in our database.*
- ***Seat** and **BookingDetails** are some examples.*

## Repository Section

- *This section contains various Repositories each corresponding to our models.*

- *They all extend **JPA Repository**.*

## Database Design
- *Here we have used Relational Data to store data.*

- *We have used MYSQL and the database is hosted on a local server.*

## Summary

*This project demonstrates how a booking service application may work and how it can book seats for users.*

*This is coded in **Java** language and framework used is **SpringBoot** along with **Maven** as buildtype.*
## 🔗 Links
[![Github](https://img.shields.io/badge/Github-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Nikhil-Sharma-CS)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nikhil-sharma-cse)



