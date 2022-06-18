package airport.repository;

import airport.entity.Flight;
import airport.entity.Gate;

import java.util.List;
import java.util.Optional;

public interface GateRepository {
    Optional<List<Gate>> getAll();
    Gate add(Gate gate);
    Gate update(Gate gate);
    boolean delete(Gate gate);
    Gate get(int id);
}
