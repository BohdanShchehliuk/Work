package airport.repository;


import airport.entity.Flight;
import airport.entity.Passenger;

import java.util.List;
import java.util.Optional;

public interface FlightRepository {
    List<Flight> getAll();
    Flight add(Flight flight);
    Flight update(Flight flight);
    boolean delete(Flight flight);
    Flight get(int id);
    }
