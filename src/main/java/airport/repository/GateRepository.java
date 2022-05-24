package airport.repository;

import airport.entity.Gate;

import java.util.List;
import java.util.Optional;

public interface GateRepository {
    Optional<List<Gate>> getAll();
}