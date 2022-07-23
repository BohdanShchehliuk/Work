package airport.service;


import airport.entity.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger addPassenger(Passenger passenger);

    List<Passenger> getAll();

    Passenger getPassengerByPassport(String passport);

    String delete(String passport) throws Exception;

    List<Passenger> getPassengerByFlightNumb(int flightNumb);

}
