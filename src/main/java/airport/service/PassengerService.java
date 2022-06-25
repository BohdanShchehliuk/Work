package airport.service;


import airport.dto.PassengerDto;
import airport.entity.Passenger;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PassengerService {
    Passenger addPassenger(Passenger passenger);

    List<Passenger> getAll();

    Passenger getPassengerByPassport(String passport);

    PassengerDto byTicket(PassengerDto passengerDto, int flightId);

    String delete(String passport) throws Exception;

    List<Passenger> getPassengerByFlightNumb(int flightNumb);

}
