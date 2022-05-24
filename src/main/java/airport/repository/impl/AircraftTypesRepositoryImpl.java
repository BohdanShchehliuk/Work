package airport.repository.impl;

import airport.dao.impl.AircraftTypesDaoImpl;
import airport.entity.AircraftTypes;
import airport.repository.AircraftTypesRepository;

import java.util.List;
import java.util.Optional;

public class AircraftTypesRepositoryImpl implements AircraftTypesRepository {
    @Override
    public Optional<List<AircraftTypes>> getAll() {
        return Optional.ofNullable(new AircraftTypesDaoImpl().getAll());
    }
}
