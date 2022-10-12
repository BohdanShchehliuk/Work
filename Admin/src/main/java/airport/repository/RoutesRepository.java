package airport.repository;

import airport.entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutesRepository extends JpaRepository<Routes, Integer> {
}
