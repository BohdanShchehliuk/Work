package airport.repository;

import airport.entity.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryRepository {
    Optional<List<Salary>> getAll();
}
