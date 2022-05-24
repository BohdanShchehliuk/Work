package repository.impl;

import dao.impl.TerminalDaoImpl;
import entity.Terminal;
import repository.TerminalRepository;

import java.util.List;
import java.util.Optional;

public class TerminalRepositoryImpl implements TerminalRepository {
    @Override
    public Optional<List<Terminal>> getAll() {
        return Optional.ofNullable(new TerminalDaoImpl().getAll());
    }
}
