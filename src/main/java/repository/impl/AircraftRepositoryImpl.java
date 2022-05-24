package repository.impl;

import dao.AircraftDao;
import dao.impl.AircraftDaoImpl;
import entity.Aircraft;
import repository.AircraftRepository;

import java.util.List;
import java.util.Optional;

public class AircraftRepositoryImpl implements AircraftRepository {
    @Override
    public Optional<List<Aircraft>> getAll() {
        return Optional.ofNullable(new AircraftDaoImpl().getAll());
    }
}
