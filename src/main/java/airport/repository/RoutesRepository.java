package airport.repository;

import airport.entity.Routes;
import airport.entity.Routes;

import java.util.List;
import java.util.Optional;

public interface RoutesRepository {
    Optional <List<Routes>> getAll();
    Routes add(Routes routes);

    Routes update(Routes routes);

    boolean delete(Routes routes);

    Routes get(int id);
}
