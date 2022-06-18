package airport.service;


import airport.dto.PassengerDto;
import airport.entity.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Passenger addPassenger(Passenger passenger);
    List<Passenger> getAll();
   PassengerDto getPassengerByPassport(String passport);
   PassengerDto byTicket(PassengerDto passengerDto, int flightId);
}
