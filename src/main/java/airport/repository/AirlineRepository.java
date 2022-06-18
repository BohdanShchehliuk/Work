package airport.repository;

import airport.entity.AircraftTypes;
import airport.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository extends JpaRepository <Airline, Integer> {
}


