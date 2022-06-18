package airport.repository;

import airport.entity.Salary;
import airport.entity.Terminal;

import java.util.List;
import java.util.Optional;

public interface TerminalRepository {
    Optional <List<Terminal>> getAll();
    Terminal add(Terminal terminal);

    Terminal update(Terminal terminal);

    boolean delete(Terminal terminal);

    Terminal get(int id);

}
