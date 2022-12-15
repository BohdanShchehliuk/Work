package airport.repository;

import airport.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftTypesRepository extends JpaRepository<Aircraft, Integer> {

}
