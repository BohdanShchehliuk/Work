package airport.repository.impl;

import airport.dao.impl.AircraftDaoImpl;
import airport.entity.Aircraft;
import airport.repository.AircraftRepository;

import java.util.List;
import java.util.Optional;

public class AircraftRepositoryImpl implements AircraftRepository {
    @Override
    public Optional<List<Aircraft>> getAll() {
        return Optional.ofNullable(new AircraftDaoImpl().getAll());
    }
}
