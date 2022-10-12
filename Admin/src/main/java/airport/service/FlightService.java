package airport.service;

import airport.entity.Flight;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flight addFlight(Flight flight) throws UserAlreadyExistException;

    List<Flight> getAll() throws UserNotFoundException;

    List<Flight> getAllFlightsFromStartDataToFinishData(LocalDateTime startData, LocalDateTime finishData) throws UserNotFoundException;

   Optional <Flight> findFlightByFlightNumb(int flight_numb) throws UserNotFoundException;
}
