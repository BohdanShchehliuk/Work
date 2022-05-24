package repository.impl;

import dao.impl.AircraftTypesDaoImpl;
import entity.AircraftTypes;
import repository.AircraftTypesRepository;

import java.util.List;
import java.util.Optional;

public class AircraftTypesRepositoryImpl implements AircraftTypesRepository {
    @Override
    public Optional<List<AircraftTypes>> getAll() {
        return Optional.ofNullable(new AircraftTypesDaoImpl().getAll());
    }
}
