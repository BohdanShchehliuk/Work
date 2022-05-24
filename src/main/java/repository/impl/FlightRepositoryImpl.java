package repository.impl;

import dao.impl.FlightDaoImpl;
import entity.Flight;
import repository.FlightRepository;

import java.util.List;
import java.util.Optional;

public class FlightRepositoryImpl implements FlightRepository {
    @Override
    public Optional<List<Flight>> getAll() {
        return Optional.ofNullable(new FlightDaoImpl().getAll());
    }

    @Override
    public Flight add(Flight flight) {
        return new FlightDaoImpl().add(flight);
    }
}
