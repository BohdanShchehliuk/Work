package airport.repository;

import airport.entity.Flight;
import airport.entity.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GateRepository extends JpaRepository <Gate, Integer> {
}
