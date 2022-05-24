package airport.repository.impl;

import airport.dao.impl.TerminalDaoImpl;
import airport.entity.Terminal;
import airport.repository.TerminalRepository;

import java.util.List;
import java.util.Optional;

public class TerminalRepositoryImpl implements TerminalRepository {
    @Override
    public Optional<List<Terminal>> getAll() {
        return Optional.ofNullable(new TerminalDaoImpl().getAll());
    }
}
