package airport.service;


import airport.dto.PassengerDto;
import airport.entity.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger addPassenger(Passenger passenger);
    List<Passenger> getAll();
   Passenger getPassengerByPassport(String passport);
   PassengerDto byTicket(PassengerDto passengerDto, int flightId);
}
