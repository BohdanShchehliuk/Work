package airport.repository;

import airport.entity.Routes;

import java.util.List;
import java.util.Optional;

public interface RoutesRepository {
    Optional <List<Routes>> getAll();
}