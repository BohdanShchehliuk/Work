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

    @Override
    public Salary add(Salary salary) {
        return new SalaryDaoImpl().add(salary);
    }

    @Override
    public Salary update(Salary salary) {
        return new SalaryDaoImpl().update(salary);
    }

    @Override
    public boolean delete(Salary salary) {
        return new SalaryDaoImpl().delete(salary);
    }

    @Override
    public Salary get(int id) {
        return new SalaryDaoImpl().get(id);
    }
}
