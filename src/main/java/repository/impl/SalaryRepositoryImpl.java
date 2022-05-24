package repository.impl;

import dao.impl.SalaryDaoImpl;
import entity.Salary;
import repository.SalaryRepository;

import java.util.List;
import java.util.Optional;

public class SalaryRepositoryImpl implements SalaryRepository {
    @Override
    public Optional<List<Salary>> getAll() {
        return Optional.ofNullable(new SalaryDaoImpl().getAll());
    }
}
