package airport.repository;

import airport.entity.Aircraft;
import airport.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
  }


