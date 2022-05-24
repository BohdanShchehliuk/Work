package airport.repository;

import airport.entity.AircraftTypes;

import java.util.List;
import java.util.Optional;

public interface AircraftTypesRepository {
    Optional<List<AircraftTypes>> getAll();
}
