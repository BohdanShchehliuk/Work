package airport.service;


import airport.entity.Passenger;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;

import java.util.List;

public interface PassengerService {
    Passenger addPassenger(Passenger passenger) throws UserAlreadyExistException;

    List<Passenger> getAll() throws UserNotFoundException;

    Passenger getPassengerByPassport(String passport) throws UserNotFoundException;

    String delete(String passport) throws Exception;

    List<Passenger> getPassengerByFlightNumb(int flightNumb) throws UserNotFoundException;

}
