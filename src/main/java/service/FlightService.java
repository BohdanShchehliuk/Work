package service;

import dao.impl.FlightDaoImpl;
import entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flight addFlight(Flight flight);
   Optional<List<Flight>> getAll();
}
