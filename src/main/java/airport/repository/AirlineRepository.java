package airport.repository;

import airport.entity.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository {
    Optional<List<Airline>> getAll();
}


