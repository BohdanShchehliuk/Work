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

    @Override
    public AircraftTypes add(AircraftTypes aircraftTypes) {
        return new AircraftTypesDaoImpl().add(aircraftTypes);
    }

    @Override
    public AircraftTypes update(AircraftTypes aircraftTypes) {
        return new AircraftTypesDaoImpl(). update(aircraftTypes);
    }

    @Override
    public boolean delete(AircraftTypes aircraftTypes) {
        return new AircraftTypesDaoImpl().delete(aircraftTypes);
    }

    @Override
    public AircraftTypes get(int id) {
        return new AircraftTypesDaoImpl().get(id);
    }
}
