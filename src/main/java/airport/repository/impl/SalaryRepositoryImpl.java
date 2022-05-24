package airport.repository.impl;

import airport.dao.impl.SalaryDaoImpl;
import airport.entity.Salary;
import airport.repository.SalaryRepository;

import java.util.List;
import java.util.Optional;

public class SalaryRepositoryImpl implements SalaryRepository {
    @Override
    public Optional<List<Salary>> getAll() {
        return Optional.ofNullable(new SalaryDaoImpl().getAll());
    }
}
