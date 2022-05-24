package airport.repository.impl;

import airport.dao.impl.FlightDaoImpl;
import airport.entity.Flight;
import airport.repository.FlightRepository;

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
