package repository;

import entity.Terminal;

import java.util.List;
import java.util.Optional;

public interface TerminalRepository {
    Optional <List<Terminal>> getAll();
}
