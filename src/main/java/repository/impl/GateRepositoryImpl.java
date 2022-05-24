package repository.impl;

import dao.impl.GateDaoImpl;
import entity.Gate;
import repository.GateRepository;

import java.util.List;
import java.util.Optional;

public class GateRepositoryImpl implements GateRepository {
    @Override
    public Optional<List<Gate>> getAll() {
        return Optional.ofNullable(new GateDaoImpl().getAll());
    }
}
