package airport.repository;

import airport.entity.AircraftTypes;
import airport.entity.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository {
    Optional<List<Airline>> getAll();
    Airline add(Airline airline);
    Airline update(Airline airline);
    boolean delete(Airline airline);
    Airline get(int id);
}


