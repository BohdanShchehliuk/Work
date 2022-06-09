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

    @Override
    public Terminal add(Terminal terminal) {
        return new TerminalDaoImpl().add(terminal);
    }

    @Override
    public Terminal update(Terminal terminal) {
        return new TerminalDaoImpl().update(terminal);
    }

    @Override
    public boolean delete(Terminal terminal) {
        return new TerminalDaoImpl().delete(terminal);
    }

    @Override
    public Terminal get(int id) {
        return new TerminalDaoImpl().get(id);
    }
}
