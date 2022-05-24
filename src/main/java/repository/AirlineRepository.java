package repository;

import entity.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository {
    Optional<List<Airline>> getAll();
}


