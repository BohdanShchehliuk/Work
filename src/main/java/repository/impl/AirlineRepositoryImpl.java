package repository.impl;

import dao.impl.AirlineDaoImpl;
import entity.Airline;
import repository.AirlineRepository;

import java.util.List;
import java.util.Optional;

public class AirlineRepositoryImpl implements AirlineRepository {
    @Override
    public Optional<List<Airline>> getAll() {
        return Optional.ofNullable(new AirlineDaoImpl().getAll());
    }
}
