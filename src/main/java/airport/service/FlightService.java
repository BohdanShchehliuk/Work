package airport.service;

import airport.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);

    List<Flight> getAll();

    List<Flight> getAllFlightsFromStartDataToFinishData(LocalDateTime startData, LocalDateTime finishData);

    Flight findFlightByFlightNumb(int flight_numb);
}
