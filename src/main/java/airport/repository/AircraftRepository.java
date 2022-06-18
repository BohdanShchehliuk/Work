package airport.repository;

import airport.entity.Aircraft;
import airport.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository {
    Optional<List<Aircraft>> getAll();
    Aircraft add(Aircraft aircraft);
    Aircraft update(Aircraft aircraft);
    boolean delete(Aircraft aircraft);
    Aircraft get(int id);
}


