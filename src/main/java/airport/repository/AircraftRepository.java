package airport.repository;

import airport.entity.Aircraft;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository {
    Optional<List<Aircraft>> getAll();
}


