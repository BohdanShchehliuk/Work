package airport.repository.impl;

import airport.dao.impl.GateDaoImpl;
import airport.entity.Gate;
import airport.repository.GateRepository;

import java.util.List;
import java.util.Optional;

public class GateRepositoryImpl implements GateRepository {
    @Override
    public Optional<List<Gate>> getAll() {
        return Optional.ofNullable(new GateDaoImpl().getAll());
    }

    @Override
    public Gate add(Gate gate) {
        return new GateRepositoryImpl().add(gate);
    }

    @Override
    public Gate update(Gate gate) {
        return new GateRepositoryImpl().update(gate);
    }

    @Override
    public boolean delete(Gate gate) {
        return new GateRepositoryImpl().delete(gate);
    }

    @Override
    public Gate get(int id) {
        return new GateRepositoryImpl().get(id);
    }
}
