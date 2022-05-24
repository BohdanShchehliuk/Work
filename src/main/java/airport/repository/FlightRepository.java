package airport.repository;


import airport.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightRepository {
    Optional<List<Flight>> getAll();
    Flight add(Flight flight);
    }
