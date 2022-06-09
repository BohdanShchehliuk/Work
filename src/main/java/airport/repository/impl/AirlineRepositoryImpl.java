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

    @Override
    public Airline add(Airline airline) {
        return new AirlineDaoImpl().add(airline);
    }

    @Override
    public Airline update(Airline airline) {
        return  new AirlineDaoImpl().update(airline);
    }

    @Override
    public boolean delete(Airline airline) {
        return  new AirlineDaoImpl().delete(airline);
    }

    @Override
    public Airline get(int id) {
        return  new AirlineDaoImpl().get(id);
    }
}
