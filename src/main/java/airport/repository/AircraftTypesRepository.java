package airport.repository;

import airport.entity.Aircraft;
import airport.entity.AircraftTypes;

import java.util.List;
import java.util.Optional;

public interface AircraftTypesRepository {
    Optional<List<AircraftTypes>> getAll();
    AircraftTypes add(AircraftTypes aircraftTypes);
    AircraftTypes update(AircraftTypes aircraftTypes);
    boolean delete(AircraftTypes aircraftTypes);
    AircraftTypes get(int id);
}
