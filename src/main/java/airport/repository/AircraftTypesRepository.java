package airport.repository;

import airport.entity.Aircraft;
import airport.entity.AircraftTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AircraftTypesRepository extends JpaRepository <Aircraft, Integer> {

}
