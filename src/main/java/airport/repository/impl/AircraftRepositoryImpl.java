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

    @Override
    public Aircraft add(Aircraft aircraft) {
        return new AircraftDaoImpl().add(aircraft);
    }

    @Override
    public Aircraft update(Aircraft aircraft) {
        return new AircraftDaoImpl().update(aircraft);
    }

    @Override
    public boolean delete(Aircraft aircraft) {
        return new AircraftDaoImpl().delete(aircraft);
    }

    @Override
    public Aircraft get(int id) {
        return new AircraftDaoImpl().get(id);
    }
}
