package airport.repository;

import airport.entity.Routes;
import airport.entity.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryRepository {
    Optional<List<Salary>> getAll();

    Salary add(Salary salary);

    Salary update(Salary salary);

    boolean delete(Salary salary);

    Salary get(int id);

}
