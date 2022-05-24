package airport.repository.impl;

import airport.dao.impl.AirlineDaoImpl;
import airport.entity.Airline;
import airport.repository.AirlineRepository;

import java.util.List;
import java.util.Optional;

public class AirlineRepositoryImpl implements AirlineRepository {
    @Override
    public Optional<List<Airline>> getAll() {
        return Optional.ofNullable(new AirlineDaoImpl().getAll());
    }
}
