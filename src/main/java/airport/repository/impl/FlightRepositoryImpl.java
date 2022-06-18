package airport.repository.impl;

import airport.dao.impl.FlightDaoImpl;
import airport.entity.Flight;
import airport.repository.FlightRepository;

import java.util.List;
import java.util.Optional;

public class FlightRepositoryImpl implements FlightRepository {
    @Override
    public List<Flight> getAll() {
        return (new FlightDaoImpl().getAll());
    }

    @Override
    public Flight add(Flight flight) {
        return new FlightDaoImpl().add(flight);
    }

    @Override
    public Flight update(Flight flight) {
        return new FlightDaoImpl().update(flight);
    }

    @Override
    public boolean delete(Flight flight) {
        return new FlightDaoImpl().delete(flight);
    }

    @Override
    public Flight get(int id) {
        return new FlightDaoImpl().get(id);
    }
}
