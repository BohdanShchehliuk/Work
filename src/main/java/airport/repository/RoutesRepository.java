package airport.repository;

import airport.entity.Routes;
import airport.entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoutesRepository extends JpaRepository <Routes, Integer> {
 }
