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
}
